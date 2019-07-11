package com.gamehoundsinteractive.ForumsSync;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gamehoundsinteractive.ConfigManager;
import com.gamehoundsinteractive.LicenseRedeem;
import com.gamehoundsinteractive.SQLManager;

public class Forums_StoreSync extends LicenseRedeem {

	private ConfigManager configMan;
	private SQLManager sqlMan;

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player || (sender.hasPermission(this.configMan.config.getString("Permission"))))) {
			sender.sendMessage(this.configMan.lang.getString("lang.OnlyPlayer"));
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage(this.configMan.lang.getString("lang.Help"));
			return true;
		}
		if (args[0].equalsIgnoreCase("help")) {
			sender.sendMessage(this.configMan.lang.getString("lang.Help"));
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
				sender.sendMessage(this.configMan.lang.getString("lang.NotValid"));
				return true;
			}
			if (result.isAfterLast()) {
				result.previous();
			}
			if (result.getInt(1) != 1) {
				sender.sendMessage(this.configMan.lang.getString("lang.UsedKey"));
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
			for (final String command : this.configMan.store_packages.getStringList("packages." + result2.getString(3))) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", sender.getName()));
			}
			this.sqlMan.runSQL("UPDATE nexus_licensekeys SET lkey_active=0, lkey_uses=1 WHERE lkey_key='" + args[0] + "'", true);
			sender.sendMessage(this.configMan.lang.getString("lang.SuccessRedeem"));
		}
		catch (final SQLException e) {
			this.getLogger().log(Level.SEVERE, "MySQL error.");
			e.printStackTrace();
			this.getServer().getPluginManager().disablePlugin(this);
		}

		if (args.length == 1) {
			sender.sendMessage(this.configMan.lang.getString("lang.NoPermission"));
			return true;
		}

		return true;
	}

}
