package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.util.List;

/*
 * Created by John Melin on 31/10/2017.
 */

public class Indicator implements Serializable {
    String displayName;
    String name;
    String shortName;
    String id;
    String description;
    String displayShortName;
    String denominatorDescription;
    String displayDescription;
    String dimensionItem;

    User user; //userId
    String dimensionItemType;
    IndicatorType indicatorType; //indicatorTypeId;

    List<IndicatorGroup> indicatorGroups;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public String getDenominatorDescription() {
        return denominatorDescription;
    }

    public void setDenominatorDescription(String denominatorDescription) {
        this.denominatorDescription = denominatorDescription;
    }

    public String getDisplayDescription() {
        return displayDescription;
    }

    public void setDisplayDescription(String displayDescription) {
        this.displayDescription = displayDescription;
    }

    public String getDimensionItem() {
        return dimensionItem;
    }

    public void setDimensionItem(String dimensionItem) {
        this.dimensionItem = dimensionItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDimensionItemType() {
        return dimensionItemType;
    }

    public void setDimensionItemType(String dimensionItemType) {
        this.dimensionItemType = dimensionItemType;
    }

    public IndicatorType getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.indicatorType = indicatorType;
    }

    public List<IndicatorGroup> getIndicatorGroups() {
        return indicatorGroups;
    }

    public void setIndicatorGroups(List<IndicatorGroup> indicatorGroups) {
        this.indicatorGroups = indicatorGroups;
    }
}
