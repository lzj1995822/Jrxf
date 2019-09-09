package com.jtzh.szcj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.szcj.common.page.Page;
import com.jtzh.szcj.entity.Wz;

public interface WzMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Wz record);

    int insertSelective(Wz record);

    Wz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Wz record);

    int updateWz(Wz record);
    
    List<Wz> getWz(@Param("page") Page page);
    List<Wz> getindex(@Param("flid") String flid,@Param("Size")int Size);
    List<Wz> getWzs(Wz record);
    int getWzTotal(@Param("page") Page page);
    
    int modifyZt(@Param("id") String id,@Param("zt") String zt);
    int removeWz(@Param("id") String id);

	Wz getWzInfo(@Param("id")String id);
	
	Wz getUp(@Param("id")String id,@Param("flid")String flid);
	
	Wz getDown(@Param("id")String id,@Param("flid")String flid);
	List<Wz> getRand();
	void modifyYdl(@Param("id")String id);
}