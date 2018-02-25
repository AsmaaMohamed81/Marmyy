package com.Alatheer.marmy.API.Model;


/**
 * Created by elashry on 2/20/2018.
 */

public class Orders {


    String user_name;
    String playground_name;
    String time;
    String date;

    public Orders(String user_name, String playground_name, String time, String date) {
        this.user_name = user_name;
        this.playground_name = playground_name;
        this.time = time;
        this.date = date;
    }

    public Orders() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPlayground_name() {
        return playground_name;
    }

    public void setPlayground_name(String playground_name) {
        this.playground_name = playground_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
