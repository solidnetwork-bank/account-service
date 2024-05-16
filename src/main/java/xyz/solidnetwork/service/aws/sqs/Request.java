package xyz.solidnetwork.service.aws.sqs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Request {
    private String id;

    public Request() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public String toString() {
        return "Request [id=" + id + "]";
    }

}
