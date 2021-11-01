package project.todoapp.api.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.todoapp.business.abstracts.TodoItemService;
import project.todoapp.core.utilities.results.DataResult;
import project.todoapp.core.utilities.results.Result;
import project.todoapp.entities.concretes.TodoItem;

import java.util.List;

@RestController
@RequestMapping("/api/todoitem")
public class TodoItemsController {

    private TodoItemService toDoItemService;

    @Autowired
    public TodoItemsController(TodoItemService toDoItemService){
        super();
        this.toDoItemService=toDoItemService;
    }

    @GetMapping("/getall")
    public DataResult<List<TodoItem>> getAll(){
        return this.toDoItemService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody TodoItem toDoItem){
        return this.toDoItemService.add(toDoItem);
    }

    @GetMapping("/getbyuserid")
    public DataResult<List<TodoItem>> getByUserId(int userId){
        return this.toDoItemService.getByUserId(userId);
    }

    @PostMapping("/update")
    public  Result update(TodoItem todoItem){
        this.toDoItemService.getTodoItemById(todoItem.getId());
        return this.toDoItemService.update(todoItem);
    }

    @PostMapping("/delete")
    public Result delete(TodoItem deletedTodoItem){
        return this.toDoItemService.delete(deletedTodoItem);
    }
}
