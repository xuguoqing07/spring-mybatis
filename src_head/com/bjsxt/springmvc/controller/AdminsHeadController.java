package com.bjsxt.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.cm.common.util.ConstantFinalUtil;
import com.bjsxt.cm.common.util.DateUtil;
import com.bjsxt.cm.common.util.PageInfoUtil;
import com.bjsxt.sm.users.pojo.AAdmins;
import com.bjsxt.sm.users.pojo.AAdminsEnum;
import com.bjsxt.sm.users.pojo.ARole;
import com.bjsxt.sm.users.service.IUserService;

/**
 * 管理员的 controller
 * @author XuGuoQing07
 *
 */
@Controller
public class AdminsHeadController
{
	@Resource
	private DateUtil dateUtil;
	@Resource
	private IUserService usersService;
	
	/*---- 管理员操作模块开始 ----*/
	/**
	 * 管理员列表页面
	 * @return
	 */
	@RequestMapping("/adminsList")
	public String adminsList(String keyword,String status,String st,String ed,
			String currentPage,String pageSize,Model model)
	{
		ConstantFinalUtil.LOGGER.info("=====adminsList=====");
		/*
		 * 如果不传,默认可是null
		 * */
		if(keyword == null)
		{
			keyword = "" ; 
		}
		if(status == null)
		{
			status = "" ; 
		}
		if(st == null)
		{
			st = "" ; 
		}
		if(ed == null)
		{
			ed = "" ; 
		}
		/* 条件  问 JSP 要，从 request 中获取*/
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 按照关键字查询
		 * 模糊查询的问题 
		 * */
		if(!"".equalsIgnoreCase(keyword))
		{
			condMap.put("keyword", keyword);
		}
		/* 按照状态查询 */
		if(!"".equalsIgnoreCase(status))
		{
			condMap.put("status", status);
		}
		
		/* 按照时间范围查询
		 * 在搜索的时候,我传入的是Date类型,但是在request接收的时候可是字符串类型
		 * 得将request中取的字符串变成Date类型的时间
		 * 迫切的需要一个日期的工具类
		 *  */
		Date stDate = null;
		Date edDate = null;
		if(!"".equalsIgnoreCase(st) && !"".equalsIgnoreCase(ed))
		{
			stDate = this.dateUtil.strDate(st);
			edDate = this.dateUtil.strDate(ed);
		}
		
		condMap.put("st", stDate);
		condMap.put("ed", edDate);
		/*condMap.put("keyword", "4");*/
		
		/* 分页 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		try
		{
			pageInfoUtil.setCurrentPage(Integer.valueOf(currentPage));
			pageInfoUtil.setPageSize(Integer.valueOf(pageSize));
		} catch (NumberFormatException e)
		{
			
		}
		List<AAdmins> adminsList = this.usersService.findCondListAdminsService(pageInfoUtil,condMap);
		/* 查询出的数据存储到四大作用域名中 */
		model.addAttribute("adminsList",adminsList);
		model.addAttribute("pageInfoUtil",pageInfoUtil);
		
		/*存储所有的条件*/
		model.addAttribute("keyword",keyword);
		model.addAttribute("status",status);
		model.addAttribute("st",st);
		model.addAttribute("ed",ed);
		return "/head/adminsList";
		
	}
	
	/**
	 * 打开管理员添加的页面
	 */
	@RequestMapping("/adminsInsert")
	public String adminsInsert(Model model)
	{
		ConstantFinalUtil.LOGGER.info("--adminsInsert--");
		/* 查询所有启用的角色 */
		Map<String, Object> condMap = new HashMap<String, Object>();
		/* 应该从枚举中取值
		 * 应该写一个角色的枚举
		 * AAdminsEnum.STATUS_ENABLE.getStatus() */
		condMap.put("status", "1");
		List<ARole> roleList = this.usersService.findCondListRoleService(null, condMap);
		/* 存储到四大作用域中 */
		model.addAttribute("roleList", roleList);
		return "/head/adminsInsert" ; 
	}
	
	@RequestMapping("/adminsInsertSubmit")
	public String adminsInsertSubmit(AAdmins admins,Model model)
	{
		
		ConstantFinalUtil.LOGGER.info("--adminsInsert--");
		/* 为在jsp上面木有赋值的属性后台赋值 */
		admins.setCreateTime(new Date());
		admins.setUpdateTime(new Date());
		JSONObject resultJSON = this.usersService.saveOneAdminsService(admins);
		String info = resultJSON.get("info") + "";
		/* 存储的结果给放到Request中 */
		model.addAttribute("info", info);
		/*return "/head/adminsInsert";*/
		/* 为了下拉框中显示查询角色的相关信息 */
		return this.adminsInsert(model);
		
	}
	
	/*---- 管理员操作模块结束 ----*/
}
