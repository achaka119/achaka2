package model;

public class Member {
    protected int memberId;
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected double baseMonthlyFee;

    public Member(int memberId, String name, int age, String phoneNumber, double baseMonthlyFee) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.baseMonthlyFee = baseMonthlyFee;
    }

    public double calculateMonthlyFee() {
        return 50.0;
    }

    public String getMemberType() {
        return "regular member";
    }

    public void showInfo() {
        System.out.println("name: " + name + " age: " + age + " memberType: " + getMemberType());
    }

    public boolean isAdult() {
        return age >= 25;
    }

    @Override
    public String toString() {
        return "model.Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", baseMonthlyFee=" + baseMonthlyFee +
                '}';
    }
}
