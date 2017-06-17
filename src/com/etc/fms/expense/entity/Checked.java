package com.etc.fms.expense.entity;

import java.util.Date;

public class Checked {
    private Integer cid;

    private Integer eid;

    private Integer pid;

    private Integer rid;

    private String ctitle;

    private Date ctime;

    private String ccontent;

    private String cadvice;

    private Integer cstaus;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle == null ? null : ctitle.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }

    public String getCadvice() {
        return cadvice;
    }

    public void setCadvice(String cadvice) {
        this.cadvice = cadvice == null ? null : cadvice.trim();
    }

    public Integer getCstaus() {
        return cstaus;
    }

    public void setCstaus(Integer cstaus) {
        this.cstaus = cstaus;
    }
}