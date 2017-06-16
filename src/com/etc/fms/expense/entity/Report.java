package com.etc.fms.expense.entity;

import java.util.Date;

public class Report {
    private Integer rid;

    private Integer eid;

    private String rtitle;

    private Date rtime;

    private String rcontent;

    private Double rmoney;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle == null ? null : rtitle.trim();
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent == null ? null : rcontent.trim();
    }

    public Double getRmoney() {
        return rmoney;
    }

    public void setRmoney(Double rmoney) {
        this.rmoney = rmoney;
    }
}