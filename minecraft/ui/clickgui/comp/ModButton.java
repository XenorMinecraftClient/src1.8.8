package ui.clickgui.comp;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;
import xenor.mod.impl.ToggleSprint;

public class ModButton {
	
	public int x, y, w, h;
	public HudMod mod;
	public ToggleSprint toggleSprint;
	public String OnOff;
	
	public ModButton(int x, int y, int w, int h, HudMod m) {
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
			return new Color(160, 160, 160).getRGB();
		} else {
			return new Color(0,0,0,0).getRGB();
		}
	}
	
	public void draw() {
		Gui.drawRect(x, y, w + x + 65, h + y, getColor());
		Minecraft.getMinecraft().fontRendererObj.drawString(mod.name, x + 2, y + 2, new Color(255,255,255).getRGB());
	}
	
	
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x + w + 65 && mouseY >= y && mouseY <= y + h) {
			if(mod.isEnabled()) {
				mod.setEnabled(false);
			} else {
				mod.setEnabled(true);
			}
		}
	}
}
