package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumMetal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidAlloy extends BlockFluidSmores {

	private EnumAlloy alloy;

	public BlockFluidAlloy(Fluid fluid, EnumAlloy alloy, String name) {
		super(fluid, Material.LAVA, name);
		this.alloy = alloy;
	}


	@Override
	public Vec3d getFogColor(World world, BlockPos pos, IBlockState state, Entity entity, Vec3d originalColor, float partialTicks) {
		return convertToFogColor(alloy.getColor());
	}
}
