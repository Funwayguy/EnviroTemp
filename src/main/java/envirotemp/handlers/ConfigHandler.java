package envirotemp.handlers;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import envirotemp.core.EnviroTemp;
import envirotemp.core.ET_Settings;

public class ConfigHandler
{
	public static Configuration config;
	
	public static void initConfigs()
	{
		if(config == null)
		{
			EnviroTemp.logger.log(Level.ERROR, "Config attempted to be loaded before it was initialised!");
			return;
		}
		
		config.load();
		
		ET_Settings.hideUpdates = config.getBoolean("Hide Updates", Configuration.CATEGORY_GENERAL, false, "Hide update notifications");
		
		config.save();
		
		EnviroTemp.logger.log(Level.INFO, "Loaded configs...");
	}
}
