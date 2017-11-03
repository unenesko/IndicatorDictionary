package android.example.com.androidworkshop.models;

import java.io.Serializable;

/*
 * Created by John Melin on 30/10/2017.
 */

public class DataValue implements Serializable{
    long localEventId = -1; /* reference to local event object */
    String event;
    String dataElement;
    boolean providedElsewhere;
    String storedBy;
    String period;
    String orgUnit;
    double value;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getLocalEventId() {
        return localEventId;
    }

    public void setLocalEventId(long localEventId) {
        this.localEventId = localEventId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDataElement() {
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    public boolean isProvidedElsewhere() {
        return providedElsewhere;
    }

    public void setProvidedElsewhere(boolean providedElsewhere) {
        this.providedElsewhere = providedElsewhere;
    }

    public String getStoredBy() {
        return storedBy;
    }

    public void setStoredBy(String storedBy) {
        this.storedBy = storedBy;
    }
}
