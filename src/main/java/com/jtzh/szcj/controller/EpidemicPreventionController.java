package com.jtzh.szcj.controller;

import com.jtzh.szcj.common.ResultObject;
import com.jtzh.szcj.common.page.Page;
import com.jtzh.szcj.entity.EpidemicPrevention;
import com.jtzh.szcj.entity.RememberMission;
import com.jtzh.szcj.search.EpidemicPreventionSearch;
import com.jtzh.szcj.search.RememberMissionSearch;
import com.jtzh.szcj.service.EpidemicPreventionService;
import com.jtzh.szcj.service.RememberMissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/epidemicPrevention")
public class EpidemicPreventionController {

    @Resource
    private EpidemicPreventionService epidemicPreventionServiceImpl;

    @PostMapping("/")
    public ResultObject insert(@RequestBody EpidemicPrevention epidemicPrevention) {
        if (epidemicPrevention.getCreateTime() == null) {
            epidemicPrevention.setCreateTime(new Date());
        }
        Integer insertRows = epidemicPreventionServiceImpl.insert(epidemicPrevention);
        if (insertRows == null || insertRows == 0) {
            return ResultObject.of(false, null, "新增失败");
        }
        return ResultObject.of(true, epidemicPrevention, "新增成功");
    }

    @PutMapping("/{id}")
    public ResultObject update(@PathVariable String id, @RequestBody EpidemicPrevention epidemicPrevention) {
        epidemicPrevention.setId(Integer.valueOf(id));
        Integer insertRows = epidemicPreventionServiceImpl.update(epidemicPrevention);
        if (insertRows == null || insertRows == 0) {
            return ResultObject.of(false, null, "修改失败");
        }
        return ResultObject.of(true, epidemicPrevention, "修改成功");
    }

    @GetMapping("/{id}")
    public ResultObject get(@PathVariable String id) {
        EpidemicPrevention epidemicPrevention = epidemicPreventionServiceImpl.get(Integer.valueOf(id));
        if (epidemicPrevention == null) {
            return ResultObject.of(false, null, "查询失败");
        }
        return ResultObject.of(true, epidemicPrevention, "查询成功");
    }

    @DeleteMapping("/{id}")
    public ResultObject delete(@PathVariable String id) {
        Integer insertRows = epidemicPreventionServiceImpl.delete(Integer.valueOf(id));
        if (insertRows == null) {
            return ResultObject.of(false, null, "删除失败");
        }
        return ResultObject.of(true, null, "删除成功");
    }

    @PostMapping("/page")
    public ResultObject page(@RequestBody EpidemicPreventionSearch epidemicPreventionSearch) {
        List<EpidemicPrevention> rememberMissions = epidemicPreventionServiceImpl.page(epidemicPreventionSearch);
        Page page = epidemicPreventionSearch.getPage();
        page.setData(rememberMissions);
        page.setTotal(epidemicPreventionServiceImpl.total(epidemicPreventionSearch));
        return ResultObject.of(true, page, "查询成功");
    }

}
