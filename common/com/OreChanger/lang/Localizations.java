package com.OreChanger.lang;

import com.OreChanger.lib.Reference;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Localizations 
{
	public static void load()
	{
		for(String LocationFile :Localizations.localeFiles)
		{
			LanguageRegistry.instance().loadLocalization(LocationFile, getLocaleFromFileName(LocationFile), isXMLLanguageFile(LocationFile));
		}
	}
	
	public static boolean isXMLLanguageFile(String fileName)
	{
		return fileName.endsWith(".xml");
	}

	public static String getLocaleFromFileName(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
	}

	public static String letLocalizationString(String key)
	{
		return LanguageRegistry.instance().getStringLocalization(key);
	}
	
	private static final String LANG_RESOURCE_LOCATION = "/mods/"+Reference.MOD_NAME+"/lang/";

	public static String[] localeFiles = 
		{
			LANG_RESOURCE_LOCATION + "en_US.xml",
			LANG_RESOURCE_LOCATION + "en_GB.xml",
			LANG_RESOURCE_LOCATION + "fr_FR.xml",
			LANG_RESOURCE_LOCATION + "ef_ZA.xml",
			LANG_RESOURCE_LOCATION + "de_DE.xml"
			
		};
}
