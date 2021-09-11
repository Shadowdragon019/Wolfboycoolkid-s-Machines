package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.wolfboycoolkidsautomation.block.PresserHeadPressingBlock;
import net.mcreator.wolfboycoolkidsautomation.block.PresserArmBlock;
import net.mcreator.wolfboycoolkidsautomation.block.PressedObsidianBlock;
import net.mcreator.wolfboycoolkidsautomation.block.PressedIronImbuedLapisLazuliBlockBlock;
import net.mcreator.wolfboycoolkidsautomation.block.ObsidianReinforcedNetherBricksBlock;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import com.google.common.collect.ImmutableMap;

public class PresserHeadUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure PresserHeadUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure PresserHeadUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure PresserHeadUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure PresserHeadUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean itemSuccess = false;
		ItemStack itemToPress = ItemStack.EMPTY;
		if ((PresserHeadPillerCheckerProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))
				&& PressHeadBaseCheckProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))) {
			if (((world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z))) && (BlockTags.getCollection()
					.getTagByID(new ResourceLocation(("forge:storage_blocks/lapis").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock())))) {
				{
					List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB((x + 0.5) - (1 / 2d), (y - 1) - (1 / 2d),
							(z + 0.5) - (1 / 2d), (x + 0.5) + (1 / 2d), (y - 1) + (1 / 2d), (z + 0.5) + (1 / 2d)), null).stream()
							.sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((x + 0.5), (y - 1), (z + 0.5))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("forge:ingots/iron").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((new Object() {
									public ItemStack entityToItem(Entity _ent) {
										if (_ent instanceof ItemEntity) {
											return ((ItemEntity) _ent).getItem();
										}
										return ItemStack.EMPTY;
									}
								}.entityToItem(entityiterator)).getItem()))) {
							itemToPress = (new Object() {
								public ItemStack entityToItem(Entity _ent) {
									if (_ent instanceof ItemEntity) {
										return ((ItemEntity) _ent).getItem();
									}
									return ItemStack.EMPTY;
								}
							}.entityToItem(entityiterator));
							((itemToPress)).shrink((int) 1);
							itemSuccess = (boolean) (true);
						}
					}
				}
				if (itemSuccess) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PresserHeadPressingBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PresserArmBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), PressedIronImbuedLapisLazuliBlockBlock.block.getDefaultState(),
							3);
				}
			} else if (((world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z)))
					&& (Blocks.OBSIDIAN == (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PresserHeadPressingBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PresserArmBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), PressedObsidianBlock.block.getDefaultState(), 3);
			} else if (((PressedObsidianBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())
					&& (Blocks.NETHER_BRICKS == (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PresserHeadPressingBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PresserArmBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), ObsidianReinforcedNetherBricksBlock.block.getDefaultState(), 3);
			}
		}
	}
}
