package envirotemp.api.capabilities;

import net.minecraft.nbt.NBTTagCompound;

public class TempHandlerDefault implements ITempHandler
{
	float bodyTemp = 37F;
	float skinTemp = 37F;
	
	@Override
	public float getTemperature()
	{
		return bodyTemp;
	}
	
	@Override
	public void updateTemperature(float airTemp)
	{
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		tag.setFloat("bodyTemp", bodyTemp);
		tag.setFloat("skinTemp", skinTemp);
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		bodyTemp = tag.getFloat("bodyTemp");
		skinTemp = tag.getFloat("skinTemp");
	}
}
