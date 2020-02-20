package com.jtzh.szcj.service;

import com.jtzh.szcj.entity.EpidemicPrevention;
import com.jtzh.szcj.search.EpidemicPreventionSearch;

import java.util.List;

public interface EpidemicPreventionService {

    Integer insert(EpidemicPrevention rememberMission);

    Integer update(EpidemicPrevention rememberMission);

    Integer delete(Integer id);

    EpidemicPrevention get(Integer id);

    List<EpidemicPrevention> page(EpidemicPreventionSearch rememberMissionSearch);

    Integer total(EpidemicPreventionSearch rememberMissionSearch);
}
