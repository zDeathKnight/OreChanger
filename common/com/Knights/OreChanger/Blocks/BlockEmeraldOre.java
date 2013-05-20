package com.Knights.OreChanger.Blocks;

import java.util.Random;

import com.Knights.OreChanger.OreChanger;
import com.Knights.OreChanger.OreRateDrop;


import net.minecraft.block.BlockOre;

public class BlockEmeraldOre extends BlockOre
{
    public BlockEmeraldOre(int par1)
    {
        super(par1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	if(OreChanger.ramdonDrops) return OreRateDrop.Gold();
        return 1;
    }

}
