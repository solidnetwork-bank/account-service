package xyz.solidnetwork.service.account;

public class Message {
    private Object message;

    public Message() {
        super();
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + "]";
    }

}
