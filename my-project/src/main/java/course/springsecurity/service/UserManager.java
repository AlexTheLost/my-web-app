package course.springsecurity.service;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import course.springsecurity.domain.User;

@Service
public class UserManager {
    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<String, User>();
        users.put("user", new User("user", "1", "ROLE_USER"));
        users.put("admin", new User("admin", "2", "ROLE_USER, ROLE_ADMIN"));
    }

    public User getUser(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return users.get(username);
    }
}
