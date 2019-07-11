package com.gamehoundsinteractive;

import org.bukkit.plugin.java.JavaPlugin;

import com.gamehoundsinteractive.ForumsSync.Forums_StoreSync;
import com.gamehoundsinteractive.ForumsSync.Forums_UserSync;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.Store_PackagesManager;

import net.md_5.bungee.api.ChatColor;

public class LicenseRedeem extends JavaPlugin
{
	private ConfigManager configMan;
	private LangManager langMan;
	private Store_PackagesManager packageMan;

	@Override
	public void onEnable() {
		this.configMan = new ConfigManager(this);
		this.langMan = new LangManager(this);
		this.packageMan = new Store_PackagesManager(this);
		new SQLManager(this, this.configMan);

		this.getCommand("claim").setExecutor(new Forums_StoreSync());
		this.getCommand("sync").setExecutor(new Forums_UserSync());

		// Startup Message

		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Welcome To Forums Sync");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Need support? Check our spigot page!");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Plugin is currently in beta!");
	}
}