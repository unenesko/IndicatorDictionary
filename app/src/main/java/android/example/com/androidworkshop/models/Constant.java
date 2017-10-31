package android.example.com.androidworkshop.models;

/**
 * Created by John Melin on 30/10/2017.
 */

public class Constant {
    double value;
    boolean externalAccess;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isExternalAccess() {
        return externalAccess;
    }

    public void setExternalAccess(boolean externalAccess) {
        this.externalAccess = externalAccess;
    }
}
