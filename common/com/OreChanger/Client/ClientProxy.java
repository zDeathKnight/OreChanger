package com.OreChanger.Client;


import net.minecraft.client.Minecraft;

import com.OreChanger.Common.CommonProxy;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerRenderThings() {}
	
	@Override
	public String getMinecraftDir()
	{
		return Minecraft.getMinecraftDir().toString();
	}
}
