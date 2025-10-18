class CustomCourseFactory implements CourseFactory {
    private boolean addCert, addMentor, addGame;
    private Course base;

    public CustomCourseFactory(Course base, boolean addCert, boolean addMentor, boolean addGame) {
        this.base = base;
        this.addCert = addCert;
        this.addMentor = addMentor;
        this.addGame = addGame;
    }

    public Course createCourse() {
        Course c = base;
        if (addCert) c = new CertificateDecorator(c);
        if (addMentor) c = new MentorSupportDecorator(c);
        if (addGame) c = new GamificationDecorator(c);
        return c;
    }
}
