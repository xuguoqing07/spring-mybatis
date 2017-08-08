package com.bjsxt.sm.users.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.cm.common.test.BaseTest;
import com.bjsxt.cm.common.util.ConstantFinalUtil;
import com.bjsxt.cm.common.util.PageInfoUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.ARole;
import com.bjsxt.sm.users.service.IUserService;

/**
 * 每一个 Service 提供一个测试类
 * @author XuGuoQing07
 *
 */

public class UsersServiceTest extends BaseTest
{
	private IUserService usersService;
	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		super.init();
		/*
		 * 当我们在getbean中填写的参数的时候,
		 * 一定得想一想想一想,在SPring容器中有木有一个叫做参数的bean
		 * Spring容器有两种配置方法,一个xml,一个是注解 
		 */
		this.usersService=(IUserService) this.ac.getBean("usersService");
	}
	
	/**
	 * 测试类
	 */
	@Test
	public void findOneAdminsService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", 2);
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		ConstantFinalUtil.LOGGER.info("管理员:id:{},email:{},createTime:{}",
				admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
		
		ARole role = admins.getRole() ; 
		ConstantFinalUtil.LOGGER.info("角色:id:{},name:{},createTime:{}",
				role.getId(),role.getName(),role.getCreateTime().toLocaleString());
	}
	
	/**
	 * 测试保存一条记录
	 * 
	 * 可以插入成功
	 * 如果说插入数据库以后,执行代码报错了,希望回滚(事务管理器)
	 * 
	 * 期望Service的方法的整个过程,应该被一个事务包含起来.
	 * 如果成功,大家都成功,如果失败,大家都失败
	 * 
	 * 事务不应该放到Dao层,因为一个dao对应一张表,如果将来有多张表的操作,其中一个表的操作失败了,事务回滚,
	 * 请问:将事务的打开和提交,放到哪个dao上合适呢????
	 * 
	 * 事务放在Service层比较合适,因为一个Service有多个Dao
	 */
	@Test
	public void saveOneAdminsService()
	{
		AAdmins admins=new AAdmins();
		admins.setEmail("33");
		admins.setPassword("44");
		admins.setCreateTime(new Date());
		admins.setUpdateTime(new Date());
		JSONObject resultJSON = this.usersService.saveOneAdminsService(admins);
		/* json字符串 */
		ConstantFinalUtil.LOGGER.info("结果:{}",resultJSON.toJSONString());
	}
	
	/**
	 * 查询 多条管理员
	 */
	@Test
	public void findCondListAdminsService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 按照关键字查询
		 * 模糊查询的问题 
		 * */
		/*condMap.put("keyword", "4");*/
		/* 按照状态查询 */
		/*condMap.put("status", "1");*/
		/* 按照时间范围查询 */
		/*condMap.put("st", new Date());
		condMap.put("ed", new Date());*/
		
		/* 参数1:如果为null,表示不分页 */
		/*List<AAdmins> adminsList = this.usersService.findCondListAdminsService(null,condMap);*/
		
		PageInfoUtil pageInfoUtil=new PageInfoUtil();
		List<AAdmins> adminsList = this.usersService.findCondListAdminsService(pageInfoUtil,condMap);
		int count = 1 ;
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			ConstantFinalUtil.LOGGER.info("条数:{},管理员:id:{},email:{},createTime:{}",
					count , 
					admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
			count ++ ; 
		}
		ConstantFinalUtil.LOGGER.info("分页的信息:当前页:{},总条数:{},总页数:{}",
				pageInfoUtil.getCurrentPage() , pageInfoUtil.getTotalRecord(),pageInfoUtil.getTotalPage());
	}
	
	/**
	 * 更新一条记录
	 */
	@Test
	public void updateOneAdminsService()
	{
		/* 按照id查询,
		 * 在更新之前先查询出来
		 *  */
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "4");
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		admins.setEmail("3333@333.com");
		JSONObject resultJOSN = this.usersService.updateOneAdminsService(admins);
		/* json字符串 */
		ConstantFinalUtil.LOGGER.info("结果:{}",resultJOSN.toJSONString());
	}
	
	@Test
	public void findOneRoleService()
	{
		/* 条件 */
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "2");
		/*map啥也木有填写,默认按照啥查询 */
		ARole role = this.usersService.findOneRoleService(condMap);
		ConstantFinalUtil.LOGGER.info("角色:id:{},name:{},createTime:{}",
				role.getId(),role.getName(),role.getCreateTime().toLocaleString());
	
		int count = 1 ; 
		List<AAdmins> adminsList = role.getAdminsList();
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			ConstantFinalUtil.LOGGER.info("条数:{},管理员:id:{},email:{},createTime:{}",
					count , 
					admins.getId(),admins.getEmail(),admins.getCreateTime().toLocaleString());
			count ++ ; 
		}
	}
}
