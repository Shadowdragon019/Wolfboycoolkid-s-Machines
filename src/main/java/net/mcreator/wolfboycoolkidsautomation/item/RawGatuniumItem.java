
package net.mcreator.wolfboycoolkidsautomation.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsAutomationModElements;

@WolfboycoolkidsAutomationModElements.ModElement.Tag
public class RawGatuniumItem extends WolfboycoolkidsAutomationModElements.ModElement {
	@ObjectHolder("wolfboycoolkids_automation:raw_gatunium")
	public static final Item block = null;
	public RawGatuniumItem(WolfboycoolkidsAutomationModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("raw_gatunium");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
