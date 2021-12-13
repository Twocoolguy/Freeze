package me.TurtlesAreHot.Freeze.events;

import com.projectkorra.projectkorra.event.AbilityStartEvent;
import me.TurtlesAreHot.Freeze.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onBend implements Listener {

    @EventHandler
    public void onBending(AbilityStartEvent e) {
        if(Main.instance.isFrozenPlayer(e.getAbility().getPlayer())) {
            e.setCancelled(true);
        }
    }
}
