package com.jtzh.szcj.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.szcj.common.ResultObject;
import com.jtzh.szcj.common.page.Page;
import com.jtzh.szcj.entity.Wz;
import com.jtzh.szcj.mapper.WzMapper;
import com.jtzh.szcj.pojo.WzListParam;
import com.jtzh.szcj.pojo.WzView;

@RestController
@RequestMapping("wz")
public class WzController {

	@Resource
	private WzMapper wzMapper;
	@RequestMapping("addWz")
	public Object addWz(@RequestBody Wz wz) {
		if (wz.getCreatetime() == null){
			wz.setCreatetime(new Date());
		}
		wz.setDelflag("A");
		wz.setYdl((long) 0);
		wz.setZt("1");

		if(wz.getFl().equals("自身建设")) {
            wzMapper.insert(wz);
            wz.setFl("一周组织工作回顾");
            wz.setFlid("18");
            wz.setFfl("自身建设");
            wz.setFflid("5");
        }
            return wzMapper.insert(wz);
	}
	
	@RequestMapping("updateWz")
	public Object updateWz(@RequestBody Wz wz) {
		return wzMapper.updateWz(wz);
	}
	
	@RequestMapping("getWz")
	public Object getWz(@RequestBody Wz wz) {
		Page page = new Page();
		page.setCurrPage(wz.getPage());
		page.setPageSize(wz.getPageSize());
		page.setParam(wz);
		page.setTotal(wzMapper.getWzTotal(page));
		page.setData(wzMapper.getWz(page));
		return page;
	}
	
	@RequestMapping(value="getIndexs",method=RequestMethod.GET)
	public Object getIndexs() {
		WzListParam p = new WzListParam();
		p.setBddt(wzMapper.getindex("3", 8));
		p.setTzgg(wzMapper.getindex("4", 8));
		p.setYzzzhg(wzMapper.getindex("18", 13));
        List<Wz> list1 = wzMapper.getindex("5", 4);
        p.setZsjs(list1);
        if (list1.size() < 5){
            p.setZsjs(wzMapper.getindex("5", 5));
        }

        List<Wz> list2 = wzMapper.getindex("6", 4);
        p.setDjyj(list2);
        if (list2.size() < 5){
            p.setDjyj(wzMapper.getindex("6", 5));
        }

        List<Wz> list3 = wzMapper.getindex("7", 4);
        p.setGbgz(list3);
        if (list3.size() < 5){
            p.setGbgz(wzMapper.getindex("7", 5));
        }

        List<Wz> list4 = wzMapper.getindex("7", 4);
        p.setJczz(list4);
        if (list4.size() < 5){
            p.setJczz(wzMapper.getindex("8", 5));
        }

        List<Wz> list5 = wzMapper.getindex("9", 4);
        p.setDygl(list5);
        if (list5.size() < 5){
            p.setDygl(wzMapper.getindex("9", 5));
        }

        List<Wz> list6 = wzMapper.getindex("10", 4);
        p.setRcgz(list6);
        if (list6.size() < 5){
            p.setRcgz(wzMapper.getindex("10", 5));
        }

        List<Wz> list7 = wzMapper.getindex("11", 4);
        p.setYcjy(list7);
        if (list7.size() < 5 ){
            p.setYcjy(wzMapper.getindex("11", 5));
        }

        List<Wz> list8 = wzMapper.getindex("12", 4);
        p.setGdjy(list8);
        if (list8.size() < 5){
            p.setGdjy(wzMapper.getindex("12", 5));
        }
		return p;
	}
	
	@RequestMapping(value="getIndex",method=RequestMethod.POST)
	public Object getIndex(@RequestBody Wz wz) {
		ResultObject obj = new ResultObject();
		obj.setResult(true);
		obj.setObj(wzMapper.getWzs(wz));
		return obj;
	}
	@RequestMapping(value="modifyZt/{id}/{zt}",method=RequestMethod.GET)
	public Object modifyZt(@PathVariable("id")String id,@PathVariable("zt")String zt) {
		return wzMapper.modifyZt(id, zt);
	}
	
	@RequestMapping(value="removeWz/{id}",method=RequestMethod.GET)
	public Object modifyZt(@PathVariable("id")String id) {
		return wzMapper.removeWz(id);
	}
	
	@RequestMapping(value="getWzInfo/{id}",method=RequestMethod.GET)
	public Object getWzInfo(@PathVariable("id")String id) {
		WzView wz = new WzView();
		Wz w = new Wz(); 
		w = wzMapper.getWzInfo(id);
		wzMapper.modifyYdl(id);
		wz.setWz(w);
		wz.setRandWz(wzMapper.getRand());
		wz.setUpWz(wzMapper.getUp(w.getId(), w.getFlid()));
		wz.setDownWz(wzMapper.getDown(w.getId(), w.getFlid()));
		return wz;
	}
}
