package course.model.data.entity.users_at_events;

import java.io.Serializable;

public class UserAtEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idUserAtEvent;

    // private int idEvent;
    // private int idUser;

    public void setIdUserAtEvent(int idUsersAtEvents) {
        this.idUserAtEvent = idUsersAtEvents;
    }

    public int getIdUserAtEvent() {
        return this.idUserAtEvent;
    }

    // public void setIdEvent(int idEvent) {
    // this.idEvent = idEvent;
    // }
    //
    // public int getIdEvent() {
    // return this.idEvent;
    // }
    //
    // public void setIdUser(int idUser) {
    // this.idUser = idUser;
    // }
    //
    // public int getIdUser() {
    // return this.idUser;
    // }

}
