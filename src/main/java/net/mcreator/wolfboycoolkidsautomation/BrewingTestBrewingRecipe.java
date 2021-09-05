
package net.mcreator.wolfboycoolkidsautomation;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.wolfboycoolkidsautomation.potion.PotionOfReturniumPotion;

@WolfboycoolkidsMachinesModElements.ModElement.Tag
public class BrewingTestBrewingRecipe extends WolfboycoolkidsMachinesModElements.ModElement {
	public BrewingTestBrewingRecipe(WolfboycoolkidsMachinesModElements instance) {
		super(instance, 82);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.GLASS_BOTTLE;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Blocks.BROWN_BED.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), PotionOfReturniumPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
