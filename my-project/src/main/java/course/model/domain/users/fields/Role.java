package course.model.domain.users.fields;

public enum Role {
    ROLE_USER, ROLE_MANAGER, ROLE_ADMINISTRATOR;

    @Override
    public String toString() {
        String capitalLetter = this.name().substring(5, 6);
        return capitalLetter + this.name().substring(6).toLowerCase();
    }
}
