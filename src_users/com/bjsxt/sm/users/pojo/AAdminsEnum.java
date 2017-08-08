package com.bjsxt.sm.users.pojo;

/**
 * 枚举类
 * @author XuGuoQing07
 *
 */

public enum AAdminsEnum
{
	/* 声明 */
	/* 状态的声明 */
	STATUS_DISABLE(Byte.valueOf("0"),"禁用"),
	STATUS_ENABLE(Byte.valueOf("1"),"启用");
	
	/* 定义枚举的属性 */
	private byte status;
	private String info;
	/* 读写器 */
	public byte getStatus()
	{
		return status;
	}
	public void setStatus(byte status)
	{
		this.status = status;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	/* 构造函数 */
	private AAdminsEnum(byte status, String info)
	{
		this.status = status;
		this.info = info;
	}
	private AAdminsEnum()
	{
	}
	
	
	
}
