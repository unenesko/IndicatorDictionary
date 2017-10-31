package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 21/10/2017.
 */

import java.io.Serializable;

public enum ProgramType implements Serializable {
    WITH_REGISTRATION("with_registration"),
    WITHOUT_REGISTRATION("without_registration");

    private final String value;

    private ProgramType( String value ) {
        this.value = value;
    }

    public static ProgramType fromValue( String value ) {
        for (ProgramType programType : ProgramType.values()) {
            if (programType.value.equalsIgnoreCase( value )) {
                return programType;
            }
        }
        return null;
    }

    public String getValue()
    {
        return value;
    }
}
