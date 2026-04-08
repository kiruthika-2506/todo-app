import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskService service = new TaskService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Update 3.Delete 4.View 5.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    service.addTask(new Task(id, title, "Pending"));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Title: ");
                    String newTitle = sc.next();
                    System.out.print("Status: ");
                    String status = sc.next();
                    service.updateTask(uid, newTitle, status);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    service.deleteTask(did);
                    break;

                case 4:
                    for (Task t : service.getAllTasks()) {
                        System.out.println(
                            t.getId() + " " + t.getTitle() + " " + t.getStatus()
                        );
                    }
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
