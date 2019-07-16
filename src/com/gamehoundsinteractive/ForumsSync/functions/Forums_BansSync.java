package com.gamehoundsinteractive.ForumsSync.functions;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
public class Forums_BansSync implements CommandExecutor {

	private final LicenseRedeem pl;
	private final ConfigManager configman;
	private final LangManager langman;

	public Forums_BansSync() {
		this.pl = LicenseRedeem.getInstance();
		this.configman = pl.getConfigMan();
		this.langman = pl.getLangMan();

		if (this.configman.config.getBoolean("settings.debug") != true) {
			pl.getLogger().log(Level.INFO, "Forums_BansSync class loaded!");
		}
	}

	@Override

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("forumsban") || !(sender instanceof Player)) {
			sender.sendMessage(this.langman.lang.getString("OnlyPlayer"));
		}
		if (!(sender.hasPermission(this.configman.config.getString("Permission")))) {
			sender.sendMessage(this.langman.lang.getString("NoPermission"));
		}
		if (null != null) {
			// Function here!
		}
		return false;
	}


}
