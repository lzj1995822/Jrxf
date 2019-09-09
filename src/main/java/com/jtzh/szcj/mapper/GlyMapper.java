package com.jtzh.szcj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.szcj.entity.Gly;

public interface GlyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gly record);

    int insertSelective(Gly record);

    Gly selectById(@Param("id")String id);
    
    List<Gly> seleteGlys();

    int updateByPrimaryKeySelective(Gly record);

    int updateByPrimaryKey(Gly record);
    
    Gly seleteGlysByZh(@Param("zh")String zh);
    
    int getGlyByZh(@Param("zh")String zh);
    
    int updateZt(@Param("zh")String zh,@Param("zt")String zt);
    
    int updateMm(@Param("zh")String zh,@Param("mm")String mm);
    
    int removeZh(@Param("id")String id);
}