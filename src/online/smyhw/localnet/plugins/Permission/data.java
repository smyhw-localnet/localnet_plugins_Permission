package online.smyhw.localnet.plugins.Permission;

import java.util.ArrayList;
import java.util.List;

import online.smyhw.localnet.data.DataManager;
import online.smyhw.localnet.data.config;

public class data 
{
	public static config Groups = new config();
	public static config Users = new config();
	public static List getFinalPermission(String User)
	{
		return new ArrayList();
	}
	
	public static List getGroupPermission(String GroupNamel)
	{
		return new ArrayList();
	}
	
	public static List getUserPermission(String UserName)
	{
		return new ArrayList();
	}
}
