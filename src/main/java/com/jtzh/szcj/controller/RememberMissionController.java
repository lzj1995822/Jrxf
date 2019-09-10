package com.jtzh.szcj.controller;

import com.jtzh.szcj.common.ResultObject;
import com.jtzh.szcj.common.page.Page;
import com.jtzh.szcj.entity.RememberMission;
import com.jtzh.szcj.search.RememberMissionSearch;
import com.jtzh.szcj.service.RememberMissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rememberMission")
public class RememberMissionController {

    @Resource
    private RememberMissionService rememberMissionServiceImpl;

    @PostMapping("/")
    public ResultObject insert(@RequestBody RememberMission rememberMission) {
        Integer insertRows = rememberMissionServiceImpl.insert(rememberMission);
        if (insertRows == null || insertRows == 0) {
            return ResultObject.of(false, null, "新增失败");
        }
        return ResultObject.of(true, rememberMission, "新增成功");
    }

    @PutMapping("/{id}")
    public ResultObject update(@PathVariable String id, @RequestBody RememberMission rememberMission) {
        rememberMission.setId(Integer.valueOf(id));
        Integer insertRows = rememberMissionServiceImpl.update(rememberMission);
        if (insertRows == null || insertRows == 0) {
            return ResultObject.of(false, null, "修改失败");
        }
        return ResultObject.of(true, rememberMission, "修改成功");
    }

    @GetMapping("/{id}")
    public ResultObject get(@PathVariable String id) {
        RememberMission rememberMission = rememberMissionServiceImpl.get(Integer.valueOf(id));
        if (rememberMission == null) {
            return ResultObject.of(false, null, "查询失败");
        }
        return ResultObject.of(true, rememberMission, "查询成功");
    }

    @DeleteMapping("/{id}")
    public ResultObject delete(@PathVariable String id) {
        Integer insertRows = rememberMissionServiceImpl.delete(Integer.valueOf(id));
        if (insertRows == null) {
            return ResultObject.of(false, null, "删除失败");
        }
        return ResultObject.of(true, null, "删除成功");
    }

    @PostMapping("/page")
    public ResultObject page(@RequestBody RememberMissionSearch rememberMissionSearch) {
        List<RememberMission> rememberMissions = rememberMissionServiceImpl.page(rememberMissionSearch);
        Page page = rememberMissionSearch.getPage();
        page.setData(rememberMissions);
        return ResultObject.of(true, page, "查询成功");
    }

}
