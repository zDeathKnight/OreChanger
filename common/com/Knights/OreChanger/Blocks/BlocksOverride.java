package com.Knights.OreChanger.Blocks;

import net.minecraft.block.Block;
 
public class BlocksOverride {
	
	public static void load()
	{
		Block.blocksList[14] = null;
		Block.blocksList[15] = null;
		Block.blocksList[16] = null;
		//Block.blocksList[21] = null;
		Block.blocksList[56] = null;
		Block.blocksList[129] = null;
		Block.blocksList[153] = null;
		Block.blocksList[14] = new BlockGoldOre(14).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreGold");
		Block.blocksList[15] = (new BlockIronOre(15)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreIron");
		Block.blocksList[16] = (new BlockCoalOre(16)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreCoal");
		Block.blocksList[56] = (new BlockDiamondOre(56)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreDiamond");
		Block.blocksList[129] = new BlockEmeraldOre(129).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreEmerald");
		Block.blocksList[153] = new BlockNetherQuartzOre(153).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netherquartz");
	}

}
