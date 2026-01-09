package org.zmz.sb3.newfeatures.test.druid;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.alibaba.druid.sql.dialect.oracle.parser.OracleStatementParser;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleOutputVisitor;
import com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGOutputVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SqlRewriter {

    private static final Set<String> EXCLUDE_COLUMNS = Set.of("consume_org_id", "consume_path_code");

    public enum DbType {
        MYSQL, POSTGRESQL, ORACLE
    }

    public static String rewriteSql(String sql, boolean includeOrgFields, DbType dbType) {
        if (includeOrgFields || sql == null || sql.trim().isEmpty()) {
            return sql;
        }

        SQLStatement stmt = parseSql(sql, dbType);
        if (!(stmt instanceof SQLSelectStatement selectStmt)) {
            return sql;
        }

        var queryBlock = selectStmt.getSelect().getQueryBlock();
        if (queryBlock == null) return sql;

        // 过滤字段
        List<SQLSelectItem> filtered = new ArrayList<>();
        List<SQLSelectItem> selectList = queryBlock.getSelectList();
        for (SQLSelectItem item : selectList) {
            String alias = item.getAlias();
            if (alias == null || !EXCLUDE_COLUMNS.contains(alias.toLowerCase())) {
                filtered.add(item);
            }
        }

        selectList.clear();
        selectList.addAll(filtered);

        return outputSql(stmt, dbType);
    }

    private static SQLStatement parseSql(String sql, DbType dbType) {
        return switch (dbType) {
            case POSTGRESQL -> new PGSQLStatementParser(sql).parseStatement();
            case ORACLE -> new OracleStatementParser(sql).parseStatement();
            default -> new MySqlStatementParser(sql).parseStatement();
        };
    }

    private static String outputSql(SQLStatement stmt, DbType dbType) {
        StringBuilder out = new StringBuilder();
        switch (dbType) {
            case POSTGRESQL:
                stmt.accept(new PGOutputVisitor(out));
                break;
            case ORACLE:
                stmt.accept(new OracleOutputVisitor(out));
                break;
            case MYSQL:
            default:
                stmt.accept(new MySqlOutputVisitor(out));
        }
        return out.toString();
    }

    static void main() {
        String SAMPLE_SQL = """
                SELECT
                    CAST('7084' AS VARCHAR) AS consume_org_id,
                    CAST('-1.7084.' AS VARCHAR) AS consume_path_code,
                    COUNT(tb1.prod_inst_id) AS prod_inst_id_count
                FROM smart_test.dwd_prod_inst_d tb1
                INNER JOIN smart_test.dim_zd_org_branch_tree_path_cude tb2 
                    ON tb1.branch_code_5 = tb2.common_region_id
                WHERE 
                    tb2.path_code LIKE '%-1.7084.%'
                    AND (CAST(tb1.day_id AS BIGINT) = '20251113')
                """;
        SqlRewriter.DbType type = SqlRewriter.DbType.valueOf(DbType.MYSQL.name());
        String rs = SqlRewriter.rewriteSql(SAMPLE_SQL, false, type);
        System.out.println(rs);
    }
}