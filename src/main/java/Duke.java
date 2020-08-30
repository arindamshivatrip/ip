import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    static void printHello() {
        System.out.println("\tSup! I'm Air\n" + "\tHow can I help you out today?\n");
        System.out.println("____________________________________________________________\n");
    }
    static void printTaskList(int index, Task[] Tasklist) {
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) +".  " + "["+ Tasklist[i].getStatusIcon() +"]\t" + Tasklist[i].description + "\n");
        }
    }

    public static void main(String[] args) {
        Task[] Tasklist = {};
        Tasklist = new Task[100];
        String input;
        String logo = "   _____  .__        \n"
                + "  /  _  \\ |__|______ \n"
                + " /  /_\\  \\|  \\_  __ \\\n"
                + "/    |    \\  ||  | \\/\n"
                + "\\____|__  /__||__|   \n"
                + "        \\/           \n";
        ;
        System.out.println("\tHello from\n" + logo + "\n");
        System.out.println("____________________________________________________________\n");
        printHello();
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (!(input = scanner.nextLine()).equals("exit")) {
            if (input.equals("list"))
            {
                printTaskList(index,Tasklist);
            }
            else if(input.length()>=5 && input.substring(0,4).equals("done"))
            {
                int taskNumber= Integer.parseInt(input.substring(5,6));
                Tasklist[taskNumber-1].markAsDone();
                System.out.println("Noiice! You're done with this Task. Good for you. I've marked that ure done with it.");
                System.out.println("\t["+Tasklist[taskNumber-1].getStatusIcon()+"]\t"+Tasklist[taskNumber-1].description);
            }
            else {
                System.out.println("\tTask added:\t" + input + "\n");
                Tasklist[index] = new Task(input);
                index++;
            }
            System.out.println("____________________________________________________________\n");
        }

        {
            System.out.println("\tSession Ending! Over and Out! \n");
            System.out.println("____________________________________________________________\n");
        }

    }
}
