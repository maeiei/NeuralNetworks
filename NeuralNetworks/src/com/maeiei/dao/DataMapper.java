package com.maeiei.dao;

import com.maeiei.model.Data;
import com.maeiei.model.DataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataMapper {
    int countByCriteria(DataCriteria criteria);

    int deleteByCriteria(DataCriteria criteria);

    int insert(Data record);

    int insertSelective(Data record);

    List<Data> selectByCriteria(DataCriteria criteria);

    int updateByCriteriaSelective(@Param("record") Data record, @Param("criteria") DataCriteria criteria);

    int updateByCriteria(@Param("record") Data record, @Param("criteria") DataCriteria criteria);
}