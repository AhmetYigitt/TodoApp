package project.todoapp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.todoapp.business.abstracts.UserService;
import project.todoapp.core.utilities.results.*;
import project.todoapp.dataAccess.abstracts.UserDao;
import project.todoapp.entities.concretes.User;
import project.todoapp.entities.dtos.UserLoginDto;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        try {
            return new SuccessDataResult<User>(this.userDao.findByEmail(email));
        }catch (Exception e){
            return new ErrorDataResult<User>("kullanıcı bulunamadı");
        }
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult();
    }


    }
