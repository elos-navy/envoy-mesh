package cz.elostech.meshdemo.masterservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private String id;
    private String serviceid;
    private String content;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", serviceid=" + serviceid + '\'' +
                ", content=" + content +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}