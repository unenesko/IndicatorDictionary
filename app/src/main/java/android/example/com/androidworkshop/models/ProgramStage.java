package android.example.com.androidworkshop.models;

import java.io.Serializable;
import java.util.List;

/*
 * Created by John Melin on 21/10/2017.
 */

class ProgramStage implements Serializable {
    String program; //programId
    String id;
    String displayName;
    String description;
    boolean openAfterEnrollment;
    boolean repeatable;
    boolean captureCoordinates;
    boolean remindCompleted;

    List<DataElement> programStageDataElements;
    List<ProgramStageSection> programStageSections;
    List<ProgramIndicator> programIndicators;

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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpenAfterEnrollment() {
        return openAfterEnrollment;
    }

    public void setOpenAfterEnrollment(boolean openAfterEnrollment) {
        this.openAfterEnrollment = openAfterEnrollment;
    }

    public boolean isCaptureCoordinates() {
        return captureCoordinates;
    }

    public void setCaptureCoordinates(boolean captureCoordinates) {
        this.captureCoordinates = captureCoordinates;
    }

    public boolean isRemindCompleted() {
        return remindCompleted;
    }

    public void setRemindCompleted(boolean remindCompleted) {
        this.remindCompleted = remindCompleted;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public List<DataElement> getProgramStageDataElements() {
        return programStageDataElements;
    }

    public void setProgramStageDataElements(List<DataElement> programStageDataElements) {
        this.programStageDataElements = programStageDataElements;
    }

    public List<ProgramStageSection> getProgramStageSections() {
        return programStageSections;
    }

    public void setProgramStageSections(List<ProgramStageSection> programStageSections) {
        this.programStageSections = programStageSections;
    }

    public List<ProgramIndicator> getProgramIndicators() {
        return programIndicators;
    }

    public void setProgramIndicators(List<ProgramIndicator> programIndicators) {
        this.programIndicators = programIndicators;
    }
}
