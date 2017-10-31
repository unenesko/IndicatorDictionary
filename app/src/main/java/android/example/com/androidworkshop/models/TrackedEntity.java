package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 21/10/2017.
 */

import java.io.Serializable;

class TrackedEntity implements Serializable {
    String id;
    String name;

    public TrackedEntity() {
    }

    public void handleUnknown(String key, Object value) {
        // do something: put to a Map; log a warning, whatever
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
