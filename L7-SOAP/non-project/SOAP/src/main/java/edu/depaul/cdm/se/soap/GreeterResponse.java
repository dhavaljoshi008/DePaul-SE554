package edu.depaul.cdm.se.soap;

import java.io.Serializable;

public class GreeterResponse implements Serializable {
    private String name;
    private StringBuilder message = new StringBuilder("Hello, ");
    
    public GreeterResponse() {
        super();
    }
    
    public GreeterResponse(String name) {
        super();
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name; 
    }
    
    public void setMessage(String message) {
        this.message = new StringBuilder(message);
    }
    
    public String toString() {
        message.append(name);
        return message.toString();
    }
}
