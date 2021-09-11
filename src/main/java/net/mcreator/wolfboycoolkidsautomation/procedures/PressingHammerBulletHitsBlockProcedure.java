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

import net.mcreator.wolfboycoolkidsautomation.block.PressedObsidianBlock;
import net.mcreator.wolfboycoolkidsautomation.block.PressedIronImbuedLapisLazuliBlockBlock;
import net.mcreator.wolfboycoolkidsautomation.block.ObsidianReinforcedNetherBricksBlock;
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
		double yOffset = 0;
		yOffset = (double) 0;
		if (((Blocks.IRON_TRAPDOOR == (world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z)))))
				.getBlock())
				&& (BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:storage_blocks/lapis").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))
								.getBlock())))) {
			success1 = PressedIronImbuedLapisLazuliBlockBlock.block.getDefaultState();
			pressSucces = (boolean) (true);
		} else if (((Blocks.OBSIDIAN == (world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z)))))
				.getBlock())
				&& (Blocks.OBSIDIAN == (world.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 2), (int) (Math.floor(z)))))
						.getBlock()))) {
			yOffset = (double) (-1);
			success1 = PressedObsidianBlock.block.getDefaultState();
			pressSucces = (boolean) (true);
		} else if (((PressedObsidianBlock.block == (world
				.getBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))))).getBlock())
				&& (Blocks.NETHER_BRICKS == (world
						.getBlockState(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) - 1), (int) (Math.floor(z))))).getBlock()))) {
			success1 = ObsidianReinforcedNetherBricksBlock.block.getDefaultState();
			pressSucces = (boolean) (true);
		}
		if (pressSucces) {
			world.destroyBlock(new BlockPos((int) (Math.floor(x)), (int) ((Math.floor(y)) + yOffset), (int) (Math.floor(z))), false);
			world.destroyBlock(new BlockPos((int) (Math.floor(x)), (int) (((Math.floor(y)) - 1) + yOffset), (int) (Math.floor(z))), false);
			if (world instanceof ServerWorld) {
				FallingBlockEntity blockToSpawn = new FallingBlockEntity((World) world, ((Math.floor(x)) + 0.5), (((Math.floor(y)) - 1) + yOffset),
						((Math.floor(z)) + 0.5), (success1));
				blockToSpawn.fallTime = 1;
				world.addEntity(blockToSpawn);
			}
			if (((success1).getMaterial() == net.minecraft.block.material.Material.IRON)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null,
							new BlockPos((int) (Math.floor(x)), (int) (((Math.floor(y)) - 1) + yOffset), (int) (Math.floor(z))),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.place")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound((Math.floor(x)), (((Math.floor(y)) - 1) + yOffset), (Math.floor(z)),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.place")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		}
	}
}
