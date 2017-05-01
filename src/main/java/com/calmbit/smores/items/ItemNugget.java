package com.calmbit.smores.items;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.EnumAlloy;
import com.calmbit.smores.materials.EnumMetal;
import com.calmbit.smores.materials.EnumNether;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Locale;


public class ItemNugget extends ItemBase implements IOreDict {
    private static ArrayList<String> materials;

    public ItemNugget() {
        super("nugget");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        if(materials == null) {
            materials = new ArrayList<String>();
            for(EnumMetal metal : EnumMetal.values()) {
            	if (metal==EnumMetal.IRON || metal==EnumMetal.GOLD) continue;
                materials.add(metal.getMaterialName());
            }
            for(EnumAlloy alloy : EnumAlloy.values()) {
                materials.add(alloy.getMaterialName());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(String material : materials) {
            subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + materials.get(stack.getItemDamage()).toLowerCase(Locale.ROOT);
    }

    @Override
    public void registerOreDict() {
        for(String material : materials) {
            OreDictionary.registerOre("nugget"+material, new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public void registerItemModel()
    {
        for(String material : materials) {
            Smores.proxy.registerItemRenderer(this, materials.indexOf(material), "nugget_" + material.toLowerCase(Locale.ROOT));
        }
    }
}
