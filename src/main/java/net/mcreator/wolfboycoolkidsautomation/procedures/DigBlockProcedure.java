package net.mcreator.wolfboycoolkidsautomation.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.wolfboycoolkidsautomation.block.GatuniumSandOreBlock;
import net.mcreator.wolfboycoolkidsautomation.block.GatuniumRedSandOreBlock;
import net.mcreator.wolfboycoolkidsautomation.block.GatuniumGravelOreBlock;
import net.mcreator.wolfboycoolkidsautomation.block.GatuniumDirtOreBlock;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class DigBlockProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency entity for procedure DigBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency x for procedure DigBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency y for procedure DigBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency z for procedure DigBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WolfboycoolkidsMachinesMod.LOGGER.warn("Failed to load dependency world for procedure DigBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double fortuneLevel = 0;
		boolean gatuniumLooted = false;
		gatuniumLooted = (boolean) (false);
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() instanceof ShovelItem)) {
			fortuneLevel = (double) (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 0.66) + 1);
			if ((GatuniumDirtOreBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				gatuniumLooted = (boolean) (true);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.COARSE_DIRT.getDefaultState(), 3);
			} else if ((GatuniumGravelOreBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				gatuniumLooted = (boolean) (true);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.GRAVEL.getDefaultState(), 3);
			} else if ((GatuniumSandOreBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				gatuniumLooted = (boolean) (true);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.SAND.getDefaultState(), 3);
			} else if ((GatuniumRedSandOreBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				gatuniumLooted = (boolean) (true);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.RED_SAND.getDefaultState(), 3);
			}
		}
		if (gatuniumLooted) {
			world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z),
					Block.getStateId((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))));
			for (int index0 = 0; index0 < (int) (fortuneLevel); index0++) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"loot give @s loot wolfboycoolkids_machines:blocks/gatunium_dig");
					}
				}
			}
			if ((!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)))) {
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 3, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		}
	}
}
