package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.util.List;

/*
 * Created by John Melin on 31/10/2017.
 */

class UserRoles implements Serializable{
    String displayName;
    String description;
    List<User> users;
    List<Program> programs;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
