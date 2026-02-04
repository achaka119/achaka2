package menu;

import exception.InvalidInputException;
import model.*;

import java.lang.classfile.instruction.BranchInstruction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import database.MemberDAO;


public class MenuManager implements Menu {
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private static MemberDAO memberDAO = new MemberDAO();



    @Override
    public void displayMenu() {
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
            System.out.println("8. Add Personal Trainers");
            System.out.println("9. Add Group Trainers");
            System.out.println("10. View All Trainers");
            System.out.println("===================DATABASE=====================");
            System.out.println("11. Update Member");
            System.out.println("12. Delete Member");
            System.out.println("13. Search Member by Name");
            System.out.println("14. Search Member by Fee Range");
            System.out.println("15. Search Member by Minimum Fee");

        System.out.println("0. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();

        try {
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
                    break;
                case 5:
                    makeAllMembersShowInfo();
                    break;
                case 6:
                    viewStudentMembersOnly();
                    break;
                case 7:
                    viewPremiumMembersOnly();
                    break;
                case 8:
                    addPersonalTrainer();
                    break;
                case 9:
                    addGroupTrainer();
                    break;
                case 10:
                    viewAllTrainers();
                    break;
                case 11:
                    updateMember();
                    break;
                case 12:
                    deleteMember();
                    break;
                case 13:
                    searchMemberByName();
                    break;
                case 14:
                    searchByFeeRange();
                    break;
                case 15:
                    searchByMinFee();
                    break;

                case 0:
                    System.out.println("\n Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Please enter a NUMBER.");
        }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void addMemberGeneral() {

        System.out.println("\n--- ADD MEMBER ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter membershipType: ");
        String membershipType = scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        Member member = new Member(0, name, membershipType, baseMonthlyFee);
        memberDAO.insertMember(member);

        System.out.println("Member added to database!");
    }


    public static void addStudentMember() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD STUDENT MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter membershipType: ");
        String membershipType = scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter University name: ");
        String universityName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Member member = new StudentMember(Id, name, membershipType, baseMonthlyFee, universityName, studentId);
        memberDAO.insertMember(member);

        System.out.println("\n Student model.Member added successfully!");
    }

    public static void addPremiumMember() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD PREMIUM MEMBERS ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter membershipType: ");
        String  membershipType= scanner.nextLine();

        System.out.print("Enter baseMonthlyFee: ");
        double baseMonthlyFee = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Has Personal model.Trainer: ");
        boolean hasPersonalTrainer = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter Guest Pass: ");
        int guestPass = scanner.nextInt();
        scanner.nextLine();

        Member member = new PremiumMember(Id, name, membershipType, baseMonthlyFee, hasPersonalTrainer, guestPass);
        memberDAO.insertMember(member);

        System.out.println("\n Premium Member added successfully!");
    }

    public static void viewAllMembers() {

        System.out.println("\n=== ALL MEMBERS ===");

        List<Member> members = memberDAO.getAllMembers();

        if (members == null || members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member m : members) {
            System.out.println(m);
        }
    }

    private static void updateMember() {
        System.out.print("Enter Member ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Member member = memberDAO.getMemberById(id);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println("Current: " + member);

        System.out.print("New name: ");
        member.setName(scanner.nextLine());

        System.out.print("New membership type: ");
        member.setMembershipType(scanner.nextLine());

        System.out.print("New base monthly fee: ");
        member.setBaseMonthlyFee(scanner.nextDouble());
        scanner.nextLine();

        memberDAO.updateMember(member);
    }

    private static void deleteMember() {
        System.out.print("Enter Member ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Member member = memberDAO.getMemberById(id);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println(member);
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            memberDAO.deleteMember(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static void searchMemberByName() {
        System.out.print("Enter name keyword: ");
        String name = scanner.nextLine();

        List<Member> members = memberDAO.searchByName(name);
        members.forEach(System.out::println);
    }

    private static void searchByFeeRange() {
        System.out.print("Enter minimum fee: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum fee: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Member> members = memberDAO.searchByFeeRange(min, max);
        members.forEach(System.out::println);
    }

    private static void searchByMinFee() {
        System.out.print("Enter minimum fee: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        List<Member> members = memberDAO.searchByMinFee(min);
        members.forEach(System.out::println);
    }


    public static void makeAllMembersShowInfo() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling showInfo() on all members:");
        System.out.println();

        List<Member> members = memberDAO.getAllMembers();
        for (Member s : members) {
            s.showInfo();
        }
        System.out.println();
        System.out.println(" Notice: Same method name (Info), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }

    public static void addPersonalTrainer() {
        try {
            Random random = new Random();
            int Id = random.nextInt();
            System.out.println("\n--- ADD PERSONAL TRAINER ---");
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

            Trainer trainer = new PersonalTrainer(Id, name, age, experience, salary, specialization);
            trainers.add(trainer);

            System.out.println("\n PersonalTrainer added successfully!");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: please enter valid numbers for age/experience/salary.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addGroupTrainer() {
        Random random = new Random();
        int Id = random.nextInt();
        System.out.println("\n--- ADD GROUP TRAINER ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter years of experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter maxGroupSize: ");
        int maxGroupSize = scanner.nextInt();
        scanner.nextLine();

        Trainer trainer = new GroupTrainer(Id, name, age, experience, salary, maxGroupSize);
        trainers.add(trainer);

        System.out.println("\n GroupTrainer added successfully!");
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
       int Studentcount = 0;

       List<Member> members = memberDAO.getAllMembers();
       for (Member s: members) {
           if (s instanceof StudentMember){
               StudentMember student = (StudentMember) s;
               Studentcount++;
               System.out.println(Studentcount + ". " + student);
               System.out.println();
           }
       }
       if (Studentcount == 0) {
           System.out.println("No students found.");
       }
    }

    private static void viewPremiumMembersOnly() {

        System.out.println("\n========================================");
        System.out.println(" PREMIUMS ONLY");
        System.out.println("========================================");

        List<Member> members = memberDAO.getAllMembers();
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
            System.out.println("No Premium members found.");
        }
    }
}
