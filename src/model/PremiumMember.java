package model;

public class PremiumMember extends Member {
    private boolean hasPersonalTrainer;
    private int guestPasses;
    public PremiumMember(int memberId, String name, int age, String phoneNumber, double baseMonthlyFee, boolean hasPersonalTrainer, int guestPasses) {
        super(memberId, name, age, phoneNumber, baseMonthlyFee);
        this.hasPersonalTrainer = hasPersonalTrainer;
        this.guestPasses = guestPasses;
    }

    @Override
    public double calculateMonthlyFee(){
        return 70.0;
    }

    @Override
    public void showInfo(){
        System.out.println("name: " + name + " age: " + age + " memberType: " + getMemberType() + " Has Personal model.Trainer: " + hasPersonalTrainer);
    }

    @Override
    public String getMemberType() {
        return "Premium model.Member";
    }

    public void accessSauna() {
        System.out.println("name: " + name + " is using sauna");
    }
}
