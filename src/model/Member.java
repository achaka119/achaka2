package model;

public class Member {
    protected int memberId;
    protected String name;
    protected String membershipType;
    protected String phoneNumber;
    protected double baseMonthlyFee;

    public Member(int memberId, String name, String membershipType, String phoneNumber, double baseMonthlyFee) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.phoneNumber = phoneNumber;
        this.baseMonthlyFee = baseMonthlyFee;
    }

    public double calculateMonthlyFee() {
        return 50.0;
    }

    public String getMemberType() {
        return "regular member";
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void showInfo() {
        System.out.println("name: " + name + " membershipType: " + membershipType + " memberType: " + getMemberType());
    }

    public int getmemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }



    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", membershipType=" + membershipType +
                ", phoneNumber=" + phoneNumber +
                ", baseMonthlyFee=" + baseMonthlyFee +
                '}';
    }
}