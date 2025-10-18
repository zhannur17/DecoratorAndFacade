import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

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

                boolean exists = false;
                for (Student s : students) {
                    if (s.getUsername().equals(username)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Username already exists.");
                } else {
                    students.add(new Student(name, username, password));
                    System.out.println("Registered successfully!");
                }

            } else if (choice == 2) {
                System.out.print("Username: ");
                String uname = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();

                Student loggedInStudent = null;
                for (Student s : students) {
                    if (s.login(uname, pass)) {
                        loggedInStudent = s;
                        break;
                    }
                }

                if (loggedInStudent != null) {
                    System.out.println("Login successful. Welcome, " + loggedInStudent.getName());
                    StudentPortalFacade portal = new StudentPortalFacade(loggedInStudent);

                    System.out.println("Select a course:");
                    System.out.println("1 - Math");
                    System.out.println("2 - Programming");
                    int courseChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Select enhancements (Y/N):");
                    System.out.print("Add Certificate? ");
                    String cert = scanner.nextLine();
                    System.out.print("Add Mentor Support? ");
                    String mentor = scanner.nextLine();
                    System.out.print("Add Gamification? ");
                    String game = scanner.nextLine();

                    Course baseCourse = (courseChoice == 1) ? new MathCourse() : new ProgrammingCourse();

                    CourseFactory factory = new CustomCourseFactory(
                            baseCourse,
                            cert.equalsIgnoreCase("Y"),
                            mentor.equalsIgnoreCase("Y"),
                            game.equalsIgnoreCase("Y")
                    );

                    Course course = factory.createCourse();
                    portal.enrollInCourse(course);

                    while (true) {
                        System.out.println("\n--- LMS Menu ---");
                        System.out.println("1. Start Learning");
                        System.out.println("2. Complete Course");
                        System.out.println("3. View Progress");
                        System.out.println("4. View Points");
                        System.out.println("5. Show Leaderboard");
                        System.out.println("6. Exit to Main Menu");
                        System.out.println("7. View Achievements");
                        System.out.print("Choose option: ");
                        int action = scanner.nextInt();
                        scanner.nextLine();

                        if (action == 1) {
                            portal.startLearning();
                        } else if (action == 2) {
                            portal.completeCourse();
                        } else if (action == 3) {
                            System.out.println("Progress: " + loggedInStudent.getProgress().getStatus());
                        } else if (action == 4) {
                            System.out.println("Points: " + loggedInStudent.getPoints());
                        } else if (action == 5) {
                            portal.showLeaderboard();
                        } else if (action == 6) {
                            System.out.println("Exiting to main menu...");
                            break;
                        } else if (action == 7) {
                            loggedInStudent.viewAchievements();
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }

                } else {
                    System.out.println("Invalid login.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
