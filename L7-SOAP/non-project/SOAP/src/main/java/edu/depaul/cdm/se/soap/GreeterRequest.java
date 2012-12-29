package edu.depaul.cdm.se.soap;

public class GreeterRequest {
    private String name;
    
    public GreeterRequest() {
        super();
    }
    
    public GreeterRequest(String name) {
        super();
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name; 
    }
    
    public String getName() {
        return name;
    }
}
