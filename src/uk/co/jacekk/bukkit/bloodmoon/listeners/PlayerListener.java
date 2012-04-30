package uk.co.jacekk.bukkit.bloodmoon.listeners;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import uk.co.jacekk.bukkit.bloodmoon.BloodMoon;

public class PlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		World toWorld = player.getWorld();
		
		if (BloodMoon.bloodMoonWorlds.contains(toWorld.getName())){
			player.sendMessage(ChatColor.RED + BloodMoon.config.getMessage());
		}
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerChangedWorld(PlayerChangedWorldEvent event){
		Player player = event.getPlayer();
		
		if (BloodMoon.bloodMoonWorlds.contains(player.getWorld().getName())){
			player.sendMessage(ChatColor.RED + BloodMoon.config.getMessage());
		}
	}

}