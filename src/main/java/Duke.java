import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
public class Duke {
    static void printHello(){
        System.out.println(" Sup! I'm Air\n" + "How can I help you out today?\n");
        System.out.println("____________________________________________________________\n");
    }
    public static void main(String[] args) {
        String input;
        String logo ="   _____  .__        \n"
                     +"  /  _  \\ |__|______ \n"
                     +" /  /_\\  \\|  \\_  __ \\\n"
                     +"/    |    \\  ||  | \\/\n"
                     +"\\____|__  /__||__|   \n"
                     +"        \\/           \n";                ;
        System.out.println("Hello from\n" + logo + "\n");
        System.out.println("____________________________________________________________\n");
        printHello();
        Scanner scanner = new Scanner(System.in);
        while(!(input = scanner.next()).equals("exit"))
        {
            System.out.println(input+"\n");
            System.out.println("____________________________________________________________\n");
        }

        {
            System.out.println("Session Ending! Over and Out! \n");
            System.out.println("____________________________________________________________\n");
        }

    }
}
