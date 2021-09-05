package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Map;
import java.util.HashMap;

public class TreeChopperUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure TreeChopperUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure TreeChopperUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure TreeChopperUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure TreeChopperUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Direction.DOWN == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y - 1));
					$_dependencies.put("z", z);
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		} else if ((Direction.UP == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y + 1));
					$_dependencies.put("z", z);
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		} else if ((Direction.NORTH == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", (z - 1));
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		} else if ((Direction.SOUTH == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", (z + 1));
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		} else if ((Direction.WEST == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", (x - 1));
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		} else if ((Direction.EAST == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:wood_like").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", (x + 1));
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					BreakWoodBlocksNearMeProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
