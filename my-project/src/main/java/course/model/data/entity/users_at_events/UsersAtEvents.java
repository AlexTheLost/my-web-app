package course.model.data.entity.users_at_events;

import java.io.Serializable;

public class UsersAtEvents implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUsersAtEvents;
    private Long idEvent;
    private Long idUser;

    public long getIdUserAtEvents() {
        return this.idUsersAtEvents;
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    public long getIdEvent() {
        return this.idEvent;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdUser() {
        return this.idUser;
    }

}
