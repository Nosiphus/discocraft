package com.nosiphus.discocraft.particles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Reflection extends Particle {

	private static final ResourceLocation REFLECTION_TEXTURE = new ResourceLocation("discocraft:textures/entity/reflection.png");
	private static final VertexFormat VERTEX_FORMAT = (new VertexFormat()).addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);
	
	public Reflection(World worldIn, double posXIn, double posYIn, double posZIn) {
		super(worldIn, posXIn, posYIn, posZIn);
		
		this.particleRed = 0.25f;
		this.particleGreen = 0.25f;
		this.particleBlue = 0.25f;
		
		this.particleMaxAge = 16;
		this.particleAge = 0;
	}
	
	public void renderParticle(BufferBuilder worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		
		GL11.glPushMatrix();
		GL11.glDepthFunc(GL11.GL_ALWAYS);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, this.particleAlpha);
		GlStateManager.disableLighting();
		RenderHelper.disableStandardItemLighting();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(REFLECTION_TEXTURE);
		int i = (int)(((float)this.particleAge + partialTicks) * 15.0F / (float)this.particleMaxAge);
		
		if (i <= 15) {
			
			float f = (float)(i % 16) / 16.0F;
			float f1 = f + 0.0625f;
			float f2 = (float)(i / 16) / 16.0F;
			float f3 = f2 + 0.0625f;
			float f4 = .3f;
			float f5 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
			float f6 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
			float f7 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
			
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.disableLighting();
			RenderHelper.disableStandardItemLighting();
			worldRendererIn.begin(7, VERTEX_FORMAT);
			worldRendererIn.pos(
					(double)(f5 - rotationX * f4 - rotationXY * f4),
					(double)(f6 - rotationZ * f4),
					(double)(f7 - rotationYZ * f4 - rotationXZ * f4))
					.tex((double)f1, (double)f3)
					.color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F)
					.lightmap(0, 240)
					.normal(0.0F, 1.0F, 0.0F)
					.endVertex();	
			worldRendererIn.pos((double)(f5 - rotationX * f4 + rotationXY * f4), (double)(f6 + rotationZ * f4), (double)(f7 - rotationYZ * f4 + rotationXZ * f4)).tex((double)f1, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
			worldRendererIn.pos((double)(f5 + rotationX * f4 + rotationXY * f4), (double)(f6 + rotationZ * f4), (double)(f7 + rotationYZ * f4 + rotationXZ * f4)).tex((double)f, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
			worldRendererIn.pos((double)(f5 + rotationX * f4 - rotationXY * f4), (double)(f6 - rotationZ * f4), (double)(f7 + rotationYZ * f4 - rotationXZ * f4)).tex((double)f, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
			Tessellator.getInstance().draw();
			GlStateManager.enableLighting();
		}
		
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glPopMatrix();
		GlStateManager.enableLighting();
		
	}

	@Override
	public void onUpdate() {
		
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		
		if (this.particleAge++ >= this.particleMaxAge)
		{
			this.setExpired();
		}
		
		this.move(0, 0, 0);
		
	}
	
	public int getFXLayer()
	{
		return 3;
	}
	
}
