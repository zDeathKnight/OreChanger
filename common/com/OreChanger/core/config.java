package com.OreChanger.core;

import java.io.File;
import java.util.logging.Level;

import com.OreChanger.lib.ItemIDs;
import com.OreChanger.lib.Reference;
import com.OreChanger.lib.Setting;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

public class config 
{
	public config(File file)
	{
		Configuration config = new Configuration(file);

		try
		{
			config.load();
			int ID =500;
			ItemIDs.IronOreID = config.get("ItemID", "IronOreID", ID++).getInt();
			ItemIDs.GoldOreID = config.get("ItemID", "GoldOreID", ID++).getInt();
			Setting.ramdonDrops = config.get("Setting", "ramdonDrops", true).getBoolean(true);
			Setting.checkwebversion = config.get("Setting", "Check Web Version", true).getBoolean(true);
			
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " Has a problem loading the config file");
		}	
		finally
		{
			config.save();
		}
		
	}


}
