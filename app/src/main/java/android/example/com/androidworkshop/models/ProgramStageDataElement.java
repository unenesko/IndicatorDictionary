package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 30/10/2017.
 */

class ProgramStageDataElement extends DataElement{
    String programStage;
    String dataElement;

    DataElement dataElementObj;
    boolean allowFutureDate;

    int sortOrder;

    boolean displayInReports;
    boolean allowProvidedElsewhere;
    boolean compulsory;

    String programStageSection;

    public String getProgramStage() {
        return programStage;
    }

    public void setProgramStage(String programStage) {
        this.programStage = programStage;
    }

    public String getDataElement() {
        return dataElement;
    }

    public void setDataElement(String dataElement) {
        this.dataElement = dataElement;
    }

    public DataElement getDataElementObj() {
        return dataElementObj;
    }

    public void setDataElementObj(DataElement dataElementObj) {
        this.dataElementObj = dataElementObj;
    }

    public boolean isAllowFutureDate() {
        return allowFutureDate;
    }

    public void setAllowFutureDate(boolean allowFutureDate) {
        this.allowFutureDate = allowFutureDate;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isDisplayInReports() {
        return displayInReports;
    }

    public void setDisplayInReports(boolean displayInReports) {
        this.displayInReports = displayInReports;
    }

    public boolean isAllowProvidedElsewhere() {
        return allowProvidedElsewhere;
    }

    public void setAllowProvidedElsewhere(boolean allowProvidedElsewhere) {
        this.allowProvidedElsewhere = allowProvidedElsewhere;
    }

    public boolean isCompulsory() {
        return compulsory;
    }

    public void setCompulsory(boolean compulsory) {
        this.compulsory = compulsory;
    }

    public String getProgramStageSection() {
        return programStageSection;
    }

    public void setProgramStageSection(String programStageSection) {
        this.programStageSection = programStageSection;
    }
}
