package com.gamehoundsinteractive.ForumsSync;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.SQLManager;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.ConfigManagers.Store_PackagesManager;

public class Forums_UserSync implements CommandExecutor{

	@SuppressWarnings("unused")
	private LicenseRedeem pl;
	private ConfigManager configman;
	private LangManager langman;
	@SuppressWarnings("unused")
	private Store_PackagesManager packageman;
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
