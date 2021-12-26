package xenor.hud.mod.impl;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;

public class ServerIPMod extends HudMod {
	
	public ServerIPMod() {
		super("Server IP", 20, 20);
	}
	
	@Override
	public void draw() {
		if(!mc.isSingleplayer()) {
			Gui.drawRect(getX() - 2, getY() - 2, getX() + getStringWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
			fr.drawString("Server IP: " + mc.getCurrentServerData().serverIP,  getX(), getY(), -1);
		}
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth() + 29, getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString(name, getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	public int getStringWidth() {
		return fr.getStringWidth("Server IP: " + mc.getCurrentServerData().serverIP);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
