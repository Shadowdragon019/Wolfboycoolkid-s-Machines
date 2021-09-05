
package net.mcreator.wolfboycoolkidsautomation.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesModElements;

import java.util.List;
import java.util.Collections;

@WolfboycoolkidsMachinesModElements.ModElement.Tag
public class PresserHeadBlock extends WolfboycoolkidsMachinesModElements.ModElement {
	@ObjectHolder("wolfboycoolkids_machines:presser_head")
	public static final Block block = null;
	public PresserHeadBlock(WolfboycoolkidsMachinesModElements instance) {
		super(instance, 104);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 20f).setLightLevel(s -> 0).harvestLevel(-1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("presser_head");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
