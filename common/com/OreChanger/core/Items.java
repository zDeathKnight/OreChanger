package com.OreChanger.core;

import net.minecraft.item.Item;

import com.OreChanger.Items.ItemGoldOre;
import com.OreChanger.Items.ItemIronOre;
import com.OreChanger.lib.ItemIDs;

public class Items 
{
	public static void load()
	{
		OreIron = new ItemIronOre(ItemIDs.IronOreID).setUnlocalizedName("IronOre");
		Registry.oreRegistry("oreIron", Items.OreIron);
		OreGold = new ItemGoldOre(ItemIDs.GoldOreID).setUnlocalizedName("GoldOre");
		Registry.oreRegistry("oreGold", Items.OreGold);
	}
	public static Item OreIron;
	public static Item OreGold;
}
