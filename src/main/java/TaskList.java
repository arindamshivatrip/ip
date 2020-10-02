import java.util.ArrayList;

public class TaskList {
    protected int jobCount = 0;
    ArrayList<Task> listTasks = new ArrayList<>(1);

    public TaskList(ArrayList<Task> importList, int jobCount) {
        this.listTasks.addAll(importList);
        this.jobCount = jobCount;
    }
    /**
     * A  function that adds to the listTasks
     */
    public void addTask(Task task) {
        this.listTasks.add(task);
        this.jobCount++;
    }
    /**
     * A  function that removes the tasks from listTasks
     */
    public void delTask(int intTaskToDel) {
        this.listTasks.remove(intTaskToDel - 1);
        this.jobCount--;
    }
    /**
     * A  function that marks the task at a specified index as being done
     */
    public void doneTask(int intTaskDone) {
        this.listTasks.get(intTaskDone - 1).markAsDone();
    }
    /**
     * A  function that finds the tasks in the Arraylist whose description contains words/letters from a given string
     */
    public ArrayList<Task> taskFinder(String findEx) {
        ArrayList<Task> matchList = new ArrayList<>(0);
        for (Task i : this.listTasks) {
            if (i.description.contains(findEx)) {
                matchList.add(i);
            }
        }
        return matchList;

    }
}