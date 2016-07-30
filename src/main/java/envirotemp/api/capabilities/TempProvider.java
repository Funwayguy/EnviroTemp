package envirotemp.api.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class TempProvider implements ICapabilityProvider, ICapabilitySerializable<NBTTagCompound>
{
	TempHandlerDefault tempHandler = new TempHandlerDefault();
	
	@Override
	public NBTTagCompound serializeNBT()
	{
		return tempHandler.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		tempHandler.readFromNBT(nbt);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == CapabilityTempHandler.TEMP_HANDLER_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if(capability == CapabilityTempHandler.TEMP_HANDLER_CAPABILITY)
		{
			return CapabilityTempHandler.TEMP_HANDLER_CAPABILITY.cast(tempHandler);
		}
		
		return null;
	}
}
