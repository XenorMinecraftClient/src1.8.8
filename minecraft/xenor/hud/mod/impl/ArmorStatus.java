package xenor.hud.mod.impl;


import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xenor.Xenor;
import xenor.event.EventTarget;
import xenor.hud.mod.HudMod;

public class ArmorStatus extends HudMod {
	
	public ArmorStatus() {
		super("ArmorStatus", 150, 150);
	}
	
	/*@EventTarget
	public void draw() {
		
		ScaledResolution sr = new ScaledResolution(mc);
		for(int i21 = 0; i21 < Minecraft.getMinecraft().thePlayer.inventory.armorInventory.length; i21++) {
			ItemStack is = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[i21];
			this.renderArmorStatus(sr, i21, is);
		}
	}
	
	public static void renderArmorStatus(ScaledResolution sr, int pos, ItemStack itemStack) {
		
		Minecraft mc = Minecraft.getMinecraft();
		float x = getX();
		float y = getY();
		
		if(itemStack == null) {
			return;
		}
		int posXAdd = (-16 * pos) + 48;
		int posYAdd = (-16 * pos) + 48;
		
		GlStateManager.pushMatrix();
		RenderHelper.enableGUIStandardItemLighting();
		
		Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int) x + posXAdd, (int) y);

		GlStateManager.popMatrix();
		
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Minecraft mc = Minecraft.getMinecraft();
		
		GlStateManager.pushMatrix();
		RenderHelper.enableGUIStandardItemLighting();
		
		Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Item.getItemById(1)), (int) x, (int) y);

		GlStateManager.popMatrix();
		
		super.renderDummy(mouseX, mouseY);
	}*/

}