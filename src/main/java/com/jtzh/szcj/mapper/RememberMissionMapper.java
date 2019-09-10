package com.jtzh.szcj.mapper;

import com.jtzh.szcj.entity.RememberMission;
import com.jtzh.szcj.search.RememberMissionSearch;

import java.util.List;

public interface RememberMissionMapper {

    Integer insert(RememberMission rememberMission);

    Integer update(RememberMission rememberMission);

    Integer delete(Integer id);

    RememberMission get(Integer id);

    List<RememberMission> page(RememberMissionSearch rememberMissionSearch);

}
