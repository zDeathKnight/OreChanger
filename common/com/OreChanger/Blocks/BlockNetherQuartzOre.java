package com.OreChanger.Blocks;

import java.util.Random;

import com.OreChanger.core.OreRateDrop;
import com.OreChanger.lib.Setting;

import net.minecraft.block.BlockOre;

public class BlockNetherQuartzOre extends BlockOre {

	public BlockNetherQuartzOre(int id) {
		super(id);
	}
	
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	if(Setting.ramdonDrops) return OreRateDrop.Gold();
        return 1;
    }

}
