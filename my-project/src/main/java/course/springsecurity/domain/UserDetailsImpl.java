package course.springsecurity.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import course.model.domain.users.User;
import course.model.domain.users.fields.Role;

/**
 * This is delegate for User for UserDetails in SpringSecurity.
 */
public class UserDetailsImpl implements UserDetails {

    private static final long            serialVersionUID = 3472896990909910858L;
    private User                         user;
    private Collection<GrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.user = user;
        this.setRole();
    }

    private void setRole() {
        this.authorities = new HashSet<GrantedAuthority>();
        Role role = this.user.getRole();
        if (role == Role.ROLE_USER) {
            setRoleForUser();
        } else if (role == Role.ROLE_MANAGER) {
            setRoleForManager();
        } else if (role == Role.ROLE_ADMINISTRATOR) {
            setRoleForAdministrator();
        }
    }

    private void setRoleForUser() {
        addAuthorities(Role.ROLE_USER.name());
    }

    private void setRoleForManager() {
        setRoleForUser();
        addAuthorities(Role.ROLE_MANAGER.name());
    }

    private void setRoleForAdministrator() {
        setRoleForManager();
        addAuthorities(Role.ROLE_ADMINISTRATOR.name());
    }

    private void addAuthorities(final String role) {
        GrantedAuthority grandAuthority = new GrantedAuthority() {
            private static final long serialVersionUID = 3958183417696804555L;

            public String getAuthority() {
                return role;
            }
        };
        this.authorities.add(grandAuthority);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return this.authorities;
    }

    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
