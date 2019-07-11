package com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.LicenseRedeem;



public class Store_PackagesManager
{
	public FileConfiguration store_packages;

	public Store_PackagesManager(final LicenseRedeem pl) {
		pl.getLogger().log(Level.INFO, "Loading configuration...");
		if (!new File(pl.getDataFolder(), "store_packages.yml").exists()) {
			pl.saveDefaultConfig();
		}
		this.store_packages = pl.getConfig();
	}
}