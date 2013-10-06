package course.model.handlers.users.interfaces;

import course.model.data.entity.users.fields.Language;
import course.model.data.entity.users.fields.Role;
import course.model.data.entity.users.fields.Stile;

public interface UserAction {
    public void createUser(String nickName, String login, String password,
            String email);

    public void deleteUser(String login);

    public void changePassword(String login, String newPassword);

    public void changeNickName(String login, String password, String newNickName);

    public void changeEmail(String login, String email);

    public void changeRole(String login, Role role);

    public void changeLanguage(String login, Language language);

    public void changeStile(String login, Stile stile);

    // ?
    public void changeAvatar(String login, Stile src);

    public void setShortDescription(String login, String descr);

    public void getRole(String login);
}
