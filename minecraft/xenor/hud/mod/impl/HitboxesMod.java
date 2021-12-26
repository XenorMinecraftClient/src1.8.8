package xenor.hud.mod.impl;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;

public class HitboxesMod extends HudMod {
	
	public HitboxesMod() {
		super("Hitboxes", 150, 150);
	}
	
	@Override
	public void draw() {
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(mc.getDebugFPS() + " Hitboxes");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
