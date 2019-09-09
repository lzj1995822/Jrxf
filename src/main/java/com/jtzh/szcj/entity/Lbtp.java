package com.jtzh.szcj.entity;

import java.util.Date;

public class Lbtp {
    private Long id;

    private String mc;

    private String lj;

    private String tp;

    private Integer px;

    private String tpwz;

    private Date createTime;

    private String delflag;
    
    private int page;
    private int pageSize;
    

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getLj() {
        return lj;
    }

    public void setLj(String lj) {
        this.lj = lj;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Integer getPx() {
        return px;
    }

    public void setPx(Integer px) {
        this.px = px;
    }

    public String getTpwz() {
        return tpwz;
    }

    public void setTpwz(String tpwz) {
        this.tpwz = tpwz;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}