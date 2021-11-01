package project.todoapp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todoapp.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
