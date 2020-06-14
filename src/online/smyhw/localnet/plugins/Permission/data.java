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
		return ReadPermission(Groups,GroupName);
	}
	
	public static List<String> getUserPermission(String UserName)
	{
		return ReadPermission(Users,UserName);
	}
	
	//负责从文件中读取对应的权限列表
	public static List<String> ReadPermission(File file,String GroupName)
	{
		List<String> re = new ArrayList<String>();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(Groups));
			while(true)
			{
				String temp1 = reader.readLine();
				if(temp1==null) {break;}
				//排除注释
				if(temp1.startsWith("//")) {continue;}
				if(temp1.startsWith("#")) {continue;}
				if(temp1.equals(GroupName+":"))
				{//读取到正确的组
					while(true)
					{//读取组权限内容
						String temp2 = reader.readLine();
						if(temp2==null || !temp2.startsWith("-")){break;}
						re.add(temp2.substring(1));
					}
					break;
					//这里直接返回
				}
			}
			return getPermissionList(re);//解释
		}
		catch (Exception e) 
		{
			message.warning("读取权限文件出错", e);
		}
		return re;
	}
	
	//负责解析权限列表中的特殊节点
	public static List<String> getPermissionList(List<String> PermissionString)
	{
		List<String> re = new ArrayList<String>();
		for(String temp1 : PermissionString)
		{
			if(temp1.contains(":"))
			{//解释特殊语句
				String[] temp2 = temp1.split(":");
				switch(temp2[0])
				{
				case "group"://继承其他权限组的全部权限
				{
					
				}
				continue;
				case "player"://继承其他玩家的全部权限
				{
					
				}
				continue;
				default://未知则不处理
					continue;
				}
			}
			//如果到这还没有continue，则表示这是个正常的权限节点文本
			re.add(temp1);
		}
		//遍历完每一行后，返回
		return re;
	}
}
