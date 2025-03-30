package online.smyhw.localnet.plugins.Permission;

import java.io.File;

import online.smyhw.localnet.message;
import online.smyhw.localnet.command.cmdManager;
import online.smyhw.localnet.network.Client_sl;

public class lnp 
{
	public static void plugin_loaded()
	{
		message.info("Permission插件加载");
		try 
		{
			cmdManager.add_cmd("pm", lnp.class.getMethod("cmd", new Class[]{Client_sl.class,String.class}));
		} 
		catch (Exception e) 
		{
			message.warning("Permission插件加载错误!",e);
		}
		data.Groups = new File("./configs/permission/groups.config");
		data.Users = new File("./configs/permission/users.config");
		if(!data.Users.exists()){
			try {
				message.info("Permission-用户配置文件不存在，创建之...");
				data.Users.getParentFile().mkdirs();
				data.Users.createNewFile();
			} catch (Exception e) {
				message.warning("Permission插件创建用户配置文件失败!",e);
			}
		}
		if(!data.Groups.exists()){
			try {
				message.info("Permission-用户组配置文件不存在，创建之...");
				data.Users.getParentFile().mkdirs();
				data.Groups.createNewFile();
			} catch (Exception e) {
				message.warning("Permission插件创建用户组配置文件失败!",e);
			}
		}
	}
	
	public static void cmd(Client_sl User,String cmd)
	{

	}
}
