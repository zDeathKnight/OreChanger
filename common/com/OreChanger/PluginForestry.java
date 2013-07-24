package com.OreChanger;

import net.minecraft.item.ItemStack;

import com.OreChanger.core.Items;

import forestry.api.core.IPlugin;
import forestry.api.core.PluginInfo;
import forestry.api.storage.BackpackManager;

@PluginInfo(name = "OreChanger Forestry Plugin", pluginID = "OreChangerForestryPlugin", author = "EmoKnight")
public class PluginForestry implements IPlugin 
{
	// forestry backpack numbers
	public static final int MINER = 0;
	public static final int DIGGER = 1;
	public static final int FORESTER = 2;
	public static final int ADVENTURER = 3;
	public static final int BUILDER = 4;

	@Override
	public boolean isAvailable() 
	{	
		return true;
	}

	@Override
	public void preInit() {}

	@Override
	public void doInit() {
		BackpackManager.backpackItems[MINER].add(new ItemStack(Items.OreIron));
		BackpackManager.backpackItems[MINER].add(new ItemStack(Items.OreIron));
	}

	@Override
	public void postInit() {}

}
