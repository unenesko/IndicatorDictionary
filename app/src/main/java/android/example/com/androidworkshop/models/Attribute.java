package android.example.com.androidworkshop.models;

import java.io.Serializable;

/*
 * Created by John Melin on 30/10/2017.
 */

class Attribute implements Serializable{
    String valueType;
    String code;

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
