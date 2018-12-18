package mybatis.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbDateExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public TbDateExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value.getTime()), property);
		}

		protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				timeList.add(new java.sql.Time(iter.next().getTime()));
			}
			addCriterion(condition, timeList, property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
		}

		public Criteria andDYear4IsNull() {
			addCriterion("d_year_4 is null");
			return (Criteria) this;
		}

		public Criteria andDYear4IsNotNull() {
			addCriterion("d_year_4 is not null");
			return (Criteria) this;
		}

		public Criteria andDYear4EqualTo(String value) {
			addCriterion("d_year_4 =", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4NotEqualTo(String value) {
			addCriterion("d_year_4 <>", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4GreaterThan(String value) {
			addCriterion("d_year_4 >", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4GreaterThanOrEqualTo(String value) {
			addCriterion("d_year_4 >=", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4LessThan(String value) {
			addCriterion("d_year_4 <", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4LessThanOrEqualTo(String value) {
			addCriterion("d_year_4 <=", value, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4In(List<String> values) {
			addCriterion("d_year_4 in", values, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4NotIn(List<String> values) {
			addCriterion("d_year_4 not in", values, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4Between(String value1, String value2) {
			addCriterion("d_year_4 between", value1, value2, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDYear4NotBetween(String value1, String value2) {
			addCriterion("d_year_4 not between", value1, value2, "dYear4");
			return (Criteria) this;
		}

		public Criteria andDDateIsNull() {
			addCriterion("d_date is null");
			return (Criteria) this;
		}

		public Criteria andDDateIsNotNull() {
			addCriterion("d_date is not null");
			return (Criteria) this;
		}

		public Criteria andDDateEqualTo(Date value) {
			addCriterionForJDBCDate("d_date =", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("d_date <>", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateGreaterThan(Date value) {
			addCriterionForJDBCDate("d_date >", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("d_date >=", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateLessThan(Date value) {
			addCriterionForJDBCDate("d_date <", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("d_date <=", value, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateIn(List<Date> values) {
			addCriterionForJDBCDate("d_date in", values, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("d_date not in", values, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("d_date between", value1, value2, "dDate");
			return (Criteria) this;
		}

		public Criteria andDDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("d_date not between", value1, value2, "dDate");
			return (Criteria) this;
		}

		public Criteria andDTimeIsNull() {
			addCriterion("d_time is null");
			return (Criteria) this;
		}

		public Criteria andDTimeIsNotNull() {
			addCriterion("d_time is not null");
			return (Criteria) this;
		}

		public Criteria andDTimeEqualTo(Date value) {
			addCriterionForJDBCTime("d_time =", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeNotEqualTo(Date value) {
			addCriterionForJDBCTime("d_time <>", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeGreaterThan(Date value) {
			addCriterionForJDBCTime("d_time >", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("d_time >=", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeLessThan(Date value) {
			addCriterionForJDBCTime("d_time <", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("d_time <=", value, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeIn(List<Date> values) {
			addCriterionForJDBCTime("d_time in", values, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeNotIn(List<Date> values) {
			addCriterionForJDBCTime("d_time not in", values, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("d_time between", value1, value2, "dTime");
			return (Criteria) this;
		}

		public Criteria andDTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("d_time not between", value1, value2, "dTime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeIsNull() {
			addCriterion("d_datetime is null");
			return (Criteria) this;
		}

		public Criteria andDDatetimeIsNotNull() {
			addCriterion("d_datetime is not null");
			return (Criteria) this;
		}

		public Criteria andDDatetimeEqualTo(Date value) {
			addCriterion("d_datetime =", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeNotEqualTo(Date value) {
			addCriterion("d_datetime <>", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeGreaterThan(Date value) {
			addCriterion("d_datetime >", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("d_datetime >=", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeLessThan(Date value) {
			addCriterion("d_datetime <", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeLessThanOrEqualTo(Date value) {
			addCriterion("d_datetime <=", value, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeIn(List<Date> values) {
			addCriterion("d_datetime in", values, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeNotIn(List<Date> values) {
			addCriterion("d_datetime not in", values, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeBetween(Date value1, Date value2) {
			addCriterion("d_datetime between", value1, value2, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDDatetimeNotBetween(Date value1, Date value2) {
			addCriterion("d_datetime not between", value1, value2, "dDatetime");
			return (Criteria) this;
		}

		public Criteria andDTimestampIsNull() {
			addCriterion("d_timestamp is null");
			return (Criteria) this;
		}

		public Criteria andDTimestampIsNotNull() {
			addCriterion("d_timestamp is not null");
			return (Criteria) this;
		}

		public Criteria andDTimestampEqualTo(Date value) {
			addCriterion("d_timestamp =", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampNotEqualTo(Date value) {
			addCriterion("d_timestamp <>", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampGreaterThan(Date value) {
			addCriterion("d_timestamp >", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampGreaterThanOrEqualTo(Date value) {
			addCriterion("d_timestamp >=", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampLessThan(Date value) {
			addCriterion("d_timestamp <", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampLessThanOrEqualTo(Date value) {
			addCriterion("d_timestamp <=", value, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampIn(List<Date> values) {
			addCriterion("d_timestamp in", values, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampNotIn(List<Date> values) {
			addCriterion("d_timestamp not in", values, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampBetween(Date value1, Date value2) {
			addCriterion("d_timestamp between", value1, value2, "dTimestamp");
			return (Criteria) this;
		}

		public Criteria andDTimestampNotBetween(Date value1, Date value2) {
			addCriterion("d_timestamp not between", value1, value2, "dTimestamp");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TB_DATE
	 * @mbggenerated  Fri Dec 14 11:40:48 CST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_DATE
     *
     * @mbggenerated do_not_delete_during_merge Fri Dec 14 09:55:13 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}