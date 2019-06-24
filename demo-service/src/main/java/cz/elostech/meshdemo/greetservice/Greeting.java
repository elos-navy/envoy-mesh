package cz.elostech.meshdemo.greetservice;

public class Greeting {

    private final long id;
    private final String serviceid;
    private final String content;

    public Greeting(long id, String serviceid, String content) {
        this.id = id;
        this.serviceid = serviceid;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getServiceid() {
        return serviceid;
    }

    public String getContent() {
        return content;
    }
}