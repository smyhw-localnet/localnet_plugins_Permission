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
	}
	
	public static void cmd(Client_sl User,String cmd)
	{

	}
}
