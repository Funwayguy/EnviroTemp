package envirotemp.api.capabilities;

import net.minecraft.nbt.NBTTagCompound;

public interface ITempHandler
{
	public float getTemperature();
	
	public void updateTemperature(float airTemp);
	
	public NBTTagCompound writeToNBT(NBTTagCompound tag);
	
	public void readFromNBT(NBTTagCompound tag);
}
