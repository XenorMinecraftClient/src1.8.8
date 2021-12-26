package ui.gui;

import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import ui.clickgui.comp.ModButton;
import ui.clickgui.comp.ModButton2;
import xenor.Xenor;

public class ClickGUI extends GuiScreen {
	
	ArrayList <ModButton> modButtons = new ArrayList<>();
	
	public void initGui() {
		super.initGui();
		this.modButtons.add(new ModButton(this.width / 2 + 10, 40, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.keystrokesMod));
    	//this.modButtons.add(new ModButton(this.width / 2 + 10, 55, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.targetHud));
    	this.modButtons.add(new ModButton(this.width / 2 + 10, 70, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.coordinates));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 85, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.fpsMod));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 100, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.serverip));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 115, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.cpsMod));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 130, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.fullbright));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 145, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.toggleSprint));
        this.modButtons.add(new ModButton(this.width / 2 + 10, 160, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.fpsBoost));
	}
	
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		Gui.drawRect(sr.getScaledWidth() / 2 - 110, 30, sr.getScaledWidth() / 2 + 100, sr.getScaledHeight() - 30, new Color(0, 0, 0, 170).getRGB());
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(sr.getScaledWidth() / 2 - 80, sr.getScaledHeight() / 2 - 40, 0);
		GlStateManager.scale(2.0F, 2.0F, 0.0F);
		this.drawString(this.fontRendererObj, "Xenor", 0, 0, new Color(255,255,255).getRGB());
		GlStateManager.popMatrix();
		
		this.drawString(this.fontRendererObj, "Name: " + mc.thePlayer.getName(), sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() / 2 + 70, new Color(255,255,255).getRGB());
		
		for(ModButton m : modButtons) {
			m.draw();
		}
    }
	
	private void drawImg(int x, int y, boolean lower, ResourceLocation texture) {
		this.mc.getTextureManager().bindTexture(texture);
		Gui.drawModalRectWithCustomSizedTexture(x - 16, lower ? y + 16 : y, 0.0F, 0.0F, 52, 52, 52, 52);
		
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
	
}
