import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    TaskService service = new TaskService();

    @Test
    void testAddTask() {
        service.addTask(new Task(1, "Study", "Pending"));
        assertEquals(1, service.getAllTasks().size());
    }

    @Test
    void testUpdateTask() {
        service.addTask(new Task(2, "Old", "Pending"));
        service.updateTask(2, "New", "Done");

        Task t = service.getAllTasks().iterator().next();
        assertEquals("Done", t.getStatus());
    }

    @Test
    void testDeleteTask() {
        service.addTask(new Task(3, "Delete", "Pending"));
        service.deleteTask(3);

        assertTrue(service.getAllTasks().isEmpty());
    }
}