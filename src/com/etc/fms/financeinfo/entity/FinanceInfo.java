package com.etc.fms.financeinfo.entity;

public class FinanceInfo {
    private Integer fid;

    private Integer cid;

    private String cno;

    private String fname;

    private Double yishou;

    private Double sishou;

    private String ftime;

    private String ytime;

    private String des;
    
    public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	private int flag = 0 ;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Double getYishou() {
        return yishou;
    }

    public void setYishou(Double yishou) {
        this.yishou = yishou;
    }

    public Double getSishou() {
        return sishou;
    }

    public void setSishou(Double sishou) {
        this.sishou = sishou;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime == null ? null : ftime.trim();
    }

    public String getYtime() {
        return ytime;
    }

    public void setYtime(String ytime) {
        this.ytime = ytime == null ? null : ytime.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

	@Override
	public String toString() {
		return "FinanceInfo [fid=" + fid + ", cid=" + cid + ", cno=" + cno
				+ ", fname=" + fname + ", yishou=" + yishou + ", sishou="
				+ sishou + ", ftime=" + ftime + ", ytime=" + ytime + ", des="
				+ des + ", flag=" + flag + "]";
	}
    
}