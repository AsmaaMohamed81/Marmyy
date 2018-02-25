package com.Alatheer.marmy.API.Model;

import java.util.ArrayList;

public class MSG {

    private Integer success;
    private String message;
    private String id;
    private Integer is_delegate;
    private Integer time;
    private ArrayList<String> delegateIDS;
    /**
     * No args constructor for use in serialization
     */
    public MSG() {
    }

    /**
     * @param message
     * @param success
     */
    public MSG(Integer success, String message, String id) {
        super();
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public MSG(String id, ArrayList<String> delegateIDS) {
        this.id = id;
        this.delegateIDS = delegateIDS;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIs_delegate() {
        return is_delegate;
    }

    public void setIs_delegate(Integer is_delegate) {
        this.is_delegate = is_delegate;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}