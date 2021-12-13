package me.TurtlesAreHot.Freeze.events;

import me.TurtlesAreHot.Freeze.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMove implements Listener {
    @EventHandler
    public void onMovement(PlayerMoveEvent e) {
        if(Main.instance.isFrozenPlayer(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
