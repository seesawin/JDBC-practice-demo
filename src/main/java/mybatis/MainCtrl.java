package mybatis;

import java.text.SimpleDateFormat;
import java.util.List;

import mybatis.persistence.TbDate;
import mybatis.persistence.TbDateExample;
import mybatis.service.TbDateService;
import mybatis.service.impl.TbDateServiceImpl;

import org.apache.commons.lang3.builder.ToStringBuilder;

import util.DateUtil;

public class MainCtrl {

	public static void main(String[] args) throws Exception {
		TbDateService service = new TbDateServiceImpl();
		String year = "1906";

		// 1. CRUD
		MainCtrl.testCrud(service, year);

		// 2.Transaction
		service.crudTransaction(year);
	}

	public static void testCrud(TbDateService service, String year) throws Exception {

		/**************************************** select ********************************************/

		TbDateExample example = new TbDateExample();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		example.createCriteria().andDYear4EqualTo(year);

		List<TbDate> list = service.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(ToStringBuilder.reflectionToString(list.get(i)));
		}

		/**************************************** count ********************************************/

		int count = 0;

		count = service.countByExample(example);
		System.out.println("select count : " + count);

		/**************************************** insert ********************************************/

		TbDate insertRecord = new TbDate();
		insertRecord.setdYear4(year);
		insertRecord.setdDate(dateFormat.parse("2005/10/28"));
		insertRecord.setdTime(DateUtil.getTimeFromString("2008-02-02 16:15:32", "yyyy-MM-dd hh:mm:ss"));
		insertRecord.setdDatetime(DateUtil.getTimestampFromString("2015/04/12", "yyyy/MM/dd"));
		insertRecord.setdTimestamp(DateUtil.getTimestampFromString("2010/12/17", "yyyy/MM/dd"));
		count = service.insertSelective(insertRecord);
		System.out.println("insert count : " + count);

		/**************************************** update ********************************************/

		TbDate updateRecord = new TbDate();
		updateRecord.setdDate(dateFormat.parse("2005/10/28"));
		updateRecord.setdTime(DateUtil.getTimeFromString("2008-02-02 16:15:32", "yyyy-MM-dd hh:mm:ss"));
		updateRecord.setdDatetime(DateUtil.getTimestampFromString("2015/04/12", "yyyy/MM/dd"));
		updateRecord.setdTimestamp(DateUtil.getTimestampFromString("2010/12/17", "yyyy/MM/dd"));
		count = service.updateByExampleSelective(updateRecord, example);
		System.out.println("update count : " + count);

		/**************************************** delete ********************************************/

		count = service.deleteByExample(example);
		System.out.println("delete count : " + count);
	}
}
