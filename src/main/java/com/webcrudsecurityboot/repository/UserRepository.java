package com.webcrudsecurityboot.repository;

import com.webcrudsecurityboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//public interface UserRepository {
//    List<User> getAllUsers();
//    User show(Long id);
//    void save(User user);
//    void update(User updatedUser);
//    void delete(Long id);
//    User findByName(String name);
//}
@Repository
public  interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
