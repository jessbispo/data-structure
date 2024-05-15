//Jessica Bispo, 42277833, 40710798

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskControl {

    public static void startNextTask(Queue<String> taskQueue) {
        if (!taskQueue.isEmpty()) {
            String nextTask = taskQueue.dequeue();
            System.out.println("Starting next task: " + nextTask + "\n");
        } else {
            System.out.println("There is no task in the queue.\n");
        }
    }

    public static void insertTask(Scanner scanner, Queue<String> taskQueue) {
        System.out.print("Enter the description of the new task: ");
        scanner.nextLine();
        String newTask = scanner.nextLine();

        System.out.println("After reading input: " + newTask);

        taskQueue.enqueue(newTask);
        System.out.println("Task '" + newTask + "' inserted in the queue.\n");
    }

    public static void checkNextTask(Queue<String> taskQueue) {
        if (!taskQueue.isEmpty()) {
            String nextTask = taskQueue.front();
            System.out.println("Next task in the queue: " + nextTask + "\n");
        } else {
            System.out.println("There is no task in the queue.\n");
        }
    }

    public static void displayRemainingTasks(Queue<String> taskQueue) {
        System.out.println("Number of tasks still to be done: " + taskQueue.size() + " (of a maximum of "+ taskQueue.capacity() + ")" + "\n");
    }

    public static void removeAllTasks(Queue<String> taskQueue) {
        taskQueue.clear();
        System.out.println("All tasks were removed from the queue.\n");
    }

        
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter capacity of Queue");
        int capacity = scanner.nextInt();
        Queue<String> taskQueue = new Queue<>(capacity);
        String currentTask;
        
        int choice = 0; 
        
        do {
            currentTask = taskQueue.front();
    
            System.out.println("*** TASK CONTROL ***");
            System.out.println("1 - Start the next task in the queue.");
            System.out.println("2 - Insert a task in the queue.");
            System.out.println("3 - Check which is the next task in the queue.");
            System.out.println("4 - Display how many tasks remain to be done.");
            System.out.println("5 - Remove all tasks from the queue.");
            System.out.println("6 - Exit.");
            System.out.println(">>> Current task: " + currentTask + " <<<");
            System.out.print("Choose an option: ");
            
            try {
                choice = scanner.nextInt(); 
    
                switch (choice) {
                    case 1:
                        TaskControl.startNextTask(taskQueue);
                        break;
                    case 2:
                        TaskControl.insertTask(scanner, taskQueue);
                        break;
                    case 3:
                        TaskControl.checkNextTask(taskQueue);
                        break;
                    case 4:
                        TaskControl.displayRemainingTasks(taskQueue);
                        break;
                    case 5:
                        TaskControl.removeAllTasks(taskQueue);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer choice.");
                scanner.next(); 
            }
        } while (choice != 6);
    
        scanner.close();
    }
}

//https://www.deepl.com/translator not related to Queue but whenever i needed help with translation i used this application called deepl, found it better than google translation
// https://pt.stackoverflow.com/questions/507845/uso-do-nextline-em-java --> this really helped me with some simple doubt, that was because nextLine wasnt running how i wanted it to run, but it worked after adding one more as answered  
//problems to be solved: choice variable not being accepted in while -- `teste` not being accepted in the option and falling in the exception -> trying to add a catch so the exception will turn the loop agains
//ADD CAPACITY TO GET A INPUT