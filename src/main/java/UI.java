import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UI {
    String myName;

    public UI() {
        myName="myName";
    }
    static void print(String str) {
        System.out.println(str);
    }
    /**
     * Function to print Logo and Hello
     */
    public static void helloPrinter() {
        String logo = "   _____  .__        \n"
                + "  /  _  \\ |__|______ \n"
                + " /  /_\\  \\|  \\_  __ \\\n"
                + "/    |    \\  ||  | \\/\n"
                + "\\____|__  /__||__|   \n"
                + "        \\/           \n";

        print("\tHello from\n" + logo + "\n");
        print("____________________________________________________________\n");
        print("\tSup! I'm Air\n" + "\tHow can I help you out today?\n");
        print("____________________________________________________________\n");
    }
    public static void doneAck(Task task) {
        print("Noiice! You're done with this Task. Good for you. I've marked that ure done with it.");
        print("\t[" + task.getStatusIcon() + "]\t" + task.description);
    }
    public static void deleteAck() {
        print("Task has been deleted. Here's the new list");
    }
    public static void addAck(Task task,int jobCount) {
        String taskDescription = task.printDetails();
        print("____________________________________________________________");
        print("\tTask added:\t" + taskDescription);
        print("\tNow you have " + jobCount + " tasks in the list.\n");
        print("____________________________________________________________");
    }
    public static void bye() {
        print("See you later Alligator!");
        print("Task has been deleted. Here's the new list");
    }
    public static void ErrorAck(String typeChar){
        switch (typeChar){
            case "done":
                print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of done cannot be empty and must be an integer. Or this task number does not exist\n" +
                        "____________________________________________________________\n");
                break;
            case "delete":
                print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of delete cannot be empty and must be an integer.\n" +
                        "____________________________________________________________\n");
                break;
            case "E":
                print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of an event cannot be empty.\n" +
                        "____________________________________________________________\n");
                break;
            case "D":
                print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a deadline cannot be empty.\n" +
                        "____________________________________________________________\n");
                break;
            case "T":
                print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a todo cannot be empty.\n" +
                        "____________________________________________________________\n");
                break;

        }
    }
    public static void gibberishError(){
        try {
            throw new NoSuchCommandException();
        }
        catch (NoSuchCommandException e)
        {
            print("____________________________________________________________\n☹ hi OOPS!!! I'm sorry, but I don't know what that means :-(\n____________________________________________________________");
        }
    }
    public static void printTaskList(ArrayList<Task> listTasks,int jobCount){
        for (int i = 0; i < jobCount; i++) {
            print((i + 1) + ".  " + listTasks.get(i).printDetails());
        }
    }
}