import java.util.Scanner;

class MathCourse implements Course {
    public void deliverContent(Student student) {
        System.out.println("Module 1: Algebra Basics");
        student.addPoints(30);

        System.out.println("Module 2: Geometry Fundamentals");
        student.addPoints(30);

        System.out.println("Module 3: Basic Calculus");
        student.addPoints(30);

        System.out.println("You have completed all modules in Math!");
        System.out.println("\nFinal Test: What is 2 + 2?");
        System.out.print("Your answer: ");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if (answer.equals("4")) {
            System.out.println("Correct! +10 bonus points.");
            student.addPoints(10);
        } else {
            System.out.println("Incorrect. No bonus.");
        }
    }

    public String getDescription() {
        return "Math Course";
    }

    public int getBasePoints() {
        return 40;
    }
}

