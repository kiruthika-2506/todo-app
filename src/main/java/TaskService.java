
import java.util.*;

public class TaskService {

    private Map<Integer, Task> tasks = new HashMap<>();

    // ADD TASK
    public void addTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            throw new RuntimeException("Task already exists!");
        }
        tasks.put(task.getId(), task);
    }

    // UPDATE TASK
    public void updateTask(int id, String title, String status) {
        if (!tasks.containsKey(id)) {
            throw new RuntimeException("Task not found!");
        }
        Task t = tasks.get(id);
        t.setTitle(title);
        t.setStatus(status);
    }

    // DELETE TASK
    public void deleteTask(int id) {
        if (!tasks.containsKey(id)) {
            throw new RuntimeException("Task not found!");
        }
        tasks.remove(id);
    }

    // GET ALL TASKS
    public Collection<Task> getAllTasks() {
        return tasks.values();
    }
}
