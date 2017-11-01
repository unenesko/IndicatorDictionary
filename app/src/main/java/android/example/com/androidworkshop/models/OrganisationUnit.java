package android.example.com.androidworkshop.models;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

public class OrganisationUnit implements Serializable {
    String id;
    String displayName;
    String displayShortName;
    String name;
    String shortName;

    boolean leaf;
    int level;

    String openingDate;
    OrganisationUnit parent;

    List<Program> programs;
    List<Dataset> datasets;

    List<OrganisationUnit> children;
    OrganisationUnit.TYPE type;

    public List<OrganisationUnit> getChildren() {
        return children;
    }

    public void setChildren(List<OrganisationUnit> children) {
        this.children = children;
    }



    public String getDisplayShortName() {
        return displayShortName;
    }

    public void setDisplayShortName(String displayShortName) {
        this.displayShortName = displayShortName;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public OrganisationUnit() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName(){
        return shortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOpeningDate(String openingDate){
        this.openingDate = openingDate;
    }

    public String getOpeningDate(){
        return openingDate;
    }

    public OrganisationUnit getParent() {
        return parent;
    }

    public void setParent(OrganisationUnit parent) {
        this.parent = parent;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String label) {
        this.displayName = displayName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public enum TYPE {
        ASSIGNED,
        SEARCH
    }
}
