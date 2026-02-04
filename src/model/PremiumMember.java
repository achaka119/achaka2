package model;

public class PremiumMember extends Member {
    private boolean hasPersonalTrainer;
    private int guestPasses;
    public PremiumMember(int memberId, String name, String membershipType, String phoneNumber, double baseMonthlyFee, boolean hasPersonalTrainer, int guestPasses) {
        super(memberId, name, membershipType, phoneNumber, baseMonthlyFee);
        this.hasPersonalTrainer = hasPersonalTrainer;
        this.guestPasses = guestPasses;
    }

    @Override
    public double calculateMonthlyFee(){
        return 70.0;
    }

    @Override
    public void showInfo(){
        System.out.println("name: " + name + " membershipType: " + membershipType + " memberType: " + getMemberType() + " Has Personal Trainer: " + hasPersonalTrainer);
    }

    @Override
    public String getMemberType() {
        return "Premium Member";
    }

    public void accessSauna() {
        System.out.println("name: " + name + " is using sauna");
    }
}
