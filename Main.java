import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== МОИ ЗАМЕТКИ ===");
        
        TodoList todoList = new TodoList();
        
     
        todoList.addTask("Купить молоко");
        todoList.addTask("Сделать домашку по Java");
        todoList.addTask("Позвонить маме");
        todoList.addTask("Почитать книгу по программированию");
        
    
        todoList.showAllTasks();
        
        
        System.out.println("\n=== ТЕСТИРУЕМ ФУНКЦИОНАЛ ===");
        todoList.completeTask(2);
        todoList.deleteTask(1);
        
     
        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        todoList.showAllTasks();
        
      
        System.out.println("\n=== ПОИСК ===");
        todoList.searchTasks("Java");
        todoList.searchTasks("книгу");
    }
}

class Task {
    int id;
    String text;
    boolean isCompleted;
    
    Task(int id, String text) {
        this.id = id;
        this.text = text;
        this.isCompleted = false;
    }
    
    void display() {
        String status = isCompleted ? "[✓]" : "[ ]";
        System.out.println(id + ". " + status + " " + text);
    }
}

class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;
    
    void addTask(String text) {
        Task newTask = new Task(nextId, text);
        tasks.add(newTask);
        nextId++;
        System.out.println("✅ Добавлена: \"" + text + "\"");
    }
    
    void showAllTasks() {
        System.out.println("\n=== ВАШИ ЗАДАЧИ ===");
        if (tasks.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        
        for (Task task : tasks) {
            task.display();
        }
        System.out.println("\n📊 Всего: " + tasks.size() + " задач");
    }
    
    void completeTask(int taskId) {
        for (Task task : tasks) {
            if (task.id == taskId) {
                task.isCompleted = true;
                System.out.println("🎉 Задача #" + taskId + " выполнена!");
                return;
            }
        }
        System.out.println("⚠️ Задача #" + taskId + " не найдена");
    }
    
    void deleteTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == taskId) {
                String text = tasks.get(i).text;
                tasks.remove(i);
                System.out.println("Удалена: \"" + text + "\"");
                return;
            }
        }
        System.out.println("⚠️ Задача #" + taskId + " не найдена");
    }
    
 
    void searchTasks(String keyword) {
        System.out.println("\n🔍 Поиск: \"" + keyword + "\"");
        int foundCount = 0;
        
      
        for (Task task : tasks) {
          
            if (task.text.toLowerCase().contains(keyword.toLowerCase())) {
                task.display();
                foundCount++;
            }
        }
        
        if (foundCount == 0) {
            System.out.println("Задачи не найдены");
        } else {
            System.out.println("Найдено задач: " + foundCount);
        }
    }
}
