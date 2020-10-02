public class Events extends Task {
    static final String TICK = "\u2713";
    static final String CROSS = "\u2718";
    protected String eventAt;

    public Events(String description, String eventAt) {
        super(description);
        this.workType = 'E';
        this.eventAt = eventAt;
    }

    public String getStatusIcon() {
        return (isDone ? TICK : CROSS); //return tick or X symbols
    }

    public String printDetails() {
        return "[" + this.workType + "][" + this.getStatusIcon() + "]\t" + this.description + "(at:" + this.eventAt + ")" + "\n";
    }

    public void markAsDone() {
        this.isDone = true;
    }
}