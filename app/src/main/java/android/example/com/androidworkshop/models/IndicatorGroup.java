package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.util.List;

/*
 * Created by John Melin on 31/10/2017.
 */

class IndicatorGroup implements Serializable{
    String displayName;
    String name;
    String id;
    String indicatorGroupSet; //indicatorGroupSetId

    List<Indicator> indicators;

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

    public String getIndicatorGroupSet() {
        return indicatorGroupSet;
    }

    public void setIndicatorGroupSet(String indicatorGroupSet) {
        this.indicatorGroupSet = indicatorGroupSet;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }
}
