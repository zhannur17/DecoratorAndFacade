class GamificationDecorator extends CourseDecorator {
    public GamificationDecorator(Course course) {
        super(course);
    }

    public void deliverContent(Student student) {
        course.deliverContent(student);
        System.out.println("Gamification active! Points awarded: 50");
    }

    public String getDescription() {
        return course.getDescription() + " + Gamification";
    }
}