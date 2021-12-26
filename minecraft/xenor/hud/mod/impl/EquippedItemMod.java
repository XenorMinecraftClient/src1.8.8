package xenor.hud.mod.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xenor.hud.ScreenPosition;
import xenor.hud.mod.HudMod;

public class EquippedItemMod extends HudMod {
	
	public EquippedItemMod() {
		super("FPS", 110, 110);
	}
	
	public void draw(ScreenPosition pos) {
		renderItemStack(pos, 3,  mc.thePlayer.getCurrentEquippedItem());
		super.draw();
	}
	
	
	
	public void renderDummy(ScreenPosition pos, int mouseX, int mouseY) {
		GlStateManager.pushMatrix();
		int scaleFactor = new ScaledResolution(this.mc).getScaleFactor();
		double scale = 2.0/scaleFactor;
		GlStateManager.scale(scale, scale, scale);
		renderItemStack(pos, 3, new ItemStack(Items.diamond_sword));
		GlStateManager.popMatrix();
	}
	
	private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
		
		if(is == null) {
			return;
		}
		
		GL11.glPushMatrix();
		int yAdd = (-16 * i) + 48;
		
		if(is.getItem().isDamageable()) {
			double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage() * 100);
			fr.drawStringWithShadow(String.format("%.0f", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
		}
		
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
		GL11.glPopMatrix();
		
	}
	
	@Override
	public int getWidth() {
		return 40;
	}
	
	@Override
	public int getHeight() {
		return 17;
	}
	
}
