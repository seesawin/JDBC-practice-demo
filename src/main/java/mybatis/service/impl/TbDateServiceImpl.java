package mybatis.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import mybatis.mapper.TbDateMapper;
import mybatis.persistence.TbDate;
import mybatis.persistence.TbDateExample;
import mybatis.service.TbDateService;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.session.SqlSession;

import util.DateUtil;
import util.MyBatisSqlSessionFactory;

public class TbDateServiceImpl implements TbDateService {

	private SqlSession session;

	public int countByExample(TbDateExample example) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.countByExample(example);

		session.close();

		return count;
	}

	public int deleteByExample(TbDateExample example) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.deleteByExample(example);

		session.commit();
		session.close();

		return count;
	}

	public int insert(TbDate record) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.insert(record);

		session.commit();
		session.close();

		return count;
	}

	public int insertSelective(TbDate record) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.insertSelective(record);

		session.commit();
		session.close();

		return count;
	}

	public List<TbDate> selectByExample(TbDateExample example) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		List<TbDate> list = tbDateMapper.selectByExample(example);

		session.close();

		return list;
	}

	public int updateByExampleSelective(TbDate record, TbDateExample example) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.updateByExampleSelective(record, example);

		session.commit();
		session.close();

		return count;
	}

	public int updateByExample(TbDate record, TbDateExample example) {
		session = MyBatisSqlSessionFactory.openSession();

		TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

		int count = tbDateMapper.updateByExample(record, example);

		session.commit();
		session.close();

		return count;
	}

	public void crudTransaction(String year) throws Exception {
		session = MyBatisSqlSessionFactory.openSession();
		try {
			TbDateMapper tbDateMapper = session.getMapper(TbDateMapper.class);

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

			if (1 == 1) {
				throw new Exception("something wrong!");
			}

			session.commit();
			System.out.println("commit");
		} catch (Exception e) {
			session.rollback();
			System.out.println("rollback");
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}

}
