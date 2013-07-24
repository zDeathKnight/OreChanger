package com.OreChanger.Common;


import com.OreChanger.lib.Setting;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;



public class ConnectionHandler implements IConnectionHandler
{
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager){}
	
	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager){return "";}
	
	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager){}
	
	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager){}
	
	@Override
	public void connectionClosed(INetworkManager manager){}
	
	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login)
	{
		if(Setting.hasLatestVersion== false)
		{
			//let player know their version is out of date
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("There is a new version of OreChanger available, check the forums for details!");
		}
	}
}