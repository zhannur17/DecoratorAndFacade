class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course course) {
        super(course);
    }

    public void deliverContent(Student student) {
        course.deliverContent(student);
    }

    public String getDescription() {
        return course.getDescription() + " + Certificate";
    }

}
