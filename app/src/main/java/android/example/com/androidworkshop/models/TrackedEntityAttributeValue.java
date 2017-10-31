package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 29/10/2017.
 */

public class TrackedEntityAttributeValue {
    String trackedEntityAttributeId;
    String trackedEntityInstanceId;
    long localTrackedEntityInstanceId;

    public String getTrackedEntityAttributeId() {
        return trackedEntityAttributeId;
    }

    public void setTrackedEntityAttributeId(String trackedEntityAttributeId) {
        this.trackedEntityAttributeId = trackedEntityAttributeId;
    }

    public String getTrackedEntityInstanceId() {
        return trackedEntityInstanceId;
    }

    public void setTrackedEntityInstanceId(String trackedEntityInstanceId) {
        this.trackedEntityInstanceId = trackedEntityInstanceId;
    }

    public long getLocalTrackedEntityInstanceId() {
        return localTrackedEntityInstanceId;
    }

    public void setLocalTrackedEntityInstanceId(long localTrackedEntityInstanceId) {
        this.localTrackedEntityInstanceId = localTrackedEntityInstanceId;
    }
}
