class MentorSupportDecorator extends CourseDecorator {
    public MentorSupportDecorator(Course course) {
        super(course);
    }

    public void deliverContent(Student student) {
        course.deliverContent(student);
    }

    public String getDescription() {
        return course.getDescription() + " + Mentor Support";
    }

}
