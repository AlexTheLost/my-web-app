package course.model.domain.avatars;

import java.io.Serializable;

public class Avatar implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8445201483708199471L;
    private int idAvatar;
    private String src;

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public int getIdAvatar() {
        return this.idAvatar;
    }

    public void setSrc(String Src) {
        this.src = Src;
    }

    public String getSrc() {
        return this.src;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!this.getClass().equals(obj.getClass()))
            return false;

        Avatar obj2 = (Avatar) obj;
        if (this.idAvatar == obj2.getIdAvatar() && this.src.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (idAvatar + src).hashCode();
        return tmp;
    }
}
