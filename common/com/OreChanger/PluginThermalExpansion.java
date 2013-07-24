package com.OreChanger;

import net.minecraft.item.ItemStack;

import com.OreChanger.core.Items;

import thermalexpansion.api.crafting.CraftingManagers;
import thermalexpansion.api.item.ItemRegistry;
import cpw.mods.fml.common.Loader;

public class PluginThermalExpansion 
{	
	public static void load() 
	{
		if(Loader.isModLoaded("ThermalExpansion")) 
		{
			try 
			{
				CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(Items.OreIron), ItemRegistry.getItem("dustIron", 2), ItemRegistry.getItem("dustNickel",1), 10);
				CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(Items.OreGold), ItemRegistry.getItem("dustGold", 2));
			} 
			catch (Exception e) 
			{
				System.out.println("[OreChanger]: Thermal Expansion integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");	
			}
		}

	}
}
