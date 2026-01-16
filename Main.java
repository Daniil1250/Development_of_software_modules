    import java.util.*;


    public class Main {
        public static void main (String[] args) 
        {
        System.out.println("=== Мои заметки ===");
        
        TodoList todoList = new TodoList();
        
        todoList.addTask("Купить молоко");
        todoList.addTask("Купить хлеб");
        todoList.addTask("Покормить кота");

        todoList.showAllTask();

        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        todoList.showAllTasks();
        
        System.out.println("\n=== ПОИСК ===");
        todoList.searchTasks("Java");
        todoList.searchTasks("Купить молоко");
        } 
    }


    class Task{
        int id;
        String text;
        boolean isCompleted;


        Task(int id, String text){
            this.id = id;
            this.text = text;
            this.isCompleted = false;
        } 

        void display(){
            String status = isCompleted ? "Yes" : "[ ]";

            System.out.println(id + ". " + status + " " + text);
        } 
    }




    class TodoList {
        private ArrayList<Task> tasks = new ArrayList<>();


        private int nextId = 1;

        void addTask(String text){
            Task newTask = new Task(nextId, text);

            tasks.add(newTask);

            nextId++;

            System.out.println("Добавлена задача: \"" + text + "\"");
        }


        void showAllTask(){
            System.out.println("==== Ваши задачи ====");

            if(tasks.isEmpty()){
                System.out.println("Список задач пуст. Добавьте новую задачу!");
                return;
            }

            for(Task task : tasks){
                task.display();
            }


            System.out.println("\n Всего задач: " + tasks.size());
        }


        }



