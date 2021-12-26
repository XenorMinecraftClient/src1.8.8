package ui.clickgui.comp;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;
import xenor.mod.ModManager;
import xenor.mod.impl.ToggleSprint;

public class ModButton2 {
	
	public int x, y, w, h;
	public HudMod mod;
	public ToggleSprint toggleSprint;
	public String OnOff;
	
	public ModButton2(int x, int y, int w, int h, HudMod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.mod = m;
	}
	
	public String getEnabled() {
		if(mod.isEnabled()) {
			return OnOff = "On";
		} else {
			return OnOff = "Off";
		}
	}
	
	private int getColor() {
		if(mod.isEnabled()) {
			return new Color(255, 255, 255).getRGB();
		} else {
			return new Color(168, 168, 168).getRGB();
		}
	}
	
	public void draw() {
		Gui.drawRect(x, y, x + w, y + h, new Color(0, 0, 0, 170).getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(getEnabled(), x + 2, y + 2, getColor());
	}
	
	
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			if(mod.isEnabled()) {
				mod.setEnabled(false);
			} else {
				mod.setEnabled(true);
			}
		}
	}
}
