package com.gamehoundsinteractive;

import org.bukkit.plugin.java.JavaPlugin;

import com.gamehoundsinteractive.ForumsSync.functions.Forums_StoreSync;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.PackageManager;

import net.md_5.bungee.api.ChatColor;

public class LicenseRedeem extends JavaPlugin
{
	private static LicenseRedeem instance;
	private ConfigManager configMan;
	private LangManager langMan;
	private PackageManager packageMan;

	@Override
	public void onEnable() {
		instance = this;
		this.configMan = new ConfigManager(this, configMan);
		this.langMan = new LangManager(this, langMan);
		this.packageMan = new PackageManager(this, packageMan);
		new SQLManager(this, this.configMan);

		this.getCommand("claim").setExecutor(new Forums_StoreSync());
		// this.getCommand("sync").setExecutor(new Forums_UserSync());
		// this.getCommand("listforumbans").setExecutor(new Forums_BansSync());

		// Startup Message

		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Welcome To Forums Sync");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Need support? Check our spigot page!");
		System.out.print(ChatColor.WHITE + "[ForgottenRealmsMCForumsSync]" + ChatColor.GOLD + "Plugin is currently in beta!");
	}

	public ConfigManager getConfigMan() {
		return configMan;
	}

	public LangManager getLangMan() {
		return langMan;
	}

	public PackageManager getPackageMan() {
		return packageMan;
	}

	public static LicenseRedeem getInstance() {
		return instance;
	}
}