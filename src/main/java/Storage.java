import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public ArrayList<Task> importedTasks = new ArrayList<>(1);
    protected String pathName = "./data";
    protected int existingTaskCount = 0;
    protected boolean isFolderThere = false;
    protected boolean isFileThere = false;

    public Storage(String pathName) {
        this.pathName = pathName;
        try {
            existenceChecker();
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
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
        } else {
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

    public void fileWriter(ArrayList<Task> listTask) throws IOException {
        String filePath = this.pathName + "/duke.txt";
        String toOut = "";
        try {
            for (Task i : listTask) {
                char taskType = i.workType;
                if (taskType == 'T') {
                    int isTodoDone = i.isDone ? 1 : 0;
                    String todoDescription = i.description;
                    toOut += taskType + "|" + isTodoDone + "|" + todoDescription + "\n";
                } else if (taskType == 'E') {
                    int isEventDone = i.isDone ? 1 : 0;
                    String eventDescription = i.description;
                    String eventPrint = i.printDetails();
                    String[] splitEvent = eventPrint.split("at:");
                    String[] splitEventTime = splitEvent[1].split("\\)");
                    toOut += taskType + "|" + isEventDone + "|" + eventDescription + "|" + splitEventTime[0] + "\n";
                } else if (taskType == 'D') {
                    int isDeadlineDone = i.isDone ? 1 : 0;
                    String deadlineDescription = i.description;
                    String deadlinePrint = i.printDetails();
                    String[] splitDeadline = deadlinePrint.split("by:");
                    String[] splitDeadlineTime = splitDeadline[1].split("\\)");
                    toOut += taskType + "|" + isDeadlineDone + "|" + deadlineDescription + "|" + splitDeadlineTime[0] + "\n";
                }
            }
            writeToFile(filePath, toOut);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public boolean numToBool(int num) {
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void dataExtractor(File textFile) throws IOException {
        Scanner myReader = new Scanner(textFile);
        while (myReader.hasNextLine()) {
            String taskData = myReader.nextLine();
            String[] splitTaskData = taskData.split("\\|");
            for (String i : splitTaskData) {
                i = i.trim();
            }
            if (splitTaskData[0].equals("T")) {
                importedTasks.add(new Todo(splitTaskData[2]));
                String isDoneString = splitTaskData[1];
                boolean isComplete = numToBool(Integer.parseInt(isDoneString));
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