package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;

import com.gamehoundsinteractive.ForumsMain;



public class LangManager
{
	public FileConfiguration langMan;

	public LangManager(ForumsMain lm, LangManager langMan) {
		lm.getLogger().log(Level.INFO, "Loading lang.yml");
		if (!new File(lm.getDataFolder(), "lang.yml").exists()) {
			lm.saveResource("lang.yml", false);
		}
		this.langMan = lm.getConfig();
	}
}