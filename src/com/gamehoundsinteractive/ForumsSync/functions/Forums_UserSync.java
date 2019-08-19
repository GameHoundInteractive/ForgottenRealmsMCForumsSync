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
	private final LangManager langMan;

	public Forums_UserSync() {
		this.pl = ForumsMain.getInstance();
		this.configman = pl.getConfigMan();
		this.langMan = pl.getLangMan();

		if (this.configman.config.getBoolean("settings.debug") != true) {
			pl.getLogger().log(Level.INFO, "Forums_UserSync class loaded!");
		}
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("sync") || !(sender instanceof Player)) {
			sender.sendMessage(langMan.getLangConfig().getString("OnlyPlayer"));
		}
		if (!sender.hasPermission(this.configman.config.getString("Permission"))) {
			sender.sendMessage(langMan.getLangConfig().getString("NoPermission"));
		}
		if (null != null) {
			// Function here!
		}
		return false;
	}

}
