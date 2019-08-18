package com.gamehoundsinteractive.ForumsSync.Functions;

import java.util.logging.Level;

import com.gamehoundsinteractive.ForumsMain;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;

public class Forums_AutoStoreSync {

	private final ForumsMain pl;
	private final ConfigManager configman;

	public Forums_AutoStoreSync() {
		this.pl = ForumsMain.getInstance();
		this.configman = pl.getConfigMan();

		if (this.configman.config.getBoolean("settings.debug") != true) {
			pl.getLogger().log(Level.INFO, "Forums_AutoSync class loaded!");
		}
	}
}
