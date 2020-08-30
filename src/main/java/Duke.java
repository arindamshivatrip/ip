import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Duke {
    static void printHello(){
        System.out.println("\t Sup! I'm Air\n" + "\tHow can I help you out today?\n");
        System.out.println("____________________________________________________________\n");
    }
    public static void main(String[] args) {
        List Tasks = new ArrayList();
        String input;
        String logo ="   _____  .__        \n"
                     +"  /  _  \\ |__|______ \n"
                     +" /  /_\\  \\|  \\_  __ \\\n"
                     +"/    |    \\  ||  | \\/\n"
                     +"\\____|__  /__||__|   \n"
                     +"        \\/           \n";                ;
        System.out.println("\tHello from\n" + logo + "\n");
        System.out.println("____________________________________________________________\n");
        printHello();
        Scanner scanner = new Scanner(System.in);
        while(!(input = scanner.nextLine()).equals("exit"))
        {
//            System.out.println("____________________________________________________________\n");
            if(!input.equals("list")){
                System.out.println("Task added:\t"+input+"\n");
                Tasks.add(input);
            }
            else if(input.equals("list"))
            {
                int TasksLength=Tasks.size();
                for(int i=0; i<TasksLength;i++)
                {
                    System.out.println(i+".\t"+Tasks.get(i)+"\n");
                }
            }

            System.out.println("____________________________________________________________\n");
        }

        {
            System.out.println("\tSession Ending! Over and Out! \n");
            System.out.println("____________________________________________________________\n");
        }

    }
}
