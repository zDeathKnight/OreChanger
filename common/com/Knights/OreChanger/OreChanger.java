
package com.Knights.OreChanger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.Knights.OreChanger.Blocks.BlocksOverride;
import com.Knights.OreChanger.Common.CommonProxy;
import com.Knights.OreChanger.Common.ConnectionHandler;
import com.Knights.OreChanger.Common.PacketHandler;
import com.Knights.OreChanger.Items.ItemGoldOre;
import com.Knights.OreChanger.Items.ItemIronOre;
import com.Knights.OreChanger.lang.Localizations;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true,serverSideRequired=false, channels={Reference.MOD_ID}, packetHandler= PacketHandler.class, connectionHandler=ConnectionHandler.class)


public class OreChanger
{
	@Instance
	public static OreChanger instance = new OreChanger();
	
	@SidedProxy(clientSide = Reference.clientSide, serverSide = Reference.serverSide)
	public static CommonProxy porxy;
	
	// -- old load for modloader
	
   /* public mod_OreChanger()
    {
//   	ModChecker("OreChanger", 2, "http://dl.dropbox.com/u/37682543/checker/OreChanger.htm", "http://adf.ly/4hUgu", ModLoader.getMinecraftInstance());
    	//ModLoader.setInGameHook(this, true, true);
    	//ReadModConfigFile();
    	//Main();
    }*/
	public static boolean hasLatestVersion = true;
	private String latestVersionId =null;
	
    @PreInit
	public void PreLoad(FMLPreInitializationEvent event) 
    {
    	FMLLog.info("[OreChanger] PreLoad");
    	//ReadModConfigFile();
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		IronOreID = config.get("ItemID", "IronOreID", IronOreID).getInt();
		GoldOreID = config.get("ItemID", "GoldOreID", GoldOreID).getInt();
		ramdonDrops = config.get("Setting", "ramdonDrops", ramdonDrops).isBooleanValue();
		checkwebversion = config.get("Setting", "Check Web Version", checkwebversion).isBooleanValue();
		config.save();
		
		try {
			latestVersionId = getLatestVersionFromWeb();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(VersionCompare.compare( latestVersionId, Reference.VERSION ) > 0){	
			hasLatestVersion = false;
		}
	}
    
    
    @Init
	public void load(FMLInitializationEvent event) 
    {
    	//porxy.registerRenderThings();
		//NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
    	Main();
    	AddSmelting();
    	BlocksOverride.load();
    	Localizations.load();
    }
    
    @PostInit
	public static void postInit(FMLPostInitializationEvent event) {
		FMLLog.info("[OreChanger] postInit");
	}
    
    public void AddSmelting()
    {
    	GameRegistry.addSmelting(OreGold.itemID, new ItemStack (Item.ingotGold, 1), 1.0F);
    	GameRegistry.addSmelting(OreIron.itemID, new ItemStack (Item.ingotIron, 1), 0.7F); 
    }
   
    
    //private static File file = new File(Minecraft.getMinecraftDir(), "config/OreChanger.cfg");

    
    /*private static void ReadModConfigFile()
    {
    	File file = file2;
    	
    	PropertieReader config = new PropertieReader();
    	try
    	{
    		boolean flag = file.createNewFile();
    		if(flag)
            {
            	Calendar calendar = Calendar.getInstance();
            	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mma z");
            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            	writer.write("#OreChanger Config"); writer.newLine();
                writer.write("#Time: "+dateFormat.format(calendar.getTime()) + " Date: " +timeFormat.format(calendar.getTime())); writer.newLine();
                writer.newLine();
                writer.write("// FOR ADVANCED USERS ONLY");writer.newLine();
            	writer.write("#ItemID (>=256.0,<=32000.0)");writer.newLine();
            	writer.write("#BlockID (>=1.0,<=255.0)");writer.newLine();
            	writer.newLine();
            	writer.write("// If you are experiencing compatibility issues with another mod, you can use these settings to change the IDs for all blocks and items added in this mod");writer.newLine();writer.newLine();
            	writer.write("// WARNING: Altering this file can corrupt saved worlds or cause game crashes if not done correctly.");writer.newLine(); 
            	writer.write("// The author of this mod accepts no responsibility for any lost game data.");writer.newLine();
              	writer.newLine();
            	writer.write("#");writer.newLine();
            	writer.write("#ItemID");writer.newLine();
            	writer.write("IronOreID=" + Integer.toString(IronOreID));writer.newLine();
            	writer.write("GoldOreID=" + Integer.toString(GoldOreID));writer.newLine();
            	writer.write("// Enable Ramdons drops. true:false");writer.newLine();
            	writer.write("RamdonDrops="+ Boolean.toString(ramdonDrops));;writer.newLine();
            	writer.newLine();
                writer.newLine();
                writer.write("// do not edit is line below");writer.newLine();
                writer.write("Config_Version=3");writer.newLine();
                
                
            	writer.newLine();writer.close();
            }
    		config.load(new FileInputStream(file));
    		Config = Integer.parseInt(config.getProperty("Config_Version"));

    		IronOreID = Integer.parseInt(config.getProperty("IronOreID"));
    		GoldOreID = Integer.parseInt(config.getProperty("GoldOreID"));
    		ramdonDrops = Boolean.parseBoolean(config.getProperty("RamdonDrops"));
            
        }
        catch(Exception exception)
        {
            System.out.println("Failed to load OreChanger config file");
            exception.printStackTrace();
        }
        //CheckConfig();
    }
    private static int ValidateIDFromFile(int i, int j)
    {
        if(j > 0)
        {
            return j;
        } else
        {
            return i;
        }
    }*/
    
    


   // public static int Config = 3;
    
    public static int IronOreID = 500;//144
    public static int GoldOreID = 501;//145
    	
    public static Item OreIron;
	public static Item OreGold;
	public static boolean ramdonDrops = true;
	public static boolean checkwebversion = true;
	
	public void Main()  
	{
		OreIron = new ItemIronOre(IronOreID -256).setUnlocalizedName("IronOre");
		OreGold = new ItemGoldOre(GoldOreID -256).setUnlocalizedName("GoldOre");			
	}
	

	private String getLatestVersionFromWeb() throws Exception 
	{

		URL versionIn = new URL("https://dl.dropboxusercontent.com/u/37682543/minecraft_mods/OreChanger/Version.txt");

		/*
		 * Changed by Konitor
		 * Don't access the internet on servers or closed LANs.
		 */
		if(checkwebversion)
		{

	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(versionIn.openStream()));
	        String inputLine = in.readLine();
	        in.close();
			return inputLine;
		}
		else
		{
			return Reference.VERSION;
		}
		
	}
	
	/* private static void CheckConfig()
	    {
	    	if(Config < 3)
	    	{
	    		File f2 = new File(Minecraft.getMinecraftDir(), "mod_OreChanger_old.txt");
	    		System.out.println(f2.delete());
	    		File f1 = file;
	    		f1.renameTo(new File("mod_OreChanger_old.txt"));
	    		//File file = new File(Minecraft.getMinecraftDir(), "config/mod_OreChanger.properties");
	    		
	    		System.out.println(file.delete());  
	    		ReadModConfigFile();
	    	} 
	    }*/
	 
	
	
	/*private static void ModChecker(String name, double version, String versiondoc, String download, Minecraft mc)
    {
        System.out.println((new StringBuilder()).append("Checking if ").append(name).append(" is up-to-date").toString());
        try
        {
            URL url = new URL(versiondoc);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            double newversion = 0.0D;
            do
            {
                String str;
                if((str = in.readLine()) == null)
                    break;
                if(!str.contains("Version"))
                    continue;
                newversion = Double.parseDouble(str.replaceAll("Version:", "").trim());
                break;
            } while(true);
            if(newversion > version)
            {
                System.out.println((new StringBuilder()).append(name).append(" is out-of-date").toString());
                String url2 = download;
                JFrame frame32 = new JFrame();
                frame32.setVisible(true);
                frame32.setDefaultCloseOperation(2);
                if(JOptionPane.showConfirmDialog(frame32, (new StringBuilder()).append(name).append(" is out-of-date, would you like to update now").toString(), "Knight Mod Update Checker", 2) == 0)
                {
                    frame32.setVisible(false);
                    frame32.dispose();
                    mc.shutdown();
                    Desktop.getDesktop().browse(URI.create(url2));
                } else
                {
                    frame32.setVisible(false);
                    frame32.dispose();
                }
            } else
            {
                System.out.println((new StringBuilder()).append(name).append(" is up-to-date").toString());
            }
            in.close();
        }
        catch(MalformedURLException e) { }
        catch(IOException e) { }
    }*/

	
}
