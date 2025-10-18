import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String username;
    private String password;
    private Course enrolledCourse;
    private Progress progress;
    private int points = 0;

    private List<Achievement> achievements;

    public Student(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.progress = new Progress();
        this.achievements = new ArrayList<>();
    }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void enroll(Course course) {
        this.enrolledCourse = course;
        this.progress = new Progress();
        System.out.println(name + " enrolled in: " + course.getDescription());
    }

    public void startLearning() {
        if (enrolledCourse == null) {
            System.out.println("No course enrolled.");
            return;
        }
        progress.start();
        System.out.println(name + " is starting the course...");
        enrolledCourse.deliverContent(this);
    }

    public void completeCourse() {
        if (enrolledCourse == null) {
            System.out.println("No course to complete.");
            return;
        }
        progress.complete();
        System.out.println(name + " completed the course!");

        addAchievement("First Course Completed");
        if (points >= 100) {
            addAchievement("100 Points Earned");
        }
    }

    public void addPoints(int p) {
        points += p;
    }

    public int getPoints() {
        return points;
    }

    public Progress getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void addAchievement(String title) {
        for (Achievement a : achievements) {
            if (a.getTitle().equals(title)) {
                return;
            }
        }
        achievements.add(new Achievement(title));
    }

    public void viewAchievements() {
        if (achievements.isEmpty()) {
            System.out.println("No achievements yet.");
            return;
        }

        System.out.println("Achievements:");
        for (Achievement a : achievements) {
            System.out.println(a);
        }
    }
}
