package me.TurtlesAreHot.Freeze;

import me.TurtlesAreHot.Freeze.commands.Freeze;
import me.TurtlesAreHot.Freeze.events.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public static Main instance;
    public List<Player> frozenPlayers;

    @Override
    public void onEnable() {
        this.instance = this;
        frozenPlayers = new ArrayList<>();
        getCommand("freeze").setExecutor(new Freeze());
        if(this.getServer().getPluginManager().getPlugin("ProjectKorra") != null) {
            this.getServer().getPluginManager().registerEvents(new onBend(), this);
        }
        this.getServer().getPluginManager().registerEvents(new onMove(), this);
        this.getServer().getPluginManager().registerEvents(new onPlayerQuit(), this);
    }

    @Override
    public void onDisable() {

    }

    public void removeFrozenPlayer(Player p) {
        for(Player frozen : frozenPlayers) {
            if(frozen.getUniqueId().equals(p.getUniqueId())) {
                frozenPlayers.remove(frozen);
                break;
            }
        }
    }

    public void addFrozenPlayer(Player p) {
        frozenPlayers.add(p);
    }

    public boolean isFrozenPlayer(Player p) {
        return frozenPlayers.contains(p);
    }
}
