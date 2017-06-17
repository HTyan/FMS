package com.etc.fms.emp.entity;

public class Emp {
    private Integer eid;

    private Integer did;

    private Integer jid;

    private Integer gid;

    private String ename;

    private String epassword;

    private String esex;

    private Integer eage;

    private String eintr;

    private String ehobby;

    private String etel;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword == null ? null : epassword.trim();
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex == null ? null : esex.trim();
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEintr() {
        return eintr;
    }

    public void setEintr(String eintr) {
        this.eintr = eintr == null ? null : eintr.trim();
    }

    public String getEhobby() {
        return ehobby;
    }

    public void setEhobby(String ehobby) {
        this.ehobby = ehobby == null ? null : ehobby.trim();
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel == null ? null : etel.trim();
    }
}