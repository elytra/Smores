package com.elytradev.smores.item;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemSubtyped extends ItemBase implements IOreDict {

	private static Map<EnumProduct, List<EnumMaterial>> materials;
	private EnumProduct productType;

	public ItemSubtyped(String name, EnumProduct productType) {
		super(name);
		this.productType = productType;
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

		if (materials == null) {
			materials = new HashMap<>();
		}

		if(!materials.containsKey(productType)) {
			materials.put(productType, new ArrayList<>());
			for (EnumMaterial material : EnumMaterial.values()) {
				if (material.hasProduct(productType)) {
					materials.get(productType).add(material);
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (isInCreativeTab(tab)) {
			for (EnumMaterial material : materials.get(productType)) {
				subItems.add(new ItemStack(this, 1, materials.get(productType).indexOf(material)));
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "_" + materials.get(productType).get(stack.getItemDamage()).getName();
	}

	@Override
	public void registerOreDict() {
		for (EnumMaterial material : materials.get(productType)) {
			OreDictionary.registerOre(this.name + material.getMaterialName(),
					new ItemStack(this, 1, materials.get(productType).indexOf(material)));
		}
	}

	@Override
	public void registerItemModel() {
		for (EnumMaterial material : materials.get(productType)) {
			Smores.PROXY.registerItemRenderer(this, materials.get(productType).indexOf(material),
					name + "_" + material.getName());
		}
	}

}
