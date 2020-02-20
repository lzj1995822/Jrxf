package com.jtzh.szcj.service.Impl;

import com.jtzh.szcj.entity.EpidemicPrevention;
import com.jtzh.szcj.mapper.EpidemicPreventionMapper;
import com.jtzh.szcj.search.EpidemicPreventionSearch;
import com.jtzh.szcj.service.EpidemicPreventionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EpidemicPreventionServiceImpl implements EpidemicPreventionService {

    @Resource
    private EpidemicPreventionMapper epidemicPreventionMapper;

    public Integer insert(EpidemicPrevention rememberMission) {
        return epidemicPreventionMapper.insert(rememberMission);
    }

    public Integer update(EpidemicPrevention rememberMission) {
        return epidemicPreventionMapper.update(rememberMission);
    }

    public Integer delete(Integer id) {
        return epidemicPreventionMapper.delete(id);
    }

    public EpidemicPrevention get(Integer id) {
        return epidemicPreventionMapper.get(id);
    }

    public List<EpidemicPrevention> page(EpidemicPreventionSearch rememberMissionSearch) {
        return epidemicPreventionMapper.page(rememberMissionSearch);
    }

    @Override
    public Integer total(EpidemicPreventionSearch rememberMissionSearch) {
        return epidemicPreventionMapper.total(rememberMissionSearch);
    }
}
