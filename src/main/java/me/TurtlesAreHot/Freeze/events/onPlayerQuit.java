package me.TurtlesAreHot.Freeze.events;

import me.TurtlesAreHot.Freeze.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerQuit implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(Main.instance.isFrozenPlayer(e.getPlayer())) {
            Main.instance.removeFrozenPlayer(e.getPlayer());
        }
    }
}
