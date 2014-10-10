package com.maeiei.dao;

import com.maeiei.model.ResultData;
import com.maeiei.model.ResultDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultDataMapper {
	int insert(ResultData record);

	int insertSelective(ResultData record);

	int countByCriteria(ResultDataCriteria criteria);

    int deleteByCriteria(ResultDataCriteria criteria);

    List<ResultData> selectByCriteria(ResultDataCriteria criteria);

    int updateByCriteriaSelective(@Param("record") ResultData record, @Param("criteria") ResultDataCriteria criteria);

    int updateByCriteria(@Param("record") ResultData record, @Param("criteria") ResultDataCriteria criteria);
}