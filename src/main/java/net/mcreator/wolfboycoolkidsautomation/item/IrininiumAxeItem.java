
package net.mcreator.wolfboycoolkidsautomation.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesModElements;

@WolfboycoolkidsMachinesModElements.ModElement.Tag
public class IrininiumAxeItem extends WolfboycoolkidsMachinesModElements.ModElement {
	@ObjectHolder("wolfboycoolkids_machines:irininium_axe")
	public static final Item block = null;
	public IrininiumAxeItem(WolfboycoolkidsMachinesModElements instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2365;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IrininiumIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("irininium_axe"));
	}
}
