package database;

import model.Member;

public class TestInsert {
    public static void main(String[] args) {
       // Member member = new Member(2, "Ali", "Student",  "35335", 67.9 );
        MemberDAO dao = new MemberDAO();
        dao.getAllMember();
       // dao.insertMember(member);
    }
}