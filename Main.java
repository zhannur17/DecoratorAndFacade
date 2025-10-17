import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student registeredStudent = null;

        while (true) {
            System.out.println("\nWelcome to LMS");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Choose username: ");
                String username = scanner.nextLine();
                System.out.print("Choose password: ");
                String password = scanner.nextLine();
                registeredStudent = new Student(name, username, password);
                System.out.println("Registered successfully!");

            } else if (choice == 2) {
                if (registeredStudent == null) {
                    System.out.println("No student registered yet.");
                    continue;
                }

                System.out.print("Username: ");
                String uname = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();

                if (registeredStudent.login(uname, pass)) {
                    System.out.println("Login successful. Welcome, " + registeredStudent.getName());
                    StudentPortalFacade portal = new StudentPortalFacade(registeredStudent);

                    System.out.println("Select a course:");
                    System.out.println("1 - Math");
                    System.out.println("2 - Programming");
                    int courseChoice = scanner.nextInt();
                    scanner.nextLine();

                    Course baseCourse;
                    if (courseChoice == 1) {
                        baseCourse = new MathCourse();
                    } else {
                        baseCourse = new ProgrammingCourse();
                    }

                    System.out.println("Select enhancements (Y/N):");
                    System.out.print("Add Certificate? ");
                    String cert = scanner.nextLine();
                    System.out.print("Add Mentor Support? ");
                    String mentor = scanner.nextLine();
                    System.out.print("Add Gamification? ");
                    String game = scanner.nextLine();

                    if (cert.equalsIgnoreCase("Y")) {
                        baseCourse = new CertificateDecorator(baseCourse);
                    }
                    if (mentor.equalsIgnoreCase("Y")) {
                        baseCourse = new MentorSupportDecorator(baseCourse);
                    }
                    if (game.equalsIgnoreCase("Y")) {
                        baseCourse = new GamificationDecorator(baseCourse);
                    }

                    portal.enrollInCourse(baseCourse);

                    System.out.println("\nStart Learning");
                    portal.startLearning();

                    System.out.println("\nComplete Course");
                    portal.completeCourse();

                    System.out.println("\nLeaderboard");
                    portal.showLeaderboard();

                } else {
                    System.out.println("Invalid login!");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }

        scanner.close();
    }
}