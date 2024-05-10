package xyz.solidnetwork.service.aws.sqs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import xyz.solidnetwork.service.transaction.Report;

public class Response {
    private Report report;

    public Response() {
        super();
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public String toString() {
        return "Response [report=" + report + "]";
    }

}
