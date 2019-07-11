package com.gamehoundsinteractive;

import org.bukkit.plugin.java.JavaPlugin;

import com.gamehoundsinteractive.ForumsSync.functions.Forums_BansSync;
import com.gamehoundsinteractive.ForumsSync.functions.Forums_StoreSync;
import com.gamehoundsinteractive.ForumsSync.functions.Forums_UserSync;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.PackageManager;

import net.md_5.bungee.api.ChatColor;

public class LicenseRedeem extends JavaPlugin
{
	private ConfigManager configMan;
	private LangManager langMan;
	private PackageManager packageMan;

	@Override
	public void onEnable() {
		this.configMan = new ConfigManager(this);
		this.langMan = new LangManager(this, langMan);
		this.packageMan = new PackageManager(this, packageMan);
		new SQLManager(this, this.configMan);

		this.getCommand("claim").setExecutor(new Forums_StoreSync());
		this.getCommand("sync").setExecutor(new Forums_UserSync());
		this.getCommand("listforumbans").setExecutor(new Forums_BansSync());

		// Startup Message

		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Welcome To Forums Sync");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Need support? Check our spigot page!");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Plugin is currently in beta!");
	}
}