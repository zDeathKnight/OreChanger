package com.OreChanger.Blocks;

import java.util.Random;

import com.OreChanger.core.Items;
import com.OreChanger.core.OreRateDrop;
import com.OreChanger.lib.Setting;


import net.minecraft.block.BlockOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIronOre extends BlockOre
{
    public BlockIronOre(int id)
    {
        super(id);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Items.OreIron.itemID;
    }

    public int quantityDropped(Random par1Random)
    {
    	if(Setting.ramdonDrops) return OreRateDrop.Iron();
        return 1;
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, 
            MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2));
    }
}
