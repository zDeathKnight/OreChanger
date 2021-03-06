package com.OreChanger.Blocks;

import java.util.Random;

import com.OreChanger.core.Items;
import com.OreChanger.core.OreRateDrop;
import com.OreChanger.lib.Setting;


import net.minecraft.block.BlockOre;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGoldOre extends BlockOre
{
    public BlockGoldOre(int par1)
    {
        super(par1);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Items.OreGold.itemID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	if(Setting.ramdonDrops)return OreRateDrop.Gold();
        return 1;
    }

    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, 
            MathHelper.getRandomIntegerInRange(par1World.rand, 1, 3));
    }
}
