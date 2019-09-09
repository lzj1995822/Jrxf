package com.jtzh.szcj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.szcj.entity.Fl;

public interface FlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fl record);

    int insertSelective(Fl record);

    List<Fl> selectByfflid(@Param("fflid")String fflid);
    Fl selectByflid(@Param("flid")String flid);
    int updateByPrimaryKeySelective(Fl record);

    int updateByPrimaryKey(Fl record);
}