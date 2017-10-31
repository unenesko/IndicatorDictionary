package android.example.com.androidworkshop.models;

/*
 * Created by John Melin on 31/10/2017.
 */

import java.io.Serializable;
import java.util.List;

class Dataset implements Serializable{
    String name;
    String shortName;
    String code;
    String id;
    String displayName;
    String displayShortName;

    String formType;
    String dataEntryForm; //dataEntryFormId
    String categoryCombo; //categoryComboId

    List<DataSetElement> dataSetElements;
    List<OrganisationUnit> organisationUnits;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getDataEntryForm() {
        return dataEntryForm;
    }

    public void setDataEntryForm(String dataEntryForm) {
        this.dataEntryForm = dataEntryForm;
    }

    public String getCategoryCombo() {
        return categoryCombo;
    }

    public void setCategoryCombo(String categoryCombo) {
        this.categoryCombo = categoryCombo;
    }

    public List<DataSetElement> getDataSetElements() {
        return dataSetElements;
    }

    public void setDataSetElements(List<DataSetElement> dataSetElements) {
        this.dataSetElements = dataSetElements;
    }

    public List<OrganisationUnit> getOrganisationUnits() {
        return organisationUnits;
    }

    public void setOrganisationUnits(List<OrganisationUnit> organisationUnits) {
        this.organisationUnits = organisationUnits;
    }
}
