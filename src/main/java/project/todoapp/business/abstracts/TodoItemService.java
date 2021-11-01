package project.todoapp.business.abstracts;

import project.todoapp.core.utilities.results.DataResult;
import project.todoapp.core.utilities.results.Result;
import project.todoapp.entities.concretes.TodoItem;

import java.util.List;

public interface TodoItemService {

DataResult<List<TodoItem>> getAll();

Result add(TodoItem toDoItem);

DataResult<List<TodoItem>> getByUserId(int userId);

Result update(TodoItem toDoItem);

DataResult<TodoItem> getTodoItemById(int todoId);

Result delete(TodoItem todoItem);
}
