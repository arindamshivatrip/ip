public class Todo extends Task {
    static final String TICK = "\u2713";
    static final String CROSS = "\u2718";
    protected static int jobCount = 0;
    protected char workType;

    public Todo(String description) {
        super(description);
        this.workType = 'T';
    }

    public String getStatusIcon() {
        return (isDone ? TICK : CROSS); //return tick or X symbols
    }

    public String printDetails() {
        return "[" + this.workType + "][" + this.getStatusIcon() + "]\t" + this.description + "\n";
    }

    public void markAsDone() {
        this.isDone = true;
    }
}