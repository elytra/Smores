package com.calmbit.smores.items;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;


public class ItemDust extends ItemBase implements IOreDict {
    private static ArrayList<IDustProducing> materials;

    public ItemDust() {
        super("dust");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        if(materials == null) {
            materials = new ArrayList<IDustProducing>();
            for(EnumMetalType metal : EnumMetalType.values()) {
                materials.add(metal);
            }
            for(EnumAlloyType alloy : EnumAlloyType.values()) {
                materials.add(alloy);
            }
            for(EnumNetherType nether : EnumNetherType.values()) {
                materials.add(nether);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(IDustProducing material : materials) {
            subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + " _" + materials.get(stack.getItemDamage()).toString().toLowerCase();
    }

    @Override
    public void registerOreDict() {
        for(IDustProducing material : materials) {
            OreDictionary.registerOre(material.getDustDictEntry(), new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public void registerItemModel()
    {
        for(IDustProducing material : materials) {
            Smores.proxy.registerItemRenderer(this, materials.indexOf(material), "dust_" + material.toString().toLowerCase());
        }
    }
}
