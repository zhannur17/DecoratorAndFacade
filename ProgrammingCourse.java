import java.util.Scanner;

class ProgrammingCourse implements Course {
    public void deliverContent(Student student) {
        System.out.println("Module 1: Variables and Data Types");
        student.addPoints(30);

        System.out.println("Module 2: Loops and Conditions");
        student.addPoints(30);

        System.out.println("Module 3: OOP Basics");
        student.addPoints(20);

        System.out.println("You have completed all modules in Programming!");

        System.out.println("\nFinal Test: What keyword is used to create a class in Java?");
        System.out.print("Your answer: ");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("class")) {
            System.out.println("Correct! +15 bonus points.");
            student.addPoints(15);
        } else {
            System.out.println("Incorrect. No bonus.");
        }
    }

    public String getDescription() {
        return "Programming Course";
    }

    public int getBasePoints() {
        return 55;
    }
}

