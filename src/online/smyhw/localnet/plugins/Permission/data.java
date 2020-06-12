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
	
	public static List getGroupPermission(String GroupName)
	{
		ArrayList<String> re = new ArrayList();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(Groups));
			while(true)
			{
				String temp1 = reader.readLine();
				if(temp1==null) {break;}
				if(temp1.equals(GroupName+":"))
				{//读取到正确的组
					while(true)
					{//读取组权限内容
						String temp2 = reader.readLine();
						if(temp2==null || !temp2.startsWith("-")){break;}
						re.add(temp2.substring(1));//分离开头的"-"
					}
					break;
					//这里直接返回
				}
			}
			
		}
		catch (Exception e) 
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
