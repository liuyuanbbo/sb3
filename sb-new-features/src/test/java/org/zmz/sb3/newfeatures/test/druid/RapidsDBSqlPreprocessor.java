package org.zmz.sb3.newfeatures.test.druid;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RapidsDBSqlPreprocessor {

    @Getter
    public static class PreprocessResult {
        private final String processedSql;
        private final String shardKeyColumns;

        public PreprocessResult(String processedSql, String shardKeyColumns) {
            this.processedSql = processedSql;
            this.shardKeyColumns = shardKeyColumns;
        }

    }

    public static PreprocessResult preprocess(String sql) {
        String shardKeyColumns = extractShardKeyColumns(sql);
        String processedSql = removeShardKeyAndFixCommas(sql);
        return new PreprocessResult(processedSql, shardKeyColumns);
    }

    private static String extractShardKeyColumns(String sql) {
        Pattern pattern = Pattern.compile("SHARD\\s+KEY\\s*\\(([^)]+)\\)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

    private static String removeShardKeyAndFixCommas(String sql) {
        String result = sql;

        Pattern pattern1 = Pattern.compile(",\\s*SHARD\\s+KEY\\s*\\([^)]+\\)", Pattern.CASE_INSENSITIVE);
        result = pattern1.matcher(result).replaceAll("");
        Pattern pattern2 = Pattern.compile("SHARD\\s+KEY\\s*\\([^)]+\\)", Pattern.CASE_INSENSITIVE);
        result = pattern2.matcher(result).replaceAll("");
        result = fixCommaIssues(result);

        return result.trim();
    }

    private static String fixCommaIssues(String sql) {
        String result = sql;

        result = result.replaceAll(",\\s*,", ",");

        result = result.replaceAll(",\\s*\\)", ")");

        result = result.replaceAll(",\\s*\\n\\s*\\)", "\n)");

        return result;
    }
}