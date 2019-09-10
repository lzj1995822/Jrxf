package com.jtzh.szcj.service.Impl;

import com.jtzh.szcj.entity.RememberMission;
import com.jtzh.szcj.mapper.RememberMissionMapper;
import com.jtzh.szcj.search.RememberMissionSearch;
import com.jtzh.szcj.service.RememberMissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RememberMissionServiceImpl implements RememberMissionService {

    @Resource
    private RememberMissionMapper rememberMissionMapper;

    public Integer insert(RememberMission rememberMission) {
        return rememberMissionMapper.insert(rememberMission);
    }

    public Integer update(RememberMission rememberMission) {
        return rememberMissionMapper.update(rememberMission);
    }

    public Integer delete(Integer id) {
        return rememberMissionMapper.delete(id);
    }

    public RememberMission get(Integer id) {
        return rememberMissionMapper.get(id);
    }

    public List<RememberMission> page(RememberMissionSearch rememberMissionSearch) {
        return rememberMissionMapper.page(rememberMissionSearch);
    }

    @Override
    public Integer total(RememberMissionSearch rememberMissionSearch) {
        return rememberMissionMapper.total(rememberMissionSearch);
    }
}
