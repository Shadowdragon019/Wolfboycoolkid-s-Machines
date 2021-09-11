package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.wolfboycoolkidsautomation.block.PresserHeadPressingBlock;
import net.mcreator.wolfboycoolkidsautomation.block.PresserHeadBlock;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Map;

public class PresserArmBlockValidPlacementConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure PresserArmBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure PresserArmBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure PresserArmBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure PresserArmBlockValidPlacementCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((PresserHeadBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())
				|| (PresserHeadPressingBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
			return (true);
		}
		return (false);
	}
}
