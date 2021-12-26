package xenor.hud.mod.impl;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;

public class FPSMod extends HudMod {
	
	public FPSMod() {
		super("FPS", 21, 33);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString(mc.getDebugFPS() + " FPS",  getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString(name, getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(mc.getDebugFPS() + " FPS");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
