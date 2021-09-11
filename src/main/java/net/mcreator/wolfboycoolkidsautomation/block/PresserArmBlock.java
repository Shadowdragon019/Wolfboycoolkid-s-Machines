
package net.mcreator.wolfboycoolkidsautomation.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.wolfboycoolkidsautomation.procedures.PresserArmBlockValidPlacementConditionProcedure;
import net.mcreator.wolfboycoolkidsautomation.WolfboycoolkidsMachinesModElements;

import java.util.List;
import java.util.Collections;

import com.google.common.collect.ImmutableMap;

@WolfboycoolkidsMachinesModElements.ModElement.Tag
public class PresserArmBlock extends WolfboycoolkidsMachinesModElements.ModElement {
	@ObjectHolder("wolfboycoolkids_machines:presser_arm")
	public static final Block block = null;
	public PresserArmBlock(WolfboycoolkidsMachinesModElements instance) {
		super(instance, 106);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 20f).setLightLevel(s -> 0).harvestLevel(-1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool().notSolid().setOpaque((bs, br, bp) -> false));
			setRegistryName("presser_arm");
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
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			return VoxelShapes.or(makeCuboidShape(5, -8, 5, 11, 16, 11), makeCuboidShape(0, -13, 0, 16, -8, 16)).withOffset(offset.x, offset.y,
					offset.z);
		}

		@Override
		public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
			if (worldIn instanceof IWorld) {
				IWorld world = (IWorld) worldIn;
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				return PresserArmBlockValidPlacementConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world));
			}
			return super.isValidPosition(blockstate, worldIn, pos);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			return !state.isValidPosition(world, currentPos)
					? Blocks.AIR.getDefaultState()
					: super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(PresserHeadBlock.block);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR));
		}
	}
}
