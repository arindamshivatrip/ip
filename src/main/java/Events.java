public class Events extends Task {
    protected String eventAt;
    protected boolean isDone;


    public Events(String description,String eventAt) {
        super(description);
        this.workType = 'E';
        this.eventAt=eventAt;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String printDetails() {
        return "[" + this.workType+"][" + this.getStatusIcon()+"]\t" + this.description + "(at:"+this.eventAt+")" + "\n";}
    public void markAsDone() {
        this.isDone = true;
    }
}