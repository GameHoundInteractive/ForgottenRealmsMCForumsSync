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
public class Forums_BansSync implements CommandExecutor {

	private final LicenseRedeem pl;
	private final ConfigManager configman;
	private final LangManager langman;
	@SuppressWarnings("unused")
	private final PackageManager packageman;
	@SuppressWarnings("unused")
	private SQLManager sqlMan;

	public Forums_BansSync() {
		this.pl = LicenseRedeem.getInstance();
		this.configman = pl.getConfigMan();
		this.langman = pl.getLangMan();
		this.packageman = pl.getPackageMan();
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
