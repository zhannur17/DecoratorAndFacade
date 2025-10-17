class Student {
    private String name;
    private String username;
    private String password;
    private Course enrolledCourse;
    private Progress progress;
    private int points = 0;

    public Student(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.progress = new Progress();
    }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void enroll(Course course) {
        this.enrolledCourse = course;
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
}