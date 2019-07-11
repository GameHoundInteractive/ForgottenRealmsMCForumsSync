package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.LicenseRedeem;



public class ConfigManager
{
	public FileConfiguration config;

	public ConfigManager(final LicenseRedeem pl) {
		pl.getLogger().log(Level.INFO, "Loading configuration...");
		if (!new File(pl.getDataFolder(), "config.yml").exists()) {
			pl.saveDefaultConfig();
		}
		this.config = pl.getConfig();
	}
}