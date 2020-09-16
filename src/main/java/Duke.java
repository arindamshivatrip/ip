import java.util.Scanner;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
public class Duke {
//    private static final Task[] listTasks = new Task[100];
    private static final ArrayList<Task> listTasks= new ArrayList<>(1);
    public static int jobCount = 0;

    /**
     * Function to print Logo and Hello
     */
    static void printHello() {
        String logo = "   _____  .__        \n"
                + "  /  _  \\ |__|______ \n"
                + " /  /_\\  \\|  \\_  __ \\\n"
                + "/    |    \\  ||  | \\/\n"
                + "\\____|__  /__||__|   \n"
                + "        \\/           \n";
        System.out.println("\tHello from\n" + logo + "\n");
        System.out.println("____________________________________________________________\n");
        System.out.println("\tSup! I'm Air\n" + "\tHow can I help you out today?\n");
        System.out.println("____________________________________________________________\n");
    }
    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }
    /**
     * Function to print the list of tasks on typing list
     */
    static void printTaskList(int index) {
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ".  " + listTasks.get(i).printDetails());
        }
    }

    /**
     * Function to create task and add it to the listTasks
     */

    static void newTask(Task userTask) {
        jobCount++;
        listTasks.add(userTask);
    }

    private static void gibberishError() throws NoSuchCommandException {
        throw new NoSuchCommandException();
    }


    public static void main(String[] args) {
        Read obj= new Read("./data");
        listTasks.addAll(obj.importedTasks);
        jobCount=obj.existingTaskCount;
        String inputCommand;
        printHello();
        Scanner scanIn = new Scanner(System.in);
        /** while loop works only till the word bye isn't typed **/
        while (!(inputCommand = scanIn.nextLine()).equals("bye")) {
//            String inputCommand = scanIn.nextLine();
            String[] splitInputs = inputCommand.split(" ", 2);
            if (inputCommand.equals("list")) {
                printTaskList(jobCount);
//                System.out.println(Task.jobCount);
            } else if (inputCommand.length() >= 4) {
                /** Above condition used to prevent code for running for nonsensical commands or for commands where no parameters are defined*/
                if (inputCommand.contains("done")) {
                    try {
                        int taskNumber = Integer.parseInt(inputCommand.substring(5, 6));
                        listTasks.get(taskNumber - 1).markAsDone();
                        System.out.println("Noiice! You're done with this Task. Good for you. I've marked that ure done with it.");
                        System.out.println("\t[" + listTasks.get(taskNumber - 1).getStatusIcon() + "]\t" + listTasks.get(taskNumber - 1).description);
                    }
                    catch (StringIndexOutOfBoundsException e)
                    {
                        System.out.println("____________________________________________________________\n" +
                                "☹ OOPS!!! The description of a " + splitInputs[0] + " cannot be empty.\n" +
                                "____________________________________________________________\n");
                    }
                }
                if (inputCommand.contains("delete")) {
                    try {
                        int taskNumber = Integer.parseInt(splitInputs[1]);
                        listTasks.remove(taskNumber-1);
                        jobCount--;
                        System.out.println("Task has been deleted. Here's the new list");
                        printTaskList(jobCount);
                    }
                    catch (StringIndexOutOfBoundsException e)
                    {
                        System.out.println("____________________________________________________________\n" +
                                "☹ OOPS!!! The description of a " + splitInputs[0] + " cannot be empty.\n" +
                                "____________________________________________________________\n");
                    }
                }
                /** To add TODO to list */

                else if ((inputCommand.contains("todo"))) {
                    try {
                        newTask(new Todo(splitInputs[1]));
                        System.out.println("____________________________________________________________");
                        System.out.println("\tTask added:\t" + listTasks.get(jobCount - 1).printDetails());
                        System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                        System.out.println("____________________________________________________________");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n" +
                                "☹ OOPS!!! The description of a " + splitInputs[0] + " cannot be empty.\n" +
                                "____________________________________________________________\n");
                    }
                }
                /** To add Deadline to list */

                else if ((inputCommand.contains("deadline"))) {
                    try {
                        String[] attributeFinder = splitInputs[1].split("/by");

                        String deadlineName = attributeFinder[0];
                        String deadlineBy = attributeFinder[1];
                        newTask(new Deadline(deadlineName, deadlineBy));
                        System.out.println("____________________________________________________________");
                        System.out.println("\tTask added:\t" + listTasks.get(jobCount - 1).printDetails());
                        System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                        System.out.println("____________________________________________________________");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n" +
                                "☹ OOPS!!! The description of a " + splitInputs[0] + " cannot be empty.\n" +
                                "____________________________________________________________\n");
                    }
                }
                /** To add event to list */
                else if ((inputCommand.contains("event"))) {
                    try {
                        String[] attributeFinder = splitInputs[1].split("/at");
                        String eventName = attributeFinder[0];
                        String eventAt = attributeFinder[1];
                        newTask(new Events(eventName, eventAt));
                        System.out.println("____________________________________________________________");
                        System.out.println("\tTask added:\t" + listTasks.get(jobCount - 1).printDetails());
                        System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                        System.out.println("____________________________________________________________");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n" +
                                "☹ OOPS!!! The description of a " + splitInputs[0] + " cannot be empty.\n" +
                                "____________________________________________________________\n");
                    }
                } else {
                    try {
                        gibberishError();
                    } catch (NoSuchCommandException e) {
                        System.out.println("____________________________________________________________\n☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n____________________________________________________________");
                    }
                }
            } else if (inputCommand.length() < 4) {
                try {
                    gibberishError();
                } catch (NoSuchCommandException e) {
                    System.out.println("____________________________________________________________\n☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n____________________________________________________________");
                }
            }
        }

        {
            String file2="data/duke.txt";
            String toOut="";
            try {
                for(Task i : listTasks)
                {
                    System.out.println("gonna do this shit");
                    char taskType=i.workType;
                    if(taskType=='T')
                    {
                        int isTodoDone = i.isDone ? 1 : 0;
                        String todoDescription=i.description;
                        toOut+=taskType+" | "+isTodoDone+" | "+todoDescription+"\n";
                    }
                    else if(taskType=='E')
                    {
                        int isEventDone = i.isDone ? 1 : 0;
                        String eventDescription=i.description;
                        String eventPrint=i.printDetails();
                        String[] splitEvent = eventPrint.split("at: ");
                        String[] splitEventTime=splitEvent[1].split("\\)");
                        toOut+=taskType+" | "+isEventDone+" | "+eventDescription+"| "+splitEventTime[0]+"\n";
                    }
                    else if(taskType=='D')
                    {
                        int isDeadlineDone = i.isDone ? 1 : 0;
                        String deadlineDescription=i.description;
                        String deadlinePrint=i.printDetails();
                        String[] splitDeadline = deadlinePrint.split("by: ");
                        String[] splitDeadlineTime=splitDeadline[1].split("\\)");
                        toOut+=taskType+" | "+isDeadlineDone+" | "+deadlineDescription+"| "+splitDeadlineTime[0]+"\n";
                    }
                    System.out.println(toOut);
                }
                writeToFile(file2, toOut);
            }
            catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
            System.out.println("\tSession Ending! Over and Out! \n");
            System.out.println("____________________________________________________________\n");
        }
    }
}