package com.gamehoundsinteractive.ForumsSync.Functions;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.ForumsMain;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;

public class Forums_UserSync implements CommandExecutor{

	private final ForumsMain pl;
	private final ConfigManager configman;
	private final LangManager langman;

	public Forums_UserSync() {
		this.pl = ForumsMain.getInstance();
		this.configman = pl.getConfigMan();
		this.langman = pl.getLangMan();

		if (this.configman.config.getBoolean("settings.debug") != true) {
			pl.getLogger().log(Level.INFO, "Forums_UserSync class loaded!");
		}
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("sync") || !(sender instanceof Player)) {
			sender.sendMessage(this.langman.langMan.getString("OnlyPlayer"));
		}
		if (!sender.hasPermission(this.configman.config.getString("Permission"))) {
			sender.sendMessage(this.langman.langMan.getString("NoPermission"));
		}
		if (null != null) {
			// Function here!
		}
		return false;
	}

}
