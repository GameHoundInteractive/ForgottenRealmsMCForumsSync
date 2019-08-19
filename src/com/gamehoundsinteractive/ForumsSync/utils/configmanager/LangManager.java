package com.gamehoundsinteractive.ForumsSync.utils.configmanager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gamehoundsinteractive.ForumsMain;



public class LangManager
{
	public ForumsMain pl;
	private File LangConfigFile;
    private FileConfiguration LangConfig;
    public FileConfiguration LangMan;
    
	public LangManager() {
		this.pl = ForumsMain.getInstance();
	}    
	
    public void onEnable2(){
        createLangConfig();
    }

//	public LangManager(ForumsMain lm, LangManager langMan) {
//		lm.getLogger().log(Level.INFO, "Loading lang.yml");
//		if (!new File(lm.getDataFolder(), "lang.yml").exists()) {
//			lm.saveResource("lang.yml", false);
//		}
//		this.lang = lm.getConfig();
//	}
	
	public FileConfiguration getLangConfig() {
        return this.LangConfig;
    }
	
    private void createLangConfig() {
	        LangConfigFile = new File(pl.getDataFolder(), "lang.yml");
	        if (!LangConfigFile.exists()) {
	            LangConfigFile.getParentFile().mkdirs();
	            pl.saveResource("lang.yml", false);
	         }

	        LangConfig= new YamlConfiguration();
	        try {
	            LangConfig.load(LangConfigFile);
	        } catch (IOException | InvalidConfigurationException e) {
	            e.printStackTrace();
	        }
	    }
	}

