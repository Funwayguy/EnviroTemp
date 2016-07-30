package envirotemp.api.capabilities;

import java.util.concurrent.Callable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import envirotemp.core.EnviroTemp;

public class CapabilityTempHandler
{
	@CapabilityInject(ITempHandler.class)
	public static Capability<ITempHandler> TEMP_HANDLER_CAPABILITY = null;
	public static ResourceLocation TEMP_HANDLER_ID = new ResourceLocation(EnviroTemp.MODID + ":temperature");
	
	static
	{
		CapabilityManager.INSTANCE.register(ITempHandler.class, new Capability.IStorage<ITempHandler>()
		{
			@Override
			public NBTBase writeNBT(Capability<ITempHandler> capability, ITempHandler instance, EnumFacing side)
			{
				if(!(instance instanceof TempHandlerDefault))
				{
					throw new RuntimeException("ITempHandler instance does not extend TempHandlerDefault");
				}
				
				NBTTagCompound nbt = new NBTTagCompound();
				TempHandlerDefault storage = (TempHandlerDefault)instance;
				storage.writeToNBT(nbt);
				return nbt;
			}
			
			@Override
			public void readNBT(Capability<ITempHandler> capability, ITempHandler instance, EnumFacing side, NBTBase nbt)
			{
				if(!(instance instanceof TempHandlerDefault))
				{
					throw new RuntimeException("ITempHandler instance does not extend TempHandlerDefault");
				}
				
				TempHandlerDefault storage = (TempHandlerDefault)instance;
				storage.readFromNBT((NBTTagCompound)nbt);
			}
		}, new Callable<ITempHandler>()
		{
			@Override
			public ITempHandler call() throws Exception
			{
				return new TempHandlerDefault();
			}
		});
	}
}
