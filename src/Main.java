public class Main {
    public static void main(String[] args) {

        System.out.println("-----SECTION 1: CREATE MEMBERSHIPS-----");
        Membership basic = new Membership(1, "Basic", 30.0, 1, true);
        Membership premium = new Membership(2, "Premium", 60.0, 3, true);
        System.out.println(basic);
        System.out.println(premium);

        System.out.println("\n-----SECTION 2: MEMBERSHIP LOGIC-----");
        System.out.println("Basic total cost: " + basic.totalCost());
        premium.applyDiscount(10); // 10% discount
        System.out.println("Premium after discount: " + premium);
        System.out.println("Premium total cost: " + premium.totalCost());

        System.out.println("\n-----SECTION 3: CREATE MEMBER-----");
        Member m1 = new Member(101, "Aruzhan", 19, true, basic);
        System.out.println(m1);
        System.out.println("Can enter gym? " + m1.canEnterGym());

        System.out.println("\n-----SECTION 4: MEMBER UPGRADE-----");
        m1.upgradeMembership(premium);
        System.out.println("After upgrade: " + m1);

        System.out.println("\n-----SECTION 5: WORKOUT SESSION-----");
        WorkoutSession s1 = new WorkoutSession(501, m1, "Trainer Dias", 45, false);
        System.out.println(s1);
        System.out.println("Can session start? " + s1.canStart());

        s1.extend(15);
        System.out.println("After extend: " + s1);

        s1.complete();
        System.out.println("After complete: " + s1);
        System.out.println("Can session start now? " + s1.canStart());

        System.out.println("\n-----SECTION 6: EDGE CASE TEST-----");
        Member inactiveMember = new Member(102, "Timur", 16, false, basic);
        WorkoutSession s2 = new WorkoutSession(502, inactiveMember, "Trainer Amina", 30, false);
        System.out.println(inactiveMember);
        System.out.println(s2);
        System.out.println("Can inactive member start session? " + s2.canStart());
    }
}
