package com.etc.fms.company.entity;
/**
 * ��˾����
 * @author Administrator
 *
 */
public class Company {
    private Integer cid;

    private String cname;

    private String addr;

    private String type;

    private Integer flag;

    private Double cxy;

    private Double xy;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Double getCxy() {
        return cxy;
    }

    public void setCxy(Double cxy) {
        this.cxy = cxy;
    }

    public Double getXy() {
        return xy;
    }

    public void setXy(Double xy) {
        this.xy = xy;
    }
}