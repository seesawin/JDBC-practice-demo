package mybatisSpring.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import mybatis.mapper.TbDateMapper;
import mybatis.persistence.TbDate;
import mybatis.persistence.TbDateExample;
import mybatis.service.TbDateService;

import org.apache.commons.lang3.builder.ToStringBuilder;

import util.DateUtil;

public class TbDateServiceImpl implements TbDateService {

	private TbDateMapper tbDateMapper;

	public void setTbDateMapper(TbDateMapper tbDateMapper) {
		this.tbDateMapper = tbDateMapper;
	}

	public int countByExample(TbDateExample example) {
		int count = tbDateMapper.countByExample(example);
		return count;
	}

	public int deleteByExample(TbDateExample example) {
		int count = tbDateMapper.deleteByExample(example);
		return count;
	}

	public int insert(TbDate record) {
		int count = tbDateMapper.insert(record);
		return count;
	}

	public int insertSelective(TbDate record) {
		int count = tbDateMapper.insertSelective(record);
		return count;
	}

	public List<TbDate> selectByExample(TbDateExample example) {
		List<TbDate> list = tbDateMapper.selectByExample(example);
		return list;
	}

	public int updateByExampleSelective(TbDate record, TbDateExample example) {
		int count = tbDateMapper.updateByExampleSelective(record, example);
		return count;
	}

	public int updateByExample(TbDate record, TbDateExample example) {
		int count = tbDateMapper.updateByExample(record, example);
		return count;
	}

	public void crudTransaction(String year) throws Exception {

		/**************************************** insert ********************************************/

		TbDateExample example = new TbDateExample();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int count = 0;

		TbDate insertRecord = new TbDate();
		insertRecord.setdYear4(year);
		insertRecord.setdDate(dateFormat.parse("2005/10/28"));
		insertRecord.setdTime(DateUtil.getTimeFromString("2008-02-02 16:15:32", "yyyy-MM-dd hh:mm:ss"));
		insertRecord.setdDatetime(DateUtil.getTimestampFromString("2015/04/12", "yyyy/MM/dd"));
		insertRecord.setdTimestamp(DateUtil.getTimestampFromString("2010/12/17", "yyyy/MM/dd"));

		count = tbDateMapper.insertSelective(insertRecord);
		System.out.println("insert count : " + count);

		List<TbDate> list = tbDateMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("after insert : " + ToStringBuilder.reflectionToString(list.get(i)));
		}

		System.out.println("sleep 5 sec...");
		Thread.sleep(5000);

		/**************************************** update ********************************************/

		TbDate updateRecord = new TbDate();
		updateRecord.setdDate(dateFormat.parse("2005/10/28"));
		updateRecord.setdTime(DateUtil.getTimeFromString("2008-02-02 16:15:32", "yyyy-MM-dd hh:mm:ss"));
		updateRecord.setdDatetime(DateUtil.getTimestampFromString("2015/04/12", "yyyy/MM/dd"));
		updateRecord.setdTimestamp(DateUtil.getTimestampFromString("2010/12/17", "yyyy/MM/dd"));
		count = tbDateMapper.updateByExampleSelective(updateRecord, example);
		System.out.println("update count : " + count);

		list = tbDateMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("after update : " + ToStringBuilder.reflectionToString(list.get(i)));
		}

		System.out.println("sleep 5 sec...");
		Thread.sleep(5000);

		// if (1 == 1) {
		// throw new Exception("something wrong!");
		// }

		System.out.println("commit");
	}

}
