import java.util.Scanner;

public class Duke {
    public static int jobCount = 0;
    private static final Task[] TaskList = new Task[100];
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

    static void printTaskList(int index, Task[] TaskList) {
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ".  " + TaskList[i].printDetails());
        }
    }

    static void newTask(Task userTask) {
        jobCount++;
        TaskList[jobCount-1]=userTask;
    }

    public static void main(String[] args) {
        String inputCommand;
        printHello();
        Scanner scanIn = new Scanner(System.in);
        int index = 0;
        while (!(inputCommand = scanIn.nextLine()).equals("exit")) {
//            String inputCommand = scanIn.nextLine();
            String[] splitInputs = inputCommand.split(" ", 2);
            if (inputCommand.equals("list")) {
                printTaskList(jobCount, TaskList);
//                System.out.println(Task.jobCount);
            }
            else if(inputCommand.length() >= 5) {
                if (inputCommand.contains("done")) {
                    int taskNumber = Integer.parseInt(inputCommand.substring(5, 6));
                    TaskList[taskNumber - 1].markAsDone();
                    System.out.println("Noiice! You're done with this Task. Good for you. I've marked that ure done with it.");
                    System.out.println("\t[" + TaskList[taskNumber - 1].getStatusIcon() + "]\t" + TaskList[taskNumber - 1].description);
                }
                else if ((inputCommand.contains("todo")))
                {
                    newTask(new Todo(splitInputs[1]));
                    System.out.println("____________________________________________________________");
                    System.out.println("\tTask added:\t" + TaskList[jobCount-1].printDetails() );
                    System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                    System.out.println("____________________________________________________________");
                }
                else if ((inputCommand.contains("deadline")))
                {
                    String[] attributeFinder=splitInputs[1].split("/by");
                    String deadlineName=attributeFinder[0];
                    String deadlineBy=attributeFinder[1];
                    newTask(new Deadline(deadlineName,deadlineBy));
                    System.out.println("____________________________________________________________");
                    System.out.println("\tTask added:\t" + TaskList[jobCount-1].printDetails() );
                    System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                    System.out.println("____________________________________________________________");
                }
                else if ((inputCommand.contains("event")))
                {
                    String[] attributeFinder=splitInputs[1].split("/at");
                    String eventName=attributeFinder[0];
                    String eventAt=attributeFinder[1];
                    newTask(new Events(eventName,eventAt));
                    System.out.println("____________________________________________________________");
                    System.out.println("\tTask added:\t" + TaskList[jobCount-1].printDetails());
                    System.out.println("\tNow you have " + jobCount + " tasks in the list.\n");
                    System.out.println("____________________________________________________________");
                }
                else{
                    System.out.println("____________________________You messed up type again________________________________");
                }
            }
            System.out.println("____________________________________________________________");

        }

        {
            System.out.println("\tSession Ending! Over and Out! \n");
            System.out.println("____________________________________________________________\n");
        }

    }
}
