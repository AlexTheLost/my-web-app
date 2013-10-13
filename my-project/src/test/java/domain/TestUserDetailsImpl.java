package domain;

import course.springsecurity.domain.UserDetailsImpl;
import course.model.domain.users.User;
import course.model.domain.users.fields.Role;

public class TestUserDetailsImpl {
    
    public static void main(String args[]) {
        User user = new User();
        user.setRole(Role.ROLE_USER);
        UserDetailsImpl udi = new UserDetailsImpl(user);
        user.setRole(Role.ROLE_MANAGER);
        udi = new UserDetailsImpl(user);
        user.setRole(Role.ROLE_ADMINISTRATOR);
        udi = new UserDetailsImpl(user);
    }
}
