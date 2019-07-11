package com.gamehoundsinteractive;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class ConfigManager
{
	public FileConfiguration config;
	public FileConfiguration lang;
	public FileConfiguration store_packages;

	@SuppressWarnings("unused")
	public ConfigManager(final LicenseRedeem pl) {

		final File config = new File("plugins/ForgottenRealmsMCForumsSync", "config.yml");
		final File lang = new File("plugins/ForgottenRealmsMCForumsSync/lang", "lang.yml");
		final File store_packages = new File("plugins/ForgottenRealmsMCForumsSync/options", "store_packages.yml");
		final FileConfiguration cfgconfig = YamlConfiguration.loadConfiguration(config);
		final FileConfiguration cfglang = YamlConfiguration.loadConfiguration(lang);
		final FileConfiguration cfgstore_packages = YamlConfiguration.loadConfiguration(store_packages);

		// set Config options
		cfgconfig.set("this.is.the.file.structure", "this_is_the_string");

		//set Lang options
		cfglang.set("this.is.the.file.structure", "this_is_the_string");

		//set Packages Options
		cfgstore_packages.set("this.is.the.file.structure", "this_is_the_string");
		try {
			cfglang.save(config);
		} catch (final IOException a) {
			System.out.println(ChatColor.RED + "Error, Config file: Config could not save!");
			a.printStackTrace();
		}

		try {
			cfglang.save(lang);
		} catch (final IOException b) {
			System.out.println(ChatColor.RED + "Error, Language file: Config could not save!");
			b.printStackTrace();
		}

		try {
			cfgstore_packages.save(store_packages);
		} catch (final IOException c) {
			System.out.println(ChatColor.RED + "Error, Packages file: Config could not save!");
			c.printStackTrace();
		}



		// *pl.getLogger().log(Level.INFO, "Loading configuration...");
		// *if (!new File(pl.getDataFolder(), "config.yml").exists()) {
		// *	pl.saveDefaultConfig();
		// *}
		// *if (!new File(pl.getDataFolder(), "lang.yml").exists()) {
		// *	pl.saveDefaultConfig();
		// *}
		// *if (!new File(pl.getDataFolder(), "store_packages.yml").exists()) {
		// *	pl.saveDefaultConfig();
		// *}
		// *this.config = pl.getConfig();
		// *this.lang = pl.getConfig();
		// *this.store_packages = pl.getConfig();
	}
}