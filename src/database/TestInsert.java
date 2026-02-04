package database;

import model.Member;

import java.util.List;

public class TestInsert {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();

        List<Member> result = dao.searchByName("aigerim");

        for (Member m : result) {
            System.out.println(m);
        }
    }
}
