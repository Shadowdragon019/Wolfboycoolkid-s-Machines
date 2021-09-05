// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelgatunium_pressing_hammer_thrown_model extends EntityModel<Entity> {
	private final ModelRenderer group;

	public Modelgatunium_pressing_hammer_thrown_model() {
		textureWidth = 32;
		textureHeight = 32;

		group = new ModelRenderer(this);
		group.setRotationPoint(0.0F, 12.0F, 0.0F);
		group.setTextureOffset(0, 0).addBox(-5.0F, -6.0F, -3.0F, 10.0F, 6.0F, 6.0F, 0.0F, false);
		group.setTextureOffset(0, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		group.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}