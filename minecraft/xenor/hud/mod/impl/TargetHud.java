package xenor.hud.mod.impl;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import ui.gui.GuiMods;
import xenor.hud.mod.HudMod;

public class TargetHud extends HudMod {
	
	EntityLivingBase target;
	
	public TargetHud() {
		super("TargetHud", 132, 92);
	}
	
	@Override
	public void draw() {
		renderTargetHud();
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("TargetName", getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow("20 \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}
	
	private void renderTargetHud() {
		/*if(isEnabled()) {
			target = (EntityLivingBase) mc.pointedEntity;
	
			if(target != null) {
				fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
				fr.drawStringWithShadow(target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
			}	
		}*/
	}
	
}
