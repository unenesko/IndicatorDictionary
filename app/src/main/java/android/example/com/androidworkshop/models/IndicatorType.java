package android.example.com.androidworkshop.models;

import java.io.Serializable;

/*
 * Created by John Melin on 31/10/2017.
 */

public class IndicatorType implements Serializable{
    String displayName;
    String name;
    String id;
    boolean number;
    int factor;


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
}
