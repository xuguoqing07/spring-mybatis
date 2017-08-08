package com.bjsxt.sm.users.pojo;

import java.util.Date;

import org.junit.Test;

/**
 * 管理员 pojo
 * @author XuGuoQing07
 *
 */
public class AAdmins
{
	private int id;
	private int roleId;
	private String email;
	private String password;
	private byte status;
	private Date createTime;
	private Date updateTime;
	
	/* 关联对象 */
	private ARole role;
	
	/* 字符串的显示 */
	/* 状态的字符串描述 */
	private String statusStr; 
	
	public ARole getRole()
	{
		return role;
	}
	public void setRole(ARole role)
	{
		this.role = role;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getRoleId()
	{
		return roleId;
	}
	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public byte getStatus()
	{
		return status;
	}
	public void setStatus(byte status)
	{
		this.status = status;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public Date getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}
	
	public String getStatusStr()
	{
		
		AAdminsEnum[] values = AAdminsEnum.values();
		for (int i = 0; i < values.length; i++)
		{
			AAdminsEnum aAdminsEnum = values[i];
			/*System.out.println(aAdminsEnum.getStatus() + "---" + aAdminsEnum.getInfo()
			+ "-----" + aAdminsEnum);*/
			/* 将来会有值一样,含义不一样的枚举
			 * 要加上区分枚举项的判断
			 *  */
			if(aAdminsEnum.getStatus() == this.status
					&& aAdminsEnum.toString().startsWith("STATUS_"))
			{
				this.statusStr = aAdminsEnum.getInfo();
			}
		}
		return statusStr;
	}
	
	
}
