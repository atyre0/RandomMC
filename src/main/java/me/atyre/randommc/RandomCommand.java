package me.atyre.randommc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class RandomCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                String[] usageMsg = {
                        "§9§m-----------------------------------------------------",
                        "§bRandom MC v1.0 by atyre / Tyler",
                        " ",
                        "§bUse §9/random reload §bto reload the configuration after making changes.",
                        "§9§m-----------------------------------------------------"
                };

                player.sendMessage(usageMsg);
            }

            if (player.hasPermission("random.command.reload")) {
                if (args.length == 1) {
                    if (args[0].equals("reload")) {
                        Plugin plugin = RandomMC.getPlugin(RandomMC.class);
                        plugin.reloadConfig();
                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + "RandomMC" + ChatColor.BLUE + "] " + ChatColor.AQUA + "The configuration has been successfully reloaded.");
                    }
                }
            }

        } else {
            String[] usageMsg = {
                    "§9§m-----------------------------------------------------",
                    "§bRandom MC v1.0 by atyre",
                    " ",
                    "§bUse §9/random reload §b§nin game §bto reload the configuration after making changes.",
                    "§9§m-----------------------------------------------------"
            };

            sender.sendMessage(usageMsg);
        }

        return false;
    }
}
