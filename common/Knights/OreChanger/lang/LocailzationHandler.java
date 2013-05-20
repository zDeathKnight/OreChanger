package Knights.OreChanger.lang;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocailzationHandler {
	
	public static void load()
	{
		for(String LocationFile :Localizations.localeFiles)
		{
			LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocaleFromFileName(LocationFile), LocalizationHelper.isXMLLanguageFile(LocationFile));
		}
	}
}
