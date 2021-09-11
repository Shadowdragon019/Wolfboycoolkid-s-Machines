package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Map;

public class PresserHeadPillerCheckerProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure PresserHeadPillerChecker!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure PresserHeadPillerChecker!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure PresserHeadPillerChecker!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure PresserHeadPillerChecker!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double totalPillers = 0;
		totalPillers = (double) 0;
		if (((!(world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z))))
				&& ((!(world.isAirBlock(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))))
						&& (!(world.isAirBlock(new BlockPos((int) (x + 1), (int) (y - 2), (int) z))))))) {
			totalPillers = (double) (totalPillers + 1);
		}
		if (((!(world.isAirBlock(new BlockPos((int) (x - 1), (int) y, (int) z))))
				&& ((!(world.isAirBlock(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))))
						&& (!(world.isAirBlock(new BlockPos((int) (x - 1), (int) (y - 2), (int) z))))))) {
			totalPillers = (double) (totalPillers + 1);
		}
		if (((!(world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1)))))
				&& ((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))))
						&& (!(world.isAirBlock(new BlockPos((int) x, (int) (y - 2), (int) (z - 1)))))))) {
			totalPillers = (double) (totalPillers + 1);
		}
		if (((!(world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1)))))
				&& ((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))))
						&& (!(world.isAirBlock(new BlockPos((int) x, (int) (y - 2), (int) (z + 1)))))))) {
			totalPillers = (double) (totalPillers + 1);
		}
		if ((2 <= totalPillers)) {
			return (true);
		}
		return (false);
	}
}
