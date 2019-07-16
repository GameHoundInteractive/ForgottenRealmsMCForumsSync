package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.LicenseRedeem;



public class PackageManager
{
	public FileConfiguration store_packages;

	public PackageManager(final LicenseRedeem pl, final PackageManager packageMan) {
		pl.getLogger().log(Level.INFO, "Loading store_packages.yml");
		if (!new File(pl.getDataFolder(), "store_packages.yml").exists()) {
			pl.saveResource("store_packages.yml", false);
		}
		this.store_packages = pl.getConfig();
	}
}