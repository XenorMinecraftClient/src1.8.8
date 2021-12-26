package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import xenor.Xenor;
import xenor.accounts.GuiAltManager;
import xenor.http.MySQLFunctions;
	 
public class MainMenu2 extends GuiScreen {

	public void initGui() {}
	 
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/Background.png"));
		drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, this.width, this.height, this.width, this.height);
		
		boolean hovered = (mouseX >= this.width / 11 && mouseY >= 105 && mouseX < this.width / 6 && mouseY < 155);
		GlStateManager.pushMatrix();
		if(!hovered) {
			GlStateManager.color(255,255,255);
		} else {
			GlStateManager.color(0,0,0);
		}
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/singleplayer.png"));
		drawModalRectWithCustomSizedTexture(this.width / 17, 100, 0.0F, 0.0F, this.width / 7, this.height / 4, this.width / 7, this.height / 4);
		GlStateManager.popMatrix();
		
		boolean hovered1 = (mouseX >= this.width / 4 + 15 && mouseY >= 105 && mouseX < this.width / 3 + (this.width / 11) && mouseY < 155);
		GlStateManager.pushMatrix();
		if(!hovered1) {
			GlStateManager.color(255,255,255);
		} else {
			GlStateManager.color(0,0,0);
		}
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/multiplayer.png"));
		drawModalRectWithCustomSizedTexture(this.width / 4 + 15, 100, 0.0F, 0.0F, this.width / 7, this.height / 4, this.width / 7, this.height / 4);
		GlStateManager.popMatrix();
		
		
		boolean hovered2 = (mouseX >= this.width / 2 + 15 && mouseY >= 105 && mouseX < this.width / 2 + (this.width / 6)  && mouseY < 155);
		GlStateManager.pushMatrix();
		if(!hovered2) {
			GlStateManager.color(255,255,255);
		} else {
			GlStateManager.color(0,0,0);
		}
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/options.png"));
		drawModalRectWithCustomSizedTexture(this.width / 2 + 12, 100, 0.0F, 0.0F, this.width / 7, this.height / 4, this.width / 7, this.height / 4);
		GlStateManager.popMatrix();
		
		boolean hovered3 = (mouseX >= this.width - (this.width / 4) && mouseY >= 105 && mouseX < this.width - (this.width / 8) && mouseY < 155);
		GlStateManager.pushMatrix();
		if(!hovered3) {
			GlStateManager.color(255,255,255);
		} else {
			GlStateManager.color(0,0,0);
		}
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/exit.png"));
		drawModalRectWithCustomSizedTexture(this.width - (this.width / 4), 100, 0.0F, 0.0F, this.width / 7, this.height / 4, this.width / 7, this.height / 4);
		GlStateManager.popMatrix();
		
	    if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24 && Xenor.versionoutdated != true) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Merry X-mas!", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1 && Xenor.versionoutdated != true) {
		    drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Happy new Year!", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    } else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && Xenor.versionoutdated != true) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Happy Halloween!", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    } else if (Xenor.versionoutdated) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " is outdated!", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    	drawCenteredString(this.mc.fontRendererObj, "Install the latest version", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    	drawCenteredString(this.mc.fontRendererObj, "on our Discord Server!", 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    } else {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME, 0 + 20, this.height - this.mc.fontRendererObj.FONT_HEIGHT - 5, -1);
	    }
	}
	 
	  public void mouseClicked(int mouseX, int mouseY, int button) {
	      if (mouseX >= this.width / 11 && mouseY >= 105 && mouseX < this.width / 6 && mouseY < 155) {
	    	  this.mc.displayGuiScreen((GuiScreen)new GuiSelectWorld(this));
	      }
	      if (mouseX >= this.width / 4 + 15 && mouseY >= 105 && mouseX < this.width / 3 + (this.width / 11) && mouseY < 155) {
				this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer(this));
	      }
	      if (mouseX >= this.width / 2 + 15 && mouseY >= 105 && mouseX < this.width / 2 + (this.width / 6)  && mouseY < 155) {
	    	  this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
	      }
	      if (mouseX >= this.width - (this.width / 4) && mouseY >= 105 && mouseX < this.width - (this.width / 8) && mouseY < 155) {
	    	  this.mc.shutdown();
	      }
	  }
	 
	  public void onGuiClosed() {}
	}
