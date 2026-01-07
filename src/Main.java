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
        while(running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewAllMembers();
                    break;
                case 3:
                    addTrainer();
                    break;
                case 4:
                    viewAllTrainers();
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
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    public static void addMember() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter active: (true/false): ");
        boolean active = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter Membership: (basic or premium): ");
        String membership = scanner.nextLine();

        Membership selected;
        if(membership.equals("basic")){
            selected = basic;
        } else {
            selected = premium;
        }

        Member member = new Member(Id, name, age, active, selected);
        members.add(member);

        System.out.println("\n Member added successfully!");
    }

    public static void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println(" ALL MENU ITEMS");
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
        }
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
}

