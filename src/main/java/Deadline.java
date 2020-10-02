public class Deadline extends Task {
    static final String TICK = "\u2713";
    static final String CROSS = "\u2718";
    protected String completeBy;

    public Deadline(String description, String completeBy) {
        super(description);
        this.workType = 'D';
        this.completeBy = completeBy;
    }

    public String getStatusIcon() {
        return (isDone ? TICK : CROSS); //return tick or X symbols
    }

    public String printDetails() {
        return "[" + this.workType + "][" + this.getStatusIcon() + "]\t" + this.description + "(by:" + this.completeBy + ")" + "\n";
    }

    public void markAsDone() {
        isDone = true;
    }
}