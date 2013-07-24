package com.OreChanger.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGoldOre  extends Item 
{
	public ItemGoldOre(int id) 
	{
		super(id-256);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("OreChanger:GoldOre");
    }
}
