public class Task {
    protected static int jobCount = 0;
    protected char workType;
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.workType = 'T';
        this.description = description;
//        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String printDetails() {
        return "[" + this.workType + "][" + this.getStatusIcon() + "]\t" + this.description + "\n";
    }

    public void markAsDone() {
        this.isDone = true;
    }
}