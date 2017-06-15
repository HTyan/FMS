package com.etc.fms.expense.entity;

import java.util.Date;

public class Pledge {
    private Integer pid;

    private Integer eid;

    private String ptitle;

    private Date ptime;

    private String pcontent;

    private Double pmoney;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle == null ? null : ptitle.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public Double getPmoney() {
        return pmoney;
    }

    public void setPmoney(Double pmoney) {
        this.pmoney = pmoney;
    }
}