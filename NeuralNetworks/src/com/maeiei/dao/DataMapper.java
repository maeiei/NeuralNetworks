package com.maeiei.dao;

import com.maeiei.model.Data;
import com.maeiei.model.DataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataMapper {
    int countByExample(DataCriteria example);

    int deleteByExample(DataCriteria example);

    int insert(Data record);

    int insertSelective(Data record);

    List<Data> selectByExample(DataCriteria example);

    int updateByExampleSelective(@Param("record") Data record, @Param("example") DataCriteria example);

    int updateByExample(@Param("record") Data record, @Param("example") DataCriteria example);
}