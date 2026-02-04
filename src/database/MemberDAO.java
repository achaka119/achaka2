package database;

import model.Member;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void insertMember(Member member) {
        String sql =
                "INSERT INTO member (name, membership_type, monthly_fee, join_date) " +
                        "VALUES ( ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, member.getName());
            statement.setString(2, member.getMembershipType());
            statement.setDouble(3, member.getBaseMonthlyFee());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
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

    public List<Member> getAllMembers() {
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
                System.out.println("monthly_fee: " + baseMonthlyFee);
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
        return null;
    }

    public boolean updateMember(Member member) {
        String sql = "UPDATE member SET name = ?, membership_type = ?, monthly_Fee = ? " +
                "WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, member.getName());
            statement.setString(2, member.getMembershipType());
            statement.setDouble(3, member.getBaseMonthlyFee());
            statement.setInt(4, member.getmemberId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println(" Member updated: " + member.getName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println(" Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public static boolean deleteMember(int MemberId) {
        String sql = "DELETE FROM member WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, MemberId);
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            if (rowsDeleted > 0) {
                System.out.println(" Member deleted (ID: " + MemberId + ")");
                return true;
            } else {
                System.out.println(" No Member found with ID: " + MemberId);
            }
        } catch (SQLException e) {
            System.out.println(" Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public Member getMemberById(int memberId) {

        String sql = "SELECT * FROM member WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, memberId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Member member = new Member(
                        resultSet.getInt("member_id"),
                        resultSet.getString("name"),
                        resultSet.getString("membership_type"),
                        resultSet.getDouble("monthly_fee")
                );

                resultSet.close();
                statement.close();
                return member;
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }


    public List<Member> searchByName(String name) {

        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT * FROM member WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Member member = new Member(
                        resultSet.getInt("member_id"),
                        resultSet.getString("name"),
                        resultSet.getString("membership_type"),
                        resultSet.getDouble("monthly_Fee")
                );

                memberList.add(member);
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + memberList.size() + " member(s)");

        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();

        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return memberList;
    }

    public List<Member> searchByFeeRange(double minFee, double maxFee) {
        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT * FROM member " +
                "WHERE baseMonthlyFee BETWEEN ? AND ? " +
                "ORDER BY baseMonthlyFee DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minFee);
            statement.setDouble(2, maxFee);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Member member = new Member(
                        resultSet.getInt("member_id"),
                        resultSet.getString("name"),
                        resultSet.getString("membership_type"),
                        resultSet.getDouble("monthly_Fee")
                );

                memberList.add(member);
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + memberList.size() + " member(s)");

        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();

        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return memberList;
    }

    public List<Member> searchByMinFee(double minFee) {
        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT * FROM member " + "WHERE baseMonthlyFee >= ? " + "ORDER BY baseMonthly Fee DESC";

        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minFee);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Member member = new Member(
                        resultSet.getInt("member_id"),
                        resultSet.getString("name"),
                        resultSet.getString("membership_type"),
                        resultSet.getDouble("monthly_fee")
                );
                memberList.add(member);
        }
            resultSet.close();
            statement.close();

            System.out.println("Found " + memberList.size() + " member(s) with fee >= " + minFee);

        } catch (SQLException e) {
            System.out.println("Search by minimum fee failed!");
            e.printStackTrace();

        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return memberList;
    }

}


