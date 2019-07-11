package com.gamehoundsinteractive;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class LicenseRedeem extends JavaPlugin
{
	private ConfigManager configMan;

	@Override
	public void onEnable() {
		this.configMan = new ConfigManager(this);
		new SQLManager(this, this.configMan);

		// Welcome Message

		System.out.println(ChatColor.GOLD + "");


	}
}
