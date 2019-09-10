package com.jtzh.szcj.service;

import com.jtzh.szcj.entity.RememberMission;
import com.jtzh.szcj.search.RememberMissionSearch;

import java.util.List;

public interface RememberMissionService {

    Integer insert(RememberMission rememberMission);

    Integer update(RememberMission rememberMission);

    Integer delete(Integer id);

    RememberMission get(Integer id);

    List<RememberMission> page(RememberMissionSearch rememberMissionSearch);
}
