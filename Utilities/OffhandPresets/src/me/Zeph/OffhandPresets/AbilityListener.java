package me.Zeph.OffhandPresets;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.object.Preset;


public class AbilityListener implements Listener {

	@EventHandler
	public void onOffhand(PlayerSwapHandItemsEvent event) {
		
		
		Player player = event.getPlayer();
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);
		
		if (bPlayer == null) {
			return;
		}
		else if (bPlayer!=null && player.isSneaking()){
			new Main(player);
		}
		
		}
	}

