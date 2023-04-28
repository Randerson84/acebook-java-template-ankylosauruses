package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

//
//package com.makersacademy.acebook.repository;
//
//        import com.makersacademy.acebook.model.User;
//        import org.springframework.data.jpa.repository.Query;
//        import org.springframework.data.repository.CrudRepository;
//
//public interface UserRepository extends CrudRepository<User, Long> {
//    @Query("SELECT c FROM users WHERE c.username = ?")
//    public User findByName (String username);
//
//    public User findByResetPasswordToken (String token);
//
//}
