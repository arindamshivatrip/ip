import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> listTasks= new ArrayList<>(1);
    protected int jobCount = 0;
    public TaskList(ArrayList<Task> importList,int jobCount)
    {
        this.listTasks.addAll(importList);
        this.jobCount=jobCount;
    }
    public  void addTask(Task task)
    {
        this.listTasks.add(task);
        this.jobCount++;
    }
    public  void delTask(int intTaskToDel)
    {
        this.listTasks.remove(intTaskToDel-1);
        this.jobCount--;
    }
    public  void doneTask(int intTaskDone)
    {
        this.listTasks.get(intTaskDone-1).markAsDone();
    }
    public ArrayList<Task> taskFinder(String findEx)
    {
        ArrayList<Task> matchList= new ArrayList<>(0);
        for(Task i:this.listTasks)
        {
            if(i.description.contains(findEx))
            {
                matchList.add(i);
            }
        }
        return matchList;

    }
}