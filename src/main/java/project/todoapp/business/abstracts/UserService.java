package project.todoapp.business.abstracts;

import project.todoapp.core.utilities.results.DataResult;
import project.todoapp.core.utilities.results.Result;
import project.todoapp.entities.concretes.User;

public interface UserService {
    DataResult<User> findByEmail(String email);
    Result add(User user);
}
