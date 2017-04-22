package com.calmbit.smores.proxy;

import com.calmbit.smores.Smores;
import com.calmbit.smores.items.ItemBlockSubtyped;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MethodCallSideOnly")
public class ClientProxy extends CommonProxy {

    public void init()
    {
        super.init();

    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        if(item instanceof ItemBlockSubtyped) {
            ItemBlockSubtyped subtyped = (ItemBlockSubtyped)item;
            Block blockFromItem = subtyped.getBlock();
            IBlockState blockState = blockFromItem.getStateFromMeta(meta);
            String variant = blockState.toString();
            Pattern pattern = Pattern.compile("smores:.*\\[(.*)]");
            Matcher matcher = pattern.matcher(variant);
            if(matcher.find())
                ModelLoader.setCustomModelResourceLocation(subtyped, meta, new ModelResourceLocation(Item.REGISTRY.getNameForObject(subtyped), matcher.group(1)));
        }
        else
            ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Smores.SMORES_MOD_ID + ":" + id, "inventory"));
    }
}
