import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Membership basic = new Membership(1, "Basic", 30.0, 1, true);
    private static Membership premium = new Membership(2, "Premium", 60.0, 3, true);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMemberGeneral();
                    break;
                case 2:
                    addStudentMember();
                    break;
                case 3:
                    addPremiumMember();
                    break;
                case 4:
                    viewAllMembers();
                case 5:
                    makeAllMembersShowInfo();
                    break;
                case 6:
                    viewStudentMembersOnly();
                    break;
                case 7:
                    viewPremiumMembersOnly();
                    break;
                case 0:
                    System.out.println("\n Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("Gym System");
        System.out.println("========================================");
        System.out.println("1. Add Member (General)");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. View All Members (Polymorphic)");
        System.out.println("5. Make All Members show INFO (Polymorphism Demo)");
        System.out.println("6. View Student Members Only");
        System.out.println("7. View Premium Members Only");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    public static void addMemberGeneral() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        Member member = new Member(Id, name, age, phoneNumber, baseMonthlyFee);
        members.add(member);

        System.out.println("\n General Member added successfully!");
    }

    public static void addStudentMember() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD STUDENT MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter University name: ");
        String universityName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Member member = new StudentMember(Id, name, age, phoneNumber, baseMonthlyFee, universityName, studentId);
        members.add(member);

        System.out.println("\n Student Member added successfully!");
    }

    public static void addPremiumMember() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD PREMIUM MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Has Personal Trainer: ");
        boolean hasPersonalTrainer = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter Guest Pass: ");
        int guestPass = scanner.nextInt();
        scanner.nextLine();

        Member member = new PremiumMember(Id, name, age, phoneNumber, baseMonthlyFee, hasPersonalTrainer, guestPass);
        members.add(member);

        System.out.println("\n Premium Member added successfully!");
    }

    public static void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println(" ALL MEMBERS (POLYMORPHIC LIST)");
        System.out.println("========================================");
        if(members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        System.out.println("Total members: " + members.size());
        System.out.println();

        for(int i = 0; i < members.size(); i++) {
            Member m = members.get(i);

            System.out.println((i + 1 ) + ". " + m);

            if (m instanceof StudentMember) {
                StudentMember student = (StudentMember) m;
                System.out.println("students pays: " + student.calculateMonthlyFee());
            } else if (m instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) m;
                    System.out.println("premium members pays" + premiumMember.calculateMonthlyFee());
            }
            System.out.println();
        }
    }

    public static void makeAllMembersShowInfo() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling showInfo() on all members:");
        System.out.println();

        for (Member s : members) {
            s.showInfo();
        }
        System.out.println();
        System.out.println(" Notice: Same method name (Info), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }

    public static void addTrainer() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD TRAINER ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter years of experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Trainer trainer = new Trainer(Id, name, age, experience, specialization, salary);
        trainers.add(trainer);

        System.out.println("\n Trainer added successfully!");
    }

    private static void viewAllTrainers() {
        System.out.println("\n========================================");
        System.out.println("            ALL TRAINERS                ");
        System.out.println("========================================");

        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }

        System.out.println("Total trainers: " + trainers.size());
        System.out.println();

        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);
            System.out.println((i + 1) + ". " + t);
        }
    }

    private static void viewStudentMembersOnly() {
        System.out.println("\n========================================");
        System.out.println(" STUDENTS ONLY");
        System.out.println("========================================");
        int studentCount = 0;
        for (Member s : members) {
            if (s instanceof StudentMember) {
                StudentMember student = (StudentMember) s;
                studentCount++;
                System.out.println(studentCount + ". " + student);
                System.out.println();
            }
        }
        if (studentCount == 0) {
            System.out.println("No students found.");
        }
    }

    private static void viewPremiumMembersOnly() {
        System.out.println("\n========================================");
        System.out.println(" PREMIUMS ONLY");
        System.out.println("========================================");
        int premiumCount = 0;
        for (Member s : members) {
            if (s instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) s;
                premiumCount++;
                System.out.println(premiumCount + ". " + premiumMember);
                System.out.println();
            }
        }
        if (premiumCount == 0) {
            System.out.println("No Premium members11 found.");
        }
    }
}

