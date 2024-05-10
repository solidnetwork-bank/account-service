package xyz.solidnetwork.service.aws.sqs;

public class Request {
    private String id;

    public Request(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + "]";
    }

}
