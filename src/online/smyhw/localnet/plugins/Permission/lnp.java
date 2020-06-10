package online.smyhw.localnet.plugins.Permission;

import online.smyhw.localnet.message;
import online.smyhw.localnet.command.cmdManager;
import online.smyhw.localnet.data.DataManager;
import online.smyhw.localnet.data.config;
import online.smyhw.localnet.event.ChatINFO_Event;
import online.smyhw.localnet.event.EventManager;
import online.smyhw.localnet.lib.CommandFJ;
import online.smyhw.localnet.network.Client_sl;

public class lnp 
{
	public static void plugin_loaded()
	{
		message.info("Permission插件加载");
		try 
		{
			cmdManager.add_cmd("pm", lnp.class.getMethod("cmd", new Class[]{Client_sl.class,String.class}));
			EventManager.AddListener("ChatINFO", lnp.class.getMethod("lr", new Class[] {ChatINFO_Event.class}));
		} 
		catch (Exception e) 
		{
			message.warning("Permission插件加载错误!",e);
		}
		data.Groups = DataManager.LoadConfig("./configs/permission/groups.config");
		data.Users = DataManager.LoadConfig("./configs/permission/users.config");
	}
	
	public static void cmd(Client_sl User,String cmd)
	{

	}
	
	public static void lr(ChatINFO_Event dd)
	{

	}
}
