package mybatis.mapper;

import java.util.List;
import mybatis.persistence.TbNumber;
import mybatis.persistence.TbNumberExample;
import org.apache.ibatis.annotations.Param;

public interface TbNumberMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int countByExample(TbNumberExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int deleteByExample(TbNumberExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int insert(TbNumber record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int insertSelective(TbNumber record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	List<TbNumber> selectByExample(TbNumberExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TbNumber record, @Param("example") TbNumberExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_NUMBER
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	int updateByExample(@Param("record") TbNumber record, @Param("example") TbNumberExample example);
}