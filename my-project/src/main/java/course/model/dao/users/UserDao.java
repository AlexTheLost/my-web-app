package course.model.dao.users;

import java.util.List;

import course.model.domain.users.User;

public interface UserDao {

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public User findByName(String name);
    
    public User findByEmail(String email);
    
    public List<User> getAll();

}
