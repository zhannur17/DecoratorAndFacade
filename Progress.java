class Progress {
    private String status = "Not Started";

    public void start() {
        status = "In Progress";
    }

    public void complete() {
        status = "Completed";
    }

    public String getStatus() {
        return status;
    }
}