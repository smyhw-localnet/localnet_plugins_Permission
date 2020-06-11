package online.smyhw.localnet.plugins.Permission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import online.smyhw.localnet.message;
import online.smyhw.localnet.data.DataManager;
import online.smyhw.localnet.data.config;

public class data 
{
	public static File Groups;
	public static File Users;
	public static List getFinalPermission(String User)
	{
		return new ArrayList();
	}
	
	public static List getGroupPermission(String GroupNamel)
	{
		ArrayList re = new ArrayList();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(Groups));
		}
		catch (FileNotFoundException e) 
		{
			message.warning("读取权限文件出错", e);
		}
		return re;
	}
	
	public static List getUserPermission(String UserName)
	{
		ArrayList re = new ArrayList();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(Users));
		}
		catch (FileNotFoundException e) 
		{
			message.warning("读取权限文件出错", e);
		}
		return re;
	}
}
