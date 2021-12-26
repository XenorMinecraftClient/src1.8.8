package xenor.hud.mod.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.Gui;
import xenor.hud.mod.HudMod;

public class Fullbright extends HudMod {
	
	public boolean isDrawn = false;
	private float lastBrightness;
	
	public Fullbright() {
		super("Fullbright", 150, 150);
	}
	
	@Override
	public int getWidth() {
		return fr.FONT_HEIGHT;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	@Override
	public void draw() {
		mc.gameSettings.gammaSetting = 1000000L;
	}
	
	public void disable() {
		mc.gameSettings.gammaSetting = 0L;
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		super.renderDummy(mouseX, mouseY);
	}
	
}
