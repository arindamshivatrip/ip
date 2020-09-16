import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static ArrayList<Task> importedTasks = new ArrayList<>(1);
    protected String pathName = "./data";
    protected int existingTaskCount = 0;
    protected boolean isFolderThere = false;
    protected boolean isFileThere = false;

    public Read(String pathName) {
        this.pathName = pathName;
        try {
            existenceChecker();
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

    }

    public void existenceChecker() throws IOException {
        File dirFile = new File(this.pathName);
        if (dirFile.isDirectory()) {
            File textFile = new File(pathName + "/duke.txt");
            if (textFile.createNewFile()) {
                System.out.println("File does not already exist");
            } else {
                System.out.println("File already exists. Previous tasks will be imported.");
                try {
                    dataExtractor(textFile);
                } catch (IOException e) {
                    System.err.println("Failed to create directory!" + e.getMessage());
                }
            }
        }
        else {
            Path path = Paths.get(pathName);
            Files.createDirectories(path);
            File textFile = new File(pathName + "/duke.txt");
            if (textFile.createNewFile()) {
                System.out.println("File does not already exist");
            } else {
                System.out.println("File already exists. Previous tasks will be imported.");
                try {
                    dataExtractor(textFile);
                } catch (IOException e) {
                    System.err.println("Failed to create directory!" + e.getMessage());
                }
            }
        }

    }

    public boolean numToBool(int num) {
        if (num==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void dataExtractor(File textFile) throws IOException {
        Scanner myReader = new Scanner(textFile);
        while (myReader.hasNextLine()) {
            String taskData = myReader.nextLine();
            String[] splitTaskData = taskData.split(" \\| ");
            System.out.println(splitTaskData);
            for(String i:splitTaskData)
            {
                System.out.println(i);
            }
            System.out.println(taskData);
            if (splitTaskData[0].equals("T")) {
                importedTasks.add(new Todo(splitTaskData[2]));
                String isDoneString=splitTaskData[1];
                System.out.println(isDoneString);
                boolean isComplete = numToBool(Integer.parseInt(isDoneString));
                System.out.println("works so far!");
                importedTasks.get(existingTaskCount).isDone = isComplete;
                existingTaskCount++;
            } else if (splitTaskData[0].equals("E")) {
                importedTasks.add(new Events(splitTaskData[2], splitTaskData[3]));
                boolean isComplete = numToBool(Integer.parseInt(splitTaskData[1]));
                importedTasks.get(existingTaskCount).isDone = isComplete;
                existingTaskCount++;
            } else if (splitTaskData[0].equals("D")) {
                importedTasks.add(new Deadline(splitTaskData[2], splitTaskData[3]));
                boolean isComplete = numToBool(Integer.parseInt(splitTaskData[1]));
                importedTasks.get(existingTaskCount).isDone = isComplete;
                existingTaskCount++;

            }
        }
    }
}