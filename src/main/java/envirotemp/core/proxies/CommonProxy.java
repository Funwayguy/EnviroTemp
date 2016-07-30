package envirotemp.core.proxies;

import net.minecraftforge.common.MinecraftForge;
import envirotemp.client.gui.UpdateNotification;

public class CommonProxy
{
	public boolean isClient()
	{
		return false;
	}
	
	public void registerHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new UpdateNotification());
	}
	
	public void registerRenderers()
	{
	}
}
