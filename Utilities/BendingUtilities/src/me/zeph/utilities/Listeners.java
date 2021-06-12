package me.zeph.utilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;
import com.projectkorra.projectkorra.ability.util.MultiAbilityManager;
import com.projectkorra.projectkorra.event.HorizontalVelocityChangeEvent;
import com.projectkorra.projectkorra.util.ActionBar;

import net.md_5.bungee.api.ChatColor;


public class Listeners extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(this, this);

	}

	@Override
	public void onDisable() {

	}
	
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
   
    	Entity player = event.getEntity();

    	if (event.isCancelled()) {
            return;

    	}
    	
    	else {
    		if (event.getCause().equals(DamageCause.SUFFOCATION)) {
    			if (player.getLocation().add(0,1,0).getBlock().getType() == Material.ICE) {
    				player.getLocation().add(0,1,0).getBlock().setType(Material.AIR);
    				event.setCancelled(true);
    				
    			}
    		}
    }
}
    

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
    	Player player = event.getEntity().getKiller();
    	Player deadplayer = event.getEntity().getPlayer();
    	if (player==null || deadplayer==null) {
    		return;
    	}
    	
    	if (player == deadplayer) {
    		return;
    	}
    	else {
    		player.sendMessage(ChatColor.RED + "Healed for killing " + deadplayer.getName());
    		Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + "has won the fight with" + player.getHealth() + "health left");
    		player.setHealth(20);
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

