public class Deadline extends Task {
    protected String completeBy;
    protected boolean isDone;


    public Deadline(String description,String completeBy) {
        super(description);
        this.workType = 'D';
        this.completeBy=completeBy;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String printDetails(){return "["+this.workType+"]["+this.getStatusIcon()+"]\t"+this.description+"(by:"+this.completeBy+")"+"\n";}

}