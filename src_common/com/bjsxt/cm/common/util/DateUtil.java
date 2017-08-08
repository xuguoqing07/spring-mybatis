package com.bjsxt.cm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 日期的工具类
 * @author XuGuoQing07
 *
 */
@Component("dateUtil")
public class DateUtil
{
	/**
	 * 将字符串转换成Date
	 * 字符串的格式采用默认的"yyyy-MM-dd HH:mm:ss"
	 * @param st
	 * @return
	 */
	public Date strDate(String st)
	{
		/* 日期时间格式化 */
		SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantFinalUtil.DATE_TIME_PATTERN);
		try
		{
			return dateFormat.parse(st);
		} catch (ParseException e)
		{
		}
		return null;
	}
}
