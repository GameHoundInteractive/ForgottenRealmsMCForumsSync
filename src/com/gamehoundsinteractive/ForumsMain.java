package com.gamehoundsinteractive;

import org.bukkit.plugin.java.JavaPlugin;

import com.gamehoundsinteractive.ForumsSync.Functions.Forums_StoreSync;
import com.gamehoundsinteractive.ForumsSync.utils.SQLManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.PackageManager;

import net.md_5.bungee.api.ChatColor;

public class ForumsMain extends JavaPlugin
{
	public static ForumsMain instance; 
	public ConfigManager configMan;
	public LangManager langMan;
	public PackageManager packageMan;

	@Override
	public void onEnable() {
		instance = this;
		this.configMan = new ConfigManager(this, configMan);
		this.langMan = new LangManager(this, langMan);
		this.packageMan = new PackageManager(this, packageMan);
		new SQLManager(this, this.configMan);
		
		new Forums_StoreSync();

		this.getCommand("claim").setExecutor(new Forums_StoreSync());
		// this.getCommand("sync").setExecutor(new Forums_UserSync());
		// this.getCommand("listforumbans").setExecutor(new Forums_BansSync());

		// Startup Message
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " Welcome To Invision Powersoftware Sync");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " Need support? Join our discord!");
		System.out.println(ChatColor.GREEN + " " + ChatColor.GOLD + " ");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " #############################################");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " ## Website: https://gamehoundsinteractive.com");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " ## Discord: https://discord.gg/5s5BgeB");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " ## Made by GHStudios");
		System.out.println(ChatColor.GREEN + "[ForgottenRealmsMCForumsSync] " + ChatColor.BOLD + ChatColor.GOLD + " #############################################");
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

	public static ForumsMain getInstance() {
		return instance;
	}
}