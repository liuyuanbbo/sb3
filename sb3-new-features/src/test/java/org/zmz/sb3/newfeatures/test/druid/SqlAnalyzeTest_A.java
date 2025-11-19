package org.zmz.sb3.newfeatures.test.druid;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class SqlAnalyzeTest_A {

    @Test
    public void t1() {
        String sql = """
                CREATE TABLE IF NOT EXISTS jcz_t1
                (
                    id           INT        NOT NULL,
                    hire_month   VARCHAR(6) NOT NULL,
                    user_name    VARCHAR(50),
                    age          SMALLINT,
                    salary       BIGINT,
                    bonus        DECIMAL(10,2),
                    score        DOUBLE,
                    birth_date   DATE,
                    is_full_time BOOLEAN,
                    hire_time    TIMESTAMP,
                    department   VARCHAR(50),
                    PRIMARY KEY (id, hire_month),
                    SHARD KEY(id,hire_month)
                )
                    COMMENT = 'RapidsDB 测试表，主键非空，包含分区字段';
                """;

        RapidsDBSqlPreprocessor.PreprocessResult rs = RapidsDBSqlPreprocessor.preprocess(sql);
        String processedSql = rs.getProcessedSql();

        log.info("{}", processedSql);
        log.info("{}", rs.getShardKeyColumns());

        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, DbType.mysql);

        log.info("<<<解析完成>>>");
    }

}
