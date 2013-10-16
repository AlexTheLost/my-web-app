package course.springsecurity.service;

import java.util.HashMap;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;
import course.springsecurity.domain.UserDetailsImpl;

@Service
public class UserManager {
    UserDao userDao = null;

    public UserManager() {
        userDao = new UserDaoImpl();
    }

    public UserDetails getUser(String username)
            throws UsernameNotFoundException {
        User user = userDao.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        UserDetails userDetails = new UserDetailsImpl(user);

        return userDetails;
    }
    
    public static class Test {
        public static void main(String[] args) {
            UserManager um = new UserManager();
            UserDetails ud = um.getUser("Mont");
            System.out.println("SecureName: " + ud.getUsername());
            System.out.println("SecurePass: " + ud.getPassword());
            for(GrantedAuthority ga : ud.getAuthorities()) {
                System.out.println("SecureRole: " + ga.getAuthority());
            }
            
        }
    }
}
