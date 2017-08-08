package com.bjsxt.sm.users.service;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.cm.common.util.PageInfoUtil;
/**
 * Service
 * 
 * 一个Service持有多个Dao
 * @author XuGuoQing07
 *
 */
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.ARole;

public interface IUserService
{
	/*--------管理員操作開始---------*/
	/**
	 * 保存一条管理员
	 * 
	 * {
			//响应码
			"code" : "0",
			//提示信息
			"info" : "成功",
			//数据 
			"data" : {
				 //影响条数
				"effect" : "0",
				//id 
				"id" : ""
			}
		}
		
		JSON:{},[]
			~将java对象变成json字符串
			~将json字符串变成java对象
 			~凡是{},就是jsonObject,凡是[],就是jsonArray
	 */
	JSONObject saveOneAdminsService(AAdmins admins);
	
	JSONObject updateOneAdminsService(AAdmins admins);
	/**
	 * 查询一条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的管理员
	 */
	AAdmins findOneAdminsService(Map<String, Object> condMap);
	
	/**
	 * 查询多条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的多条管理员
	 */
	List<AAdmins> findCondListAdminsService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap);
	/*--------管理員操作結束---------*/
	
	/*--------角色操作開始---------*/
	/**
	 * 保存一条管理员
	 * 
	 * {
			//响应码
			"code" : "0",
			//提示信息
			"info" : "成功",
			//数据 
			"data" : {
				 //影响条数
				"effect" : "0",
				//id 
				"id" : ""
			}
		}
		
		JSON:{},[]
			~将java对象变成json字符串
			~将json字符串变成java对象
 			~凡是{},就是jsonObject,凡是[],就是jsonArray
	 */
	JSONObject saveOneRoleService(ARole role);
	
	JSONObject updateOneRoleService(ARole role);
	/**
	 * 查询一条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的管理员
	 */
	ARole findOneRoleService(Map<String, Object> condMap);
	
	/**
	 * 查询多条管理员
	 * @param condMap	条件,键:mapper文件中的#{键},值是条件
	 * @return	查询的多条管理员
	 */
	List<ARole> findCondListRoleService(PageInfoUtil pageInfoUtil , Map<String, Object> condMap);
	/*--------角色操作結束---------*/
}
