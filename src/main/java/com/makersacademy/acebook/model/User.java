package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import com.makersacademy.acebook.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.lang.Boolean.TRUE;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String friends_list;
    private String profile_picture;

    public User() {
        this.enabled = TRUE;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = TRUE;
        this.id = id;
        this.friends_list = friends_list;
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    public void setId(long id){this.id = id;}

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public Long getId(){return id;}
    public String getFriendsList() {return friends_list;}
    public void setFriendsList(String friends_list) {this.friends_list = friends_list;}

    public static User findUser(String username, UserRepository userRepo){
        User user = new User();
        for (User u: userRepo.findAll()){if (u.getUsername().equals(username)){user = u;break;}
        }
        return user;
    }


//
//    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
//        User user = UserRepository.find;
//        if (customer != null) {
//            customer.setResetPasswordToken(token);
//            customerRepo.save(customer);
//        } else {
//            throw new CustomerNotFoundException("Could not find any customer with the email " + email);
//        }
//    }
//
//    public Customer getByResetPasswordToken(String token) {
//        return customerRepo.findByResetPasswordToken(token);
//    }
//
//    public void updatePassword(Customer customer, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        customer.setPassword(encodedPassword);
//
//        customer.setResetPasswordToken(null);
//        customerRepo.save(customer);
//    }

}
