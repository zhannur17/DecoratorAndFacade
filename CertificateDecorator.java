class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course course) {
        super(course);
    }

    public void deliverContent(Student student) {
        course.deliverContent(student);
        System.out.println("Certificate will be granted after completion.");
    }

    public String getDescription() {
        return course.getDescription() + " + Certificate";
    }
}