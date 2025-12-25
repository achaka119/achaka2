public class Member {
    private int memberId;
    private String name;
    private int age;
    private boolean active;
    private Membership membership;

    public Member(int memberId, String name, int age, boolean active, Membership membership) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.active = active;
        this.membership = membership;
    }

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { if (age > 0) this.age = age; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Membership getMembership() { return membership; }
    public void setMembership(Membership membership) { this.membership = membership; }

    public boolean canEnterGym() {
        return active && membership != null && membership.isActive();
    }

    public void upgradeMembership(Membership newMembership) {
        if (!active) {
            System.out.println("Upgrade failed: member is inactive.");
            return;
        }
        if (newMembership == null || !newMembership.isActive()) {
            System.out.println("Upgrade failed: new membership is invalid/inactive.");
            return;
        }
        this.membership = newMembership;
        System.out.println("Upgrade success: " + name + " -> " + newMembership.getName());
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", membership=" + (membership != null ? membership.getName() : "None") +
                '}';
    }
}
