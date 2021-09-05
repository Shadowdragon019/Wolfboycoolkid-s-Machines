package net.mcreator.wolfboycoolkidsautomation.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesModElements;

import java.lang.reflect.Method;

@WolfboycoolkidsMachinesModElements.ModElement.Tag
public class TreeChopperBreakingSpeedGameRule extends WolfboycoolkidsMachinesModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("treeChopperBreakingSpeed", GameRules.Category.PLAYER,
			create(20));
	public TreeChopperBreakingSpeedGameRule(WolfboycoolkidsMachinesModElements instance) {
		super(instance, 74);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
