public class Todo extends Task {
    protected static int jobCount = 0;
    protected char workType;
    protected String description;
    protected boolean isDone;


    public Todo(String description) {
        super(description);
        this.workType='T';
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String printDetails(){return "["+this.workType+"]["+this.getStatusIcon()+"]\t"+this.description+"\n";}

}