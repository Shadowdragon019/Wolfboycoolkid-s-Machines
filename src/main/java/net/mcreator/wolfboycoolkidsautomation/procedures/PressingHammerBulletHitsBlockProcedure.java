package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.wolfboycoolkidsautomation.block.PressedIronImbuedLapisLazuliBlockBlock;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Map;

public class PressingHammerBulletHitsBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure PressingHammerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure PressingHammerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure PressingHammerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure PressingHammerBulletHitsBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean pressSucces = false;
		BlockState success1 = Blocks.AIR.getDefaultState();
		if (((Blocks.IRON_TRAPDOOR == (world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z)))))
				.getBlock())
				&& (BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:storage_blocks/lapis").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))
								.getBlock())))) {
			pressSucces = (boolean) (true);
			world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z))), Blocks.AIR.getDefaultState(),
					3);
			success1 = PressedIronImbuedLapisLazuliBlockBlock.block.getDefaultState();
			if (world instanceof ServerWorld) {
				FallingBlockEntity blockToSpawn = new FallingBlockEntity((World) world, ((Math.floor(x)) + 0.5), ((Math.floor(y)) - 1),
						((Math.floor(z)) + 0.5), (success1));
				blockToSpawn.fallTime = 1;
				world.addEntity(blockToSpawn);
			}
		}
		if (pressSucces) {
			world.playEvent(2001, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
					Block.getStateId((world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))));
			if (((success1).getMaterial() == net.minecraft.block.material.Material.IRON)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z))),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.place")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound((Math.floor(x)), ((Math.floor(y)) - 1), (Math.floor(z)),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.place")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		}
	}
}
