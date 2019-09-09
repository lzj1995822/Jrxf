package com.jtzh.szcj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.szcj.entity.Lbtp;

public interface LbtpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lbtp record);

    int insertSelective(Lbtp record);

    Lbtp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lbtp record);

    int updateByPrimaryKey(Lbtp record);
    
    List<Lbtp> getLbtp();
    
    int removeLbtp(@Param("id") String id);
    int updataLbtpZt(@Param("id") String id,@Param("zt") String zt);
    int updataLbtp(Lbtp record);
}