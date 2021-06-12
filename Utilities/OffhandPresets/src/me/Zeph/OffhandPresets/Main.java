package me.Zeph.OffhandPresets;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.jedk1.jedcore.JedCore;
import com.jedk1.jedcore.scoreboard.BendingBoard;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.AvatarAbility;
import com.projectkorra.projectkorra.object.Preset;
import com.projectkorra.projectkorra.util.ActionBar;

import net.md_5.bungee.api.ChatColor;


public class Main extends AvatarAbility implements AddonAbility{
	
	private int itemSlot;
	private int slotNo;
	private String slot;
	
	public Main(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
		itemSlot = player.getInventory().getHeldItemSlot();
		slotNo = itemSlot+1; 
		slot = String.valueOf(slotNo);
		start();
	}
	


	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "OffhandPresets";
	}
	
	@Override
	public String getDescription() {
		return "Name a preset a number, go to the corresponding slot and use your offhand key. Hold shift to use your offhand key without changing preset.";
	}
	@Override
	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSneakAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void progress() {
		// TODO Auto-generated method stub
		
		if (Preset.presetExists(player, slot)){
			Preset.bindPreset(player, Preset.getPreset(player, slot));
			BendingBoard.update(player);
			ActionBar.sendActionBar(ChatColor.YELLOW +"Successfully bound preset!", player);
			remove();
			return;
		}
		else {
			remove();
			return;
		}
	}
		

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "__Zephyrus";
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0.1";
	}

	@Override
	public void load() {
		
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new AbilityListener(), ProjectKorra.plugin);
		ProjectKorra.plugin.getLogger().info(String.format("%s %s, developed by %s, has been loaded.", getName(), getVersion(), getAuthor()));
		ProjectKorra.log.info("Successfully enabled " + getName() + " by " + getAuthor());
	}
		// TODO Auto-generated method stub
		
	

	@Override
	public void stop() {
		
		ProjectKorra.log.info("Successfully disabled " + getName() + " by " + getAuthor());
		
		
		super.remove();
	}
		// TODO Auto-generated method stub


	@Override
	public boolean isExplosiveAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgniteAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}


		
	}


	