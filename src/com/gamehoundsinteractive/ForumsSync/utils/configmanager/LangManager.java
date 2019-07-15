package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.LicenseRedeem;



public class LangManager
{
	public FileConfiguration lang;

	public LangManager(LicenseRedeem pl, LangManager langMan) {
		pl.getLogger().log(Level.INFO, "Loading configuration...");
		if (!new File(pl.getDataFolder(), "lang.yml").exists()) {
			pl.saveResource("lang.yml", false);
		}
		this.lang = pl.getConfig();
	}
}