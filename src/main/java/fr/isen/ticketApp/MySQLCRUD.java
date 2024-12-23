package fr.isen.ticketApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MySQLCRUD {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ticketApp2024";
    private static final String USER = "root2";
    private static final String PASSWORD = "MySQLP4SSw0Rd!";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public List<Map<String, Object>> getAll(String tableName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Map<String, Object> getById(String tableName, String idColumn, int id) {
        Map<String, Object> resultMap = new HashMap<>();
        String query = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                if (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        resultMap.put(metaData.getColumnName(i), rs.getObject(i));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public boolean insert(String tableName, Map<String, Object> data) {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (String key : data.keySet()) {
            columns.append(key).append(",");
            values.append("?,");
        }

        columns.setLength(columns.length() - 1); // Remove last comma
        values.setLength(values.length() - 1); // Remove last comma

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            int index = 1;
            for (String key : data.keySet()) {
                pstmt.setObject(index++, data.get(key));
            }

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String tableName, String idColumn, int id, Map<String, Object> data) {
        StringBuilder setClause = new StringBuilder();

        for (String key : data.keySet()) {
            setClause.append(key).append(" = ?,");
        }

        setClause.setLength(setClause.length() - 1); // Remove last comma

        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + idColumn + " = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            int index = 1;
            for (String key : data.keySet()) {
                pstmt.setObject(index++, data.get(key));
            }
            pstmt.setInt(index, id);

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String tableName, String idColumn, int id) {
        String query = "DELETE FROM " + tableName + " WHERE " + idColumn + " = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
