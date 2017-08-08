package com.bjsxt.cm.common.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.cm.common.util.ConstantFinalUtil;

/**
 * 所有测试类的父类
 * @author XuGuoQing07
 *
 */

public class BaseTest
{

	/*Spring 的核心工具类*/
	protected ApplicationContext ac;
	
	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		ac=new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		ConstantFinalUtil.LOGGER.info("===ac:{}",ac);
	}
	
	/**
	 * 测试一下
	 */
	@Test
	public void test()
	{
		ConstantFinalUtil.LOGGER.info("------test------");
	}
	
	/**
	 * 关闭
	 */
	@After
	public void after()
	{
		if(this.ac instanceof ClassPathXmlApplicationContext){
			/* 代码能够执行到这一行,说明 ac肯定是ClassPathXmlApplicationContext的一个对象
			 * 强转肯定能够成功*/
			ClassPathXmlApplicationContext cpxac=(ClassPathXmlApplicationContext) this.ac;
			cpxac.close();
			ConstantFinalUtil.LOGGER.info("------close------");
		}
	}
	
}
