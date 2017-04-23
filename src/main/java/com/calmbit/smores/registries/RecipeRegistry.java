package com.calmbit.smores.registries;

import com.calmbit.smores.materials.EnumAlloy;
import com.calmbit.smores.materials.EnumGem;
import com.calmbit.smores.materials.EnumMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeRegistry {
    public static void init() {
        // TODO: Disable the shit out of these.
        for(EnumMetal metal : EnumMetal.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemIngot, 1, metal.getId()), new Object[]{"NNN", "NNN", "NNN", 'N', "nugget"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemNugget, 9, metal.getId()), new Object[]{"ingot"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemGear, 1, metal.getId()), new Object[]{"*M*","MIM","*M*",'M',"ingot"+metal.getMaterialName(),'I',"ingotIron"}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockMetal, 1, metal.getId()), new Object[]{"III", "III", "III", 'I', "ingot"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, metal.getId()), new Object[]{"block"+ metal.getMaterialName()}));

            GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockMetalOre, 1, metal.getId()), new ItemStack(ItemRegistry.itemIngot, 1, metal.getId()), 0.7f);
        }

        for(EnumAlloy alloy : EnumAlloy.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemIngot, 1, alloy.getId()), new Object[]{"NNN", "NNN", "NNN", 'N', "nugget"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemNugget, 9, alloy.getId()), new Object[]{"ingot"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemGear, 1, alloy.getId()), new Object[]{"*M*","MIM","*M*",'M',"ingot"+alloy.getMaterialName(),'I',"ingotIron"}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockAlloy, 1, alloy.getId()), new Object[]{"III", "III", "III", 'I', "ingot"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, alloy.getId()), new Object[]{"block"+ alloy.getMaterialName()}));
        }

        for(EnumGem gem : EnumGem.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockGem, 1, gem.getId()), new Object[]{"GGG", "GGG", "GGG", 'G', "gem"+ gem.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemGem, 9, gem.getId()), new Object[]{"block"+ gem.getMaterialName()}));

            GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockGemOre, 1, gem.getId()), new ItemStack(ItemRegistry.itemGem, 1, gem.getId()), 1.0f);

        }


    }
}
