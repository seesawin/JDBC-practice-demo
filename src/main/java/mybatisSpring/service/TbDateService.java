package mybatisSpring.service;

import java.util.List;

import mybatis.persistence.TbDate;
import mybatis.persistence.TbDateExample;

import org.apache.ibatis.annotations.Param;

public interface TbDateService {
	int countByExample(TbDateExample example);

	int deleteByExample(TbDateExample example);

	int insert(TbDate record);

	int insertSelective(TbDate record);

	List<TbDate> selectByExample(TbDateExample example);

	int updateByExampleSelective(@Param("record") TbDate record, @Param("example") TbDateExample example);

	int updateByExample(@Param("record") TbDate record, @Param("example") TbDateExample example);

	void crudTransaction(String year) throws Exception;
}
