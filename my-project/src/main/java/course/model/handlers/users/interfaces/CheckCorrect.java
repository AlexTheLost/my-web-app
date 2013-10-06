package course.model.handlers.users.interfaces;

public interface CheckCorrect {
    public boolean userValid(String login, String password);

    public boolean loginExists(String login);

    public boolean passwordCorrect(String login);

    public boolean emailCorrect(String login);

}
