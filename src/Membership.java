public class Membership {
    private int membershipId;
    private String name;
    private double monthlyFee;
    private int durationMonths;
    private boolean active;

    public Membership(int membershipId, String name, double monthlyFee, int durationMonths, boolean active) {
        this.membershipId = membershipId;
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.durationMonths = durationMonths;
        this.active = active;
    }

    public int getMembershipId() { return membershipId; }
    public void setMembershipId(int membershipId) { this.membershipId = membershipId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(double monthlyFee) { if (monthlyFee >= 0) this.monthlyFee = monthlyFee; }

    public int getDurationMonths() { return durationMonths; }
    public void setDurationMonths(int durationMonths) { if (durationMonths > 0) this.durationMonths = durationMonths; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double totalCost() {
        return monthlyFee * durationMonths;
    }

    public void applyDiscount(double percent) {
        if (percent <= 0 || percent > 50) return; // simple rule
        monthlyFee = monthlyFee * (1 - percent / 100.0);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", monthlyFee=" + monthlyFee +
                ", durationMonths=" + durationMonths +
                ", active=" + active +
                '}';
    }
}
