package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.ForumsMain;



public class PackageManager
{
	public FileConfiguration store_packages;

	public PackageManager(final ForumsMain pm, final PackageManager packageMan) {
		pm.getLogger().log(Level.INFO, "Loading store_packages.yml");
		if (!new File(pm.getDataFolder(), "store_packages.yml").exists()) {
			pm.saveResource("store_packages.yml", false);
		}
		this.store_packages = pm.getConfig();
	}
}