package org.example.basis.stirng.stringBuilder;

import java.util.StringJoiner;

public class Test2 {

    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql(table, fields);

        String joiner = buildInsertSqlByStringJoiner(table,fields);
        System.out.println(joiner);

        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        for (String field : fields) {
            sb.append(field).append(", ");
        }

        return "INSERT INTO " + table + " (" + sb.toString().substring(0, sb.toString().length() - 2) + ")" + " VALUES (?, ?, ?)";
    }

    static String buildInsertSqlByStringJoiner(String table, String[] fields) {
        // TODO:
        StringJoiner sb = new StringJoiner("= ","Hello","1");
        for (String field : fields) {
            sb.add(field);
        }

        return "INSERT INTO " + table + " (" + sb.toString() + ")" + " VALUES (?, ?, ?)";
    }
}
