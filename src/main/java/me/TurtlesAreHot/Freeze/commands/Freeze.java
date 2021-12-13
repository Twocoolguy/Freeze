package me.TurtlesAreHot.Freeze.commands;

import me.TurtlesAreHot.Freeze.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            if(args.length != 1) {
                Bukkit.getLogger().info(ChatColor.RED + "[Freeze] Please provide a player by giving " +
                        "their username.");
                Bukkit.getLogger().info(ChatColor.RED + "[Freeze] Proper usage: /freeze <player>");
                return false;
            }
            Player freezePlayer = Bukkit.getPlayer(args[0]);
            if(freezePlayer == null) {
                Bukkit.getLogger().info(ChatColor.RED + "[Freeze] The player you tried to freeze does " +
                        "not exist/isn't online. " +
                        "Please try again.");
                return false;
            }
            if(Main.instance.isFrozenPlayer(freezePlayer)) {
                Main.instance.removeFrozenPlayer(freezePlayer);
                Bukkit.getLogger().info(ChatColor.GREEN + "[Freeze] You have successfully unfrozen "
                        + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + "!");
            } else {
                Main.instance.addFrozenPlayer(freezePlayer);
                Bukkit.getLogger().info(ChatColor.GREEN + "[Freeze] You have successfully frozen "
                        + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + "!");
            }
            return false;
        } else if(sender instanceof Player) {
            Player p = (Player) sender;
            if(!(p.hasPermission("freeze.player"))) {
                p.sendMessage(ChatColor.RED + "You do not have the permissions to run this command.");
                return false;
            }
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "Please provide a player by giving their username.");
                p.sendMessage(ChatColor.RED + "Proper usage: /freeze <player>");
                return false;
            }
            Player freezePlayer = Bukkit.getPlayer(args[0]);
            if(freezePlayer == null) {
                p.sendMessage(ChatColor.RED + "The player you tried to freeze does not exist/isn't online. " +
                        "Please try again.");
                return false;
            }
            if(Main.instance.isFrozenPlayer(freezePlayer)) {
                Main.instance.removeFrozenPlayer(freezePlayer);
                p.sendMessage(ChatColor.GREEN + "You have successfully unfrozen "
                        + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + "!");
            } else {
                Main.instance.addFrozenPlayer(freezePlayer);
                p.sendMessage(ChatColor.GREEN + "You have successfully frozen "
                        + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + "!");
            }
        }
        return false;
    }
}
