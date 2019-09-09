package com.jtzh.szcj.pojo;

import java.util.List;

import com.jtzh.szcj.entity.Wz;

public class WzView {
	
	private Wz wz;
	private Wz upWz;
	private Wz downWz;
	private List<Wz> randWz;
	
	public List<Wz> getRandWz() {
		return randWz;
	}
	public void setRandWz(List<Wz> randWz) {
		this.randWz = randWz;
	}
	public Wz getWz() {
		return wz;
	}
	public void setWz(Wz wz) {
		this.wz = wz;
	}
	public Wz getUpWz() {
		return upWz;
	}
	public void setUpWz(Wz upWz) {
		this.upWz = upWz;
	}
	public Wz getDownWz() {
		return downWz;
	}
	public void setDownWz(Wz downWz) {
		this.downWz = downWz;
	}
	
}
