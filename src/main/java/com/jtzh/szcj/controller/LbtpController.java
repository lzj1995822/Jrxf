package com.jtzh.szcj.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.szcj.entity.Lbtp;
import com.jtzh.szcj.mapper.LbtpMapper;

@RestController
@RequestMapping("lbtp")
public class LbtpController {

	@Resource
	private LbtpMapper lbtpMapper;
	@RequestMapping("addLbtp")
	public Object addLbtp(@RequestBody Lbtp lbtp) {
		lbtp.setCreateTime(new Date());
		lbtp.setDelflag("A");
		int num = lbtpMapper.insert(lbtp);
		if(num > 0) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="getLbtp",method=RequestMethod.GET)
	public Object getLbtp() {
		return lbtpMapper.getLbtp();
	}
	
	@RequestMapping(value="removeLbtp/{id}",method=RequestMethod.GET)
	public Object removeLbtp(@PathVariable("id")String id) {
		return lbtpMapper.removeLbtp(id);
	}
	
	@RequestMapping("updataLbtp")
	public Object updataLbtp(@RequestBody Lbtp lbtp) {
		lbtp.setCreateTime(new Date());
		return lbtpMapper.updataLbtp(lbtp);
	}
}
