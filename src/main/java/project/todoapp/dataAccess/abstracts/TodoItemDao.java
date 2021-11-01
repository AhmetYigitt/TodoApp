package project.todoapp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todoapp.entities.concretes.TodoItem;

import java.util.List;

public interface TodoItemDao extends JpaRepository<TodoItem,Integer> {
    List<TodoItem> getByUserId(int userId);
    TodoItem getTodoItemById(int todoItemId);
}
