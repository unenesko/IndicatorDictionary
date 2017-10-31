package android.example.com.androidworkshop.models;


/*
 * Created by John Melin on 21/10/2017.
 */

import java.io.Serializable;
import java.util.List;

public class TrackedEntityInstance implements Serializable {
    String trackedEntityInstance;
    String trackedEntity;
    String orgUnit;
    List<TrackedEntityAttributeValue> attributes;
    List<Relationship> relationships;

    public String getTrackedEntityInstance() {
        return trackedEntityInstance;
    }

    public void setTrackedEntityInstance(String trackedEntityInstance) {
        this.trackedEntityInstance = trackedEntityInstance;
    }

    public String getTrackedEntity() {
        return trackedEntity;
    }

    public void setTrackedEntity(String trackedEntity) {
        this.trackedEntity = trackedEntity;
    }

    public String getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(String orgUnit) {
        this.orgUnit = orgUnit;
    }

    public List<TrackedEntityAttributeValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<TrackedEntityAttributeValue> attributes) {
        this.attributes = attributes;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }
}
