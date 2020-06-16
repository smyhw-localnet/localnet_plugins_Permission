package online.smyhw.localnet.plugins.Permission;

import java.util.List;

public class API 
{
	/**
	 * 指示对应终端是否具有指定权限
	 * @param Permission 需要检查的权限
	 * @param ID 需要检查的终端ID
	 * @return 有权限，返回true，否则返回false
	 */
	public boolean havePermission(String Permission,String ID)
	{
		List<String> pl = data.getUserPermission(ID);
		return pl.contains(Permission);
	}
	
	/**
	 * 获得指定终端的权限列表
	 * @param ID 终端ID
	 * @return 对应ID列表
	 */
	public List<String> getPermissionList(String ID)
	{
		List<String> pl = data.getUserPermission(ID);
		return data.getUserPermission(ID);
	}

}
