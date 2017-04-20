package com.calmbit.smores.items;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.EnumAlloyType;
import com.calmbit.smores.materials.EnumMetalType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;


public class ItemGear extends ItemBase implements IOreDict {
    private static ArrayList<String> materials;

    public ItemGear() {
        super("gear");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        if(materials == null) {
            materials = new ArrayList<String>();
            for(EnumMetalType metal : EnumMetalType.values()) {
                materials.add(metal.getMaterialName());
            }
            for(EnumAlloyType alloy : EnumAlloyType.values()) {
                materials.add(alloy.getMaterialName());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(String  material : materials) {
            subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + materials.get(stack.getItemDamage()).toLowerCase();
    }

    @Override
    public void registerOreDict() {
        for(String material : materials) {
            OreDictionary.registerOre("gear"+material, new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public void registerItemModel()
    {
        for(String material : materials) {
            Smores.proxy.registerItemRenderer(this, materials.indexOf(material), "gear_" + material.toLowerCase());
        }
    }
}
