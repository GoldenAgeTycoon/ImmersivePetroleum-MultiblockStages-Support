package flaxbeard.immersivepetroleum.common.blocks.metal;

import flaxbeard.immersivepetroleum.common.blocks.BlockIPBase;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum BlockTypes_IPMetalMultiblock implements IStringSerializable, BlockIPBase.IBlockEnum
{
	DISTILLATION_TOWER(false),
	DISTILLATION_TOWER_PARENT(true),
	PUMPJACK(false),
	PUMPJACK_PARENT(false);

	private boolean needsCustomState;

	BlockTypes_IPMetalMultiblock(boolean needsCustomState)
	{
		this.needsCustomState = needsCustomState;
	}

	@Override
	public String getName()
	{
		return this.toString().toLowerCase(Locale.ENGLISH);
	}

	@Override
	public int getMeta()
	{
		return ordinal();
	}

	@Override
	public boolean listForCreative()
	{
		return false;
	}

	public boolean needsCustomState()
	{
		return this.needsCustomState;
	}

	public String getCustomState()
	{
		String[] split = getName().split("_");
		String s = split[0].toLowerCase(Locale.ENGLISH);
		for (int i = 1; i < split.length; i++)
		{
			s += split[i].substring(0, 1).toUpperCase(Locale.ENGLISH) + split[i].substring(1).toLowerCase(Locale.ENGLISH);
		}
		return s;
	}
}