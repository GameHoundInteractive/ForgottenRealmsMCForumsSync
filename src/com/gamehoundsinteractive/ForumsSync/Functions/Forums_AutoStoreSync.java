package com.gamehoundsinteractive.ForumsSync.functions;

import java.util.logging.Level;

import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;

public class Forums_AutoStoreSync {

	private final LicenseRedeem pl;
	private final ConfigManager configman;

	public Forums_AutoStoreSync() {
		this.pl = LicenseRedeem.getInstance();
		this.configman = pl.getConfigMan();

		if (this.configman.config.getBoolean("settings.debug") != true) {
			pl.getLogger().log(Level.INFO, "Forums_AutoSync class loaded!");
		}
	}
}
