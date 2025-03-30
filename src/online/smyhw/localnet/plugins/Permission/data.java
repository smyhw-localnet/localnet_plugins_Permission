package online.smyhw.localnet.plugins.Permission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import online.smyhw.localnet.message;

public class data 
{
	public static File Groups;
	public static File Users;
	
	/**
	 * 获取指定权限组的最终权限列表
	 * @param GroupName
	 * @return
	 */
	public static List getGroupPermission(String GroupName)
	{
		return ReadPermission(Groups,GroupName);
	}
	
	/**
	 * 获取指定终端的最终权限列表
	 * @param UserName
	 * @return
	 */
	public static List<String> getUserPermission(String UserName)
	{
		return ReadPermission(Users,UserName);
	}
	
	//负责从文件中读取对应的权限列表
	//该方法返回最终权限列表，因为返回时已经调用getPermissionList方法解释了特殊权限节点
	public static List<String> ReadPermission(File file,String GroupName)
	{
		List<String> re = new ArrayList<String>();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while(true)
			{
				String temp1 = reader.readLine();
				if(temp1==null) {break;}
				temp1 = temp1.trim();
				//排除注释
				if(temp1.startsWith("//")) {continue;}
				if(temp1.startsWith("#")) {continue;}
				if(temp1.replace(" ","").equals(GroupName+":"))
				{//读取到正确的组
					while(true)
					{//读取组权限内容
						String temp2 = reader.readLine();
						if(temp2==null){break;}
						temp2 = temp2.trim();
						//排除注释
						if(temp2.startsWith("//")) {continue;}
						if(temp2.startsWith("#")) {continue;}
						//跳过空行
						if(temp2.isEmpty()) {continue;}
						if(!temp2.startsWith("-")){break;}
						re.add(temp2.substring(1).trim());
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
		finally {
			try {
				if (file != null) {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					reader.close();
				}
			} catch (Exception e) {
				message.warning("关闭权限文件出错", e);
			}
		}
		return re;
	}
	
	//负责解析权限列表中的特殊节点
	//该方法应在ReadPermission方法的最后被调用来解释特殊权限节点
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
					List<String> temp4 = ReadPermission(Groups,temp2[1]);
					re.addAll(temp4);
					continue;
				case "player"://继承其他玩家的全部权限
					temp4 = ReadPermission(Users,temp2[1]);
					re.addAll(temp4);
					continue;
				default://未知则不处理
					continue;
				}
			}
			//如果到这还没有continue，则表示这是个正常的权限节点文本
			//将一般的权限节点文本加入最终列表
			re.add(temp1);
		}
		//如果为空，返回default
		if (re.isEmpty()){
			re.addAll(ReadPermission(Users,"_dafault"));
		}
		//遍历完每一行后，返回
		return re;
	}
}
