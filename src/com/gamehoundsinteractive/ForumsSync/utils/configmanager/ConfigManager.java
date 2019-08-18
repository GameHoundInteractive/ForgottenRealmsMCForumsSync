package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.ForumsMain;



public class ConfigManager
{
	public FileConfiguration config;

	public ConfigManager(ForumsMain cm, ConfigManager configMan) {
		cm.getLogger().log(Level.INFO, "Loading Config.yml");
		if (!new File(cm.getDataFolder(), "config.yml").exists()) {
			cm.saveDefaultConfig();
		}
		this.config = cm.getConfig();
	}
}