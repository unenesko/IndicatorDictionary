package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by John Melin on 21/10/2017.
 */

public enum ValueType implements Serializable {
    TEXT( String.class ),
    LONG_TEXT( String.class ),
    LETTER( String.class ),
    PHONE_NUMBER( String.class ),
    EMAIL( String.class ),
    BOOLEAN( Boolean.class ),
    TRUE_ONLY( Boolean.class ),
    DATE( Date.class ),
    DATETIME( Date.class ),
    TIME ( String.class ),
    NUMBER( Double.class ),
    UNIT_INTERVAL( Double.class ),
    PERCENTAGE( Double.class ),
    INTEGER( Integer.class ),
    INTEGER_POSITIVE( Integer.class ),
    INTEGER_NEGATIVE( Integer.class ),
    INTEGER_ZERO_OR_POSITIVE( Integer.class ),
    TRACKER_ASSOCIATE( TrackedEntityInstance.class ),
    ORGANISATION_UNIT(OrganisationUnit.class),
    USERNAME( String.class ),
    FILE_RESOURCE( String.class ),
    COORDINATE( String.class),
    AGE( Date.class );

    public static final Set<ValueType> INTEGER_TYPES = new HashSet<>(Arrays.asList(
            INTEGER, INTEGER_POSITIVE, INTEGER_NEGATIVE, INTEGER_ZERO_OR_POSITIVE ));

    public static final Set<ValueType> NUMERIC_TYPES = new HashSet<>(Arrays.asList(
            INTEGER, INTEGER_POSITIVE, INTEGER_NEGATIVE, INTEGER_ZERO_OR_POSITIVE, NUMBER, UNIT_INTERVAL, PERCENTAGE ));

    public static final Set<ValueType> BOOLEAN_TYPES = new HashSet<>(Arrays.asList(
            BOOLEAN, TRUE_ONLY ));

    public static final Set<ValueType> TEXT_TYPES = new HashSet<>(Arrays.asList(
            TEXT, LONG_TEXT, LETTER, COORDINATE, TIME ));

    public static final Set<ValueType> DATE_TYPES = new HashSet<>(Arrays.asList(
            DATE, DATETIME ));

    private final Class<?> javaClass;

    private ValueType() {
        this.javaClass = null;
    }

    private ValueType( Class<?> javaClass ) {
        this.javaClass = javaClass;
    }

    public Class<?> getJavaClass() {
        return javaClass;
    }

    public boolean isInteger()
    {
        return INTEGER_TYPES.contains( this );
    }

    public boolean isNumeric()
    {
        return NUMERIC_TYPES.contains( this );
    }

    public boolean isBoolean()
    {
        return BOOLEAN_TYPES.contains( this );
    }

    public boolean isText()
    {
        return TEXT_TYPES.contains( this );
    }

    public boolean isDate()
    {
        return DATE_TYPES.contains( this );
    }

    public boolean isFile()
    {
        return this == FILE_RESOURCE;
    }

    public boolean isCoordinate()
    {
        return this == COORDINATE;
    }
}