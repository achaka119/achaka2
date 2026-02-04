package database;

import model.Member;

import java.sql.*;
import java.time.LocalDate;

public class MemberDAO {
    public void insertMember(Member member) {
        String sql =
                "INSERT INTO member (member_id, name, membership_type, monthly_fee, join_date) " + "VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, member.getmemberId());
            statement.setString(2, member.getName());
            statement.setString(3, member.getMembershipType());
            statement.setDouble(4, member.getBaseMonthlyFee());
            statement.setDate(5, Date.valueOf(LocalDate.now()));
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Member inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllMember() {
        String sql = "SELECT * FROM member";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ALL MEMBER FROM DATABASE ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("member_id");
                String name = resultSet.getString("name");
                String membershipType = resultSet.getString("membership_type");
                double baseMonthlyFee = resultSet.getDouble("monthly_fee");
                Date joinDate = resultSet.getDate("join_date");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("membershipType: " + membershipType);
                System.out.println("baseMonthlyFee: " + baseMonthlyFee);
                System.out.println("joinDate: " + joinDate);
                System.out.println("---");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


}