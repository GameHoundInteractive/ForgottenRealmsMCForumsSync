package com.gamehoundsinteractive.ForumsSync.functions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.SQLManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.PackageManager;

public class Forums_UserSync implements CommandExecutor{

	@SuppressWarnings("unused")
	private LicenseRedeem pl;
	private ConfigManager configman;
	private LangManager langman;
	@SuppressWarnings("unused")
	private PackageManager packageman;
	@SuppressWarnings("unused")
	private SQLManager sqlMan;

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("sync") || !(sender instanceof Player)) {
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
