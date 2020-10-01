import java.util.Scanner;
import java.util.*;
import java.io.IOException;
public class Duke {

    static private void writeUtil(Storage store,ArrayList<Task> listTasks)
    {
        try {
            store.fileWriter(listTasks);
        }
        catch(IOException e)
        {
            System.out.println("IO ERROR! ");
        }
    }
    static void print(String str) {
        System.out.println(str);
    }
    static public void main(String[] args) {
        Storage store= new Storage("./data");
        TaskList Tasks=new TaskList(store.importedTasks,store.existingTaskCount);
        String inputCommand;
        UI.helloPrinter();
        Scanner scanIn = new Scanner(System.in);
        /** while loop works only till the word bye isn't typed **/
        while (!(inputCommand = scanIn.nextLine()).equals("bye")) {
            Parser parser=new Parser(inputCommand);
            String inputType= parser.inputTypeIdentifier();
            switch (inputType){
                case "error":
                    UI.gibberishError();
                    break;
                case "list":
                {
                    writeUtil(store, Tasks.listTasks);
                    UI.printTaskList(Tasks.listTasks,Tasks.jobCount);
                    break;
                }
                case "done":
                {
                    try{
                        int taskNumber = parser.doneOrDelNum();
                        Tasks.doneTask(taskNumber);
                        UI.doneAck(Tasks.listTasks.get(taskNumber - 1));
                        print("\t[" + Tasks.listTasks.get(taskNumber - 1).getStatusIcon() + "]\t" + Tasks.listTasks.get(taskNumber - 1).description);
                        writeUtil(store, Tasks.listTasks);

                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("done");
                    }
                    break;
                }
                case "find":
                {
                    try
                    {
                        String findExp=parser.findExp();
                        print(findExp);
                        ArrayList<Task> matchTask= new ArrayList<>(0);
                        matchTask.addAll(Tasks.taskFinder(findExp));
                        for(Task i:matchTask)
                        {
                            i.printDetails();
                        }
                        UI.printMatch(matchTask);
                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("done");
                    }
                    break;
                }
                case "delete":
                {
                    try{
                        int taskNumber = parser.doneOrDelNum();
                        Tasks.delTask(taskNumber);
                        UI.deleteAck();
                        UI.printTaskList(Tasks.listTasks,Tasks.jobCount);
                        writeUtil(store, Tasks.listTasks);
                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("delete");
                    }
                    break;
                }
                case "todo":
                {
                    try
                    {
                        String todoDesc=parser.todoDesc();
                        if(todoDesc.trim().isEmpty())
                        {
                            UI.ErrorAck("T");
                            break;
                        }
                        Tasks.addTask(new Todo(todoDesc));
                        UI.addAck(Tasks.listTasks.get(Tasks.jobCount - 1),Tasks.jobCount);
                        writeUtil(store, Tasks.listTasks);
                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("T");
                    }
                    break;
                }
                case "event":
                {
                    try
                    {
                        ArrayList<String> eventAttr = parser.attributesExtractor('E');
                        if(eventAttr.get(0).trim().isEmpty()|eventAttr.get(1).trim().isEmpty())
                        {
                            UI.ErrorAck("E");
                        }
                        Tasks.addTask(new Events(eventAttr.get(0),eventAttr.get(1)));
                        UI.addAck(Tasks.listTasks.get(Tasks.jobCount - 1),Tasks.jobCount);
                        writeUtil(store, Tasks.listTasks);
                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("E");
                    }
                    break;
                }
                case "Deadline":
                {
                    try
                    {
                        ArrayList<String> deadlineAttr = parser.attributesExtractor('D');
                        if(deadlineAttr.get(0).trim().isEmpty()|deadlineAttr.get(1).trim().isEmpty())
                        {
                            UI.ErrorAck("E");
                            break;
                        }
                        Tasks.addTask(new Events(deadlineAttr.get(0),deadlineAttr.get(1)));
                        UI.addAck(Tasks.listTasks.get(Tasks.jobCount - 1),Tasks.jobCount);
                        writeUtil(store, Tasks.listTasks);
                    }
                    catch (NumberFormatException| IndexOutOfBoundsException e)
                    {
                        UI.ErrorAck("E");
                    }
                    break;
                }
            }
        }
        {
            UI.bye();
            writeUtil(store, Tasks.listTasks);
        }
    }
}

