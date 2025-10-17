class StudentPortalFacade {
    private Student student;
    private static Student leaderboardTopper = null;

    public StudentPortalFacade(Student student) {
        this.student = student;
    }

    public void enrollInCourse(Course course) {
        student.enroll(course);
    }

    public void startLearning() {
        student.startLearning();
    }

    public void showProgress() {
        String status = student.getProgress().getStatus();
        System.out.println("Your current course progress: " + status);
    }

    public void showPoints() {
        System.out.println("Total points earned: " + student.getPoints());
    }

    public void completeCourse() {
        student.completeCourse();
        System.out.println("Progress: " + student.getProgress().getStatus());

        if (leaderboardTopper == null || student.getPoints() > leaderboardTopper.getPoints()) {
            leaderboardTopper = student;
        }
    }

    public void showLeaderboard() {
        if (leaderboardTopper != null) {
            System.out.println("\n=== Leaderboard ===");
            System.out.println("Topper: " + leaderboardTopper.getName() + " - " + leaderboardTopper.getPoints() + " points");
            System.out.println("You: " + student.getName() + " - " + student.getPoints() + " points");
        }
    }
}