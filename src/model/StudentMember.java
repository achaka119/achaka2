package model;

public class StudentMember extends Member {
    private String universityName;
    private String studentId;

    public StudentMember(int memberId, String name, String membershipType, String phoneNumber, double baseMonthlyFee, String universityName, String studentId) {
        super(memberId, name, membershipType, phoneNumber, baseMonthlyFee);
        this.universityName = universityName;
        this.studentId = studentId;
    }

    @Override
    public double calculateMonthlyFee() {
        return 30.0;
    }

    @Override
    public String getMemberType() {
        return "student member";
    }

    @Override
    public void showInfo() {
        System.out.println("name: " + name + " membershipType: " + membershipType + " memberType: " + getMemberType() + " University name: " + universityName);
    }

    public String showStudentCard() {
        return "student name: " + name + " Student ID: " + studentId + " University name: " + universityName;
    }
}
