package com.calmbit.smores.items;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.EnumAlloyType;
import com.calmbit.smores.materials.EnumMetalType;
import com.calmbit.smores.materials.EnumMiscType;
import com.calmbit.smores.materials.IIngotProducing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;


public class ItemIngot extends ItemBase implements IOreDict {
    private static ArrayList<IIngotProducing> materials;

    public ItemIngot() {
        super("ingot");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        if(materials == null) {
            materials = new ArrayList<IIngotProducing>();
            for(EnumMetalType metal : EnumMetalType.values()) {
                materials.add(metal);
            }
            for(EnumAlloyType alloy : EnumAlloyType.values()) {
                materials.add(alloy);
            }
            for(EnumMiscType misc : EnumMiscType.values()) {
                materials.add(misc);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(IIngotProducing material : materials) {
            subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + materials.get(stack.getItemDamage()).toString().toLowerCase();
    }

    @Override
    public void registerOreDict() {
        for(IIngotProducing material : materials) {
            OreDictionary.registerOre(material.getIngotDictEntry(), new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public void registerItemModel()
    {
        for(IIngotProducing material : materials) {
            Smores.proxy.registerItemRenderer(this, materials.indexOf(material), "ingot_" + material.toString().toLowerCase());
        }
    }
}
