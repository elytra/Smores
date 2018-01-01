package com.elytradev.smores.generic;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemModelRegisterable {
	@SideOnly(Side.CLIENT)
	void registerItemModel(Item item);
}
