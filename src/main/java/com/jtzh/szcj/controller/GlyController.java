package com.jtzh.szcj.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.jtzh.szcj.common.MD5;
import com.jtzh.szcj.common.ResultObject;
import com.jtzh.szcj.pojo.LoginCheck;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.szcj.entity.Gly;
import com.jtzh.szcj.mapper.GlyMapper;


@RestController
@RequestMapping("/gly")
public class GlyController {
	
	@Resource
	private GlyMapper glyMapper;
	
	@RequestMapping("/login")
	public Object login(@RequestBody Gly gly) {
		Gly g = glyMapper.seleteGlysByZh(gly.getZh());
		ResultObject res = new ResultObject();
		if(gly.getMm().equals(g.getMm())) {
			res.setResult(true);
			try {
				String mm = MD5.md5(g.getZh()+g.getMm(),"nicaicaikan");
				res.setObj(mm);
				return res;
			}catch (Exception e){
				res.setResult(false);
				return res;
			}
		}
		res.setResult(false);
		return res;
	}

    @RequestMapping("/loginCheck")
    public Object login(@RequestBody LoginCheck loginCheck, HttpServletRequest request) {
        ResultObject res = new ResultObject();
        Cookie[] cookies = request.getCookies();
        String mm  = "";
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("jurong-xf")){
                    mm = cookie.getValue();
                }
            }
            List<Gly> list  = glyMapper.seleteGlys();
            for(Gly gly : list){
                try {
                    String mm1 = MD5.md5(gly.getZh()+gly.getMm(),"nicaicaikan");
                    if (mm.equals(mm1)){
                        String url = "";
                        switch (loginCheck.getKey()){
                            case "菜单管理":
                                url =  "set.html";
                                break;
                            case "文章管理":
                                url =  "wz.html";
                                break;
                            case "轮播图管理":
                                url =  "lbtp.html";
                                break;
                        }
                        res.setObj(url);
                        return res;
                    }
                }catch (Exception e){
                    res.setResult(false);
                    return res;
                }
            }
        }
        res.setResult(false);
	    return res;
    }
	
	@RequestMapping("/getGlys")
	public Object getGlys() {
		return glyMapper.seleteGlys();
	}
	
	@RequestMapping("addGly")
	public Object addGly(@RequestBody Gly gly) {
		if(glyMapper.getGlyByZh(gly.getZh())>0) {
			return 0;
		}
		gly.setCreatetime(new Date());
		gly.setDelflag("A");
		gly.setZt("1");
		return glyMapper.insert(gly);
	}
	
	@RequestMapping("/modifyGly")
	public Object modifyGly(@RequestBody Gly gly) {
		gly.setCreatetime(new Date());
		int num = glyMapper.updateByPrimaryKey(gly);
		if(num > 0) {
			return true; 
		}
		return false;
	}
	
	@RequestMapping(value="/modifyZhZt/{zh}/{zt}",method=RequestMethod.GET)
	public Object modifyZhZt(@PathVariable("zh")String zh ,@PathVariable("zt")String zt) {
		return glyMapper.updateZt(zh, zt);
	}
	
	@RequestMapping(value="/modifyZhMm/{zh}/{mm}",method=RequestMethod.GET)
	public Object modifyZhMn(@PathVariable("zh")String zh ,@PathVariable("mm")String mm) {
		Gly g = glyMapper.seleteGlysByZh(zh);
		if(mm.equals(g.getMm())) {
			return false;
		}
		glyMapper.updateMm(zh, mm);
		return true;
	}
	@RequestMapping(value="/removeZh/{id}",method=RequestMethod.GET)
	public Object removeZh(@PathVariable("id")String id) {
		return glyMapper.removeZh(id);
	}
}
