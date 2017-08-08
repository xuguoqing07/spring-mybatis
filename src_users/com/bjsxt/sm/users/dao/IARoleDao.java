package com.bjsxt.sm.users.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.sm.users.pojo.ARole;

/**
 * 
 * 管理员 Dao 的接口
 * 一个 Dao 对应一张表
 * @author XuGuoQing07
 *
 */
public interface IARoleDao
{
	
	/**
	 * 保存一条记录
	 * @param role	条件,主键期望放到id属性上
	 * @return	影响的条数
	 */
	int save(ARole role);
	
	/**
	 * 更新一条记录
	 * @param role	
	 * @return	影响的条数
	 */
	int update(ARole role);
	
	
	/**
	 * 查询一条记录
	 * @param condMap
	 * @return
	 */
	ARole findOne(Map<String, Object> condMap);
	
	/**
	 * 查询多條记录
	 * @param condMap
	 * @return
	 */
	List<ARole> findCondList(Map<String, Object> condMap);
}
