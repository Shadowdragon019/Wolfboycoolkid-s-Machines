package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Block;

import net.mcreator.wolfboycoolkidsautomation.world.TreeChopperBreakingSpeedGameRule;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Map;
import java.util.HashMap;

public class BreakWoodBlocksNearMeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure BreakWoodBlocksNearMe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure BreakWoodBlocksNearMe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure BreakWoodBlocksNearMe!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure BreakWoodBlocksNearMe!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
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
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) (world.getWorldInfo().getGameRulesInstance().getInt(TreeChopperBreakingSpeedGameRule.gamerule)));
	}
}
