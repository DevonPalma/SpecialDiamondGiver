package com.cheat.diamondGiver;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class DiamondGiver extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Started Diamond Giver");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length <= 2) {
			sender.sendMessage("Must include a name and some lore");
			return true;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage("Must be a player to use this command");
			return true;
		}
		
		Player player = (Player) sender;
		
		String itemName = (args[0]).replace('&', '§');
		String itemLore = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).replace('&', '§');;
		
		ItemStack item = new ItemStack(Material.DIAMOND);
		item.setAmount(1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(itemName);
		itemMeta.setLore(Arrays.asList(itemLore));
		item.setItemMeta(itemMeta);
		
		player.getInventory().addItem(item);
		sender.sendMessage("Gave item!");
		return true;
	}
}
