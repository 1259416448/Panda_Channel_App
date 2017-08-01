package com.example.demo.panda_channel.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class LoginBean implements Serializable {

    /**
     * timestamp : 2017-07-20 17:40:30
     * ticket : 9d9916a3-eac9-44d9-a477-13280cc0879e
     * errType : 0
     * errMsg : 成功
     * sso : []
     * user_seq_id : 54047383
     * usrid : 540473831500282889697
     */

    private String timestamp;
    private String ticket;
    private String errType;
    private String errMsg;
    private String user_seq_id;
    private String usrid;
    private List<?> sso;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getUser_seq_id() {
        return user_seq_id;
    }

    public void setUser_seq_id(String user_seq_id) {
        this.user_seq_id = user_seq_id;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public List<?> getSso() {
        return sso;
    }

    public void setSso(List<?> sso) {
        this.sso = sso;
    }
}
