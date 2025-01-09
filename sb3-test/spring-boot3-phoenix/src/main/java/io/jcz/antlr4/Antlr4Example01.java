package io.jcz.antlr4;

import org.apache.phoenix.parse.SQLParser;
import org.apache.phoenix.parse.SelectStatement;

import java.sql.SQLException;

public class Antlr4Example01 {
    public static void main(String[] args) throws SQLException {
        SQLParser parser = new SQLParser("select * from test");

        SelectStatement selectStatement = parser.parseQuery();

    }
}
