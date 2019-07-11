package com.gamehoundsinteractive.ForumsSync.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.SQLManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.ConfigManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.LangManager;
import com.gamehoundsinteractive.ForumsSync.utils.configmanager.PackageManager;

public class Forums_StoreSync implements CommandExecutor {

	private LicenseRedeem pl;
	private ConfigManager configman;
	private LangManager langman;
	private PackageManager packageman;
	private SQLManager sqlMan;

	@Override
	public final boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("claim") || !(sender instanceof Player)) {
			sender.sendMessage(this.langman.lang.getString("lang.OnlyPlayer"));
			if (!(sender.hasPermission(this.configman.config.getString("settings.permission")))) {
				sender.sendMessage(this.langman.lang.getString("lang.NoPermission"));
				if (args.length == 0) {
					sender.sendMessage(this.langman.lang.getString("lang.Help"));
					return true;
				}
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(this.langman.lang.getString("lang.Help"));
					return true;
				}
				try {
					final ResultSet result = this.sqlMan.runSQL("SELECT lkey_active, lkey_purchase FROM nexus_licensekeys WHERE lkey_key='" + args[0] + "'", false);
					int count = 0;
					while (result.next()) {
						if (result.isAfterLast()) {
							result.previous();
							break;
						}
						++count;
					}
					if (count == 0) {
						sender.sendMessage(this.langman.lang.getString("lang.NotValid"));
						return true;
					}
					if (result.isAfterLast()) {
						result.previous();
					}
					if (result.getInt(1) != 1) {
						sender.sendMessage(this.langman.lang.getString("lang.UsedKey"));
						return true;
					}
					final ResultSet result2 = this.sqlMan.runSQL("SELECT * FROM nexus_purchases WHERE ps_id='" + result.getInt(2) + "'", false);
					while (result.next()) {
						if (result.isAfterLast()) {
							result.previous();
							break;
						}
					}
					result2.last();
					for (final String command : this.packageman.store_packages.getStringList("packages." + result2.getString(3))) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", sender.getName()));
					}
					this.sqlMan.runSQL("UPDATE nexus_licensekeys SET lkey_active=0, lkey_uses=1 WHERE lkey_key='" + args[0] + "'", true);
					sender.sendMessage(this.langman.lang.getString("lang.SuccessRedeem"));
				}
				catch (final SQLException e) {
					this.pl.getLogger().log(Level.SEVERE, "MySQL error.");
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}
		return false;
	}
}