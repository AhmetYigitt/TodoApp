package project.todoapp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.todoapp.business.abstracts.TodoItemService;
import project.todoapp.core.utilities.results.*;
import project.todoapp.dataAccess.abstracts.TodoItemDao;
import project.todoapp.entities.concretes.TodoItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoItemManager implements TodoItemService {

    private TodoItemDao toDoItemDao;

    @Autowired
    public TodoItemManager(TodoItemDao toDoItemDao){
        super();
        this.toDoItemDao=toDoItemDao;
    }


    @Override
    public DataResult<List<TodoItem>> getAll() {
        return new SuccessDataResult<List<TodoItem>>(this.toDoItemDao.findAll());
    }

    @Override
    public Result add(TodoItem toDoItem) {
        this.toDoItemDao.save(toDoItem);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<TodoItem>> getByUserId(int userId) {
        List<TodoItem> result =new ArrayList<TodoItem>();
        try {
            result=this.toDoItemDao.getByUserId(userId);
                return new SuccessDataResult<List<TodoItem>>(result);


        }catch (Exception e){
            return new ErrorDataResult<List<TodoItem>>("kullanıcı bulunamadı");
        }
    }

    @Override
    public Result update(TodoItem todoItem) {

        var updatedItem=this.toDoItemDao.getTodoItemById(todoItem.getId());
        this.toDoItemDao.save(updatedItem);
        return new SuccessResult();
    }

    @Override
    public DataResult<TodoItem> getTodoItemById(int todoId) {
        return new SuccessDataResult<TodoItem>(this.toDoItemDao.getTodoItemById(todoId));
    }

    @Override
    public Result delete(TodoItem todoItemId) {
        this.toDoItemDao.delete(todoItemId);
        return new SuccessResult();
    }
}
