import java.util.ArrayList;

public class Parser {
    protected String userInput;
    protected Task thisTask;
    public Parser(String userInput)
    {
        this.userInput=userInput;
    }
    public String inputTypeIdentifier()
    {
        String[] splitInputs = this.userInput.split(" ", 2);
        if (this.userInput.equals("list")) {
            return "list";
        }
        else if (this.userInput.contains("delete")) {
            return "delete";
        }
        else if (this.userInput.contains("done")) {
            return "done";
        }
        else if (this.userInput.contains("find")) {
            return "find";
        }
        else if (this.userInput.contains("todo"))
        {
            return "todo";
        }
        else if (this.userInput.contains("deadline"))
        {
            return "deadline";
        }
        else if (this.userInput.contains("event"))
        {
            return "event";
        }
        else
        {
            return "error";
        }
    }

    public  int doneOrDelNum()
    {
        String[] splitInputs = this.userInput.split(" ", 2);
        int taskNumber = Integer.parseInt(splitInputs[1]);
        return taskNumber;
    }
    public  String findExp()
    {
        String[] splitInputs = this.userInput.split(" ", 2);
        String findExpression = splitInputs[1];
        return findExpression;
    }
    public String todoDesc()
    {
        String[] splitInputs = this.userInput.split(" ", 2);
        String todoDescription=splitInputs[1];
        return todoDescription;
    }
    public ArrayList<String> attributesExtractor(char type)
    {
        ArrayList<String> eventAttr= new ArrayList<>(1);
        String[] splitInputs = this.userInput.split(" ", 2);
        switch(type) {
            case 'E':
            {
                String[] attributeFinder = splitInputs[1].split("/at");
                String eventName = attributeFinder[0];
                eventAttr.add(eventName);
                String eventAt = attributeFinder[1];
                eventAttr.add(eventAt);
            }
            case 'D':
            {

                String[] attributeFinder = splitInputs[1].split("/by");
                String deadlineName = attributeFinder[0];
                eventAttr.add(deadlineName);
                String deadlineBy = attributeFinder[1];
                eventAttr.add(deadlineBy);
            }
            default:return eventAttr;
        }
    }
}