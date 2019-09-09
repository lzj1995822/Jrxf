package com.jtzh.szcj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.szcj.entity.Fl;
import com.jtzh.szcj.mapper.FlMapper;
import com.jtzh.szcj.pojo.FlParam;

@RestController
@RequestMapping("fl")
public class FlController {
	@Resource
	private FlMapper flMapper;
	
	@RequestMapping("getFl")
	public Object getFl(@RequestBody Fl fl) {
		FlParam p = new FlParam();
		if(StringUtils.isNotBlank(fl.getFlid())) {
			Fl fl1 = flMapper.selectByflid(fl.getFlid());
			if(StringUtils.isNotBlank(fl1.getFflid())) {
				fl.setFflid(fl1.getFflid());
			}else {
				p.setFfl(fl1);
				return p;
			}
		}
		Fl f2 = flMapper.selectByflid(fl.getFflid());
		List<Fl> f = flMapper.selectByfflid(fl.getFflid());
		p.setFfl(f2);
		p.setFl(f);
		return p;
	}
}
