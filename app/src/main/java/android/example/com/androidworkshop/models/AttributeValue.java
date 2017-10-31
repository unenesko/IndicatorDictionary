package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.text.AttributedCharacterIterator;

/*
 * Created by John Melin on 30/10/2017.
 */

public class AttributeValue implements Serializable {
    long id;
    String dataElement;
    String attribute;
    Attribute attributeObj;
    String value;
    String created;
    String lastUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataElement() {
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttributeObj() {
        return attributeObj;
    }

    public void setAttributeObj(Attribute attributeObj) {
        this.attributeObj = attributeObj;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
