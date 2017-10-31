package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 19/10/2017.
 */


import java.io.Serializable;

public class SystemInfo implements Serializable {
    private int id = 1;
    private String version;
    private String serverDate;

    public void handleUnknown(String key, Object value) {
        // do something: put to a Map; log a warning, whatever
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerDate() {
        return serverDate;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }

}
