package utilities;

public class StepDefinitionModel {

    private String stepSummary;
    private String stepStatus;
    private long stepExecutionTime;

    public String getStepSummary() {
        return stepSummary;
    }

    public void setStepSummary(String stepSummary) {
        this.stepSummary = stepSummary;
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus;
    }

    public long getStepExecutionTime() {
        return stepExecutionTime;
    }

    public void setStepExecutionTime(long stepExecutionTime) {
        this.stepExecutionTime = stepExecutionTime;
    }
}
