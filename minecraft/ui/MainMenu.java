package ui;

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
	 
public class MainMenu extends GuiScreen {
	public void initGui() {}
	 
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Xenor/Background.png"));
		drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, this.width, this.height, this.width, this.height);
		drawGradientRect(0, this.height - 120, this.width, this.height, 0, -16777216);
		String[] buttons = { "Singleplayer", "Multiplayer", "Options", "Language", "Quit" };
		int count = 0;
	    byte b;
	    int i;
	    String[] arrayOfString1;
	    for (i = (arrayOfString1 = buttons).length, b = 0; b < i; ) {
		String name = arrayOfString1[b];
	  	float x = (this.width / buttons.length * count) + (this.width / buttons.length) / 2.0F + 8.0F - this.mc.fontRendererObj.getStringWidth(name) / 2.0F;
	      float y = (this.height - 20);
	      boolean hovered = (mouseX >= x && mouseY >= y && mouseX < x + this.mc.fontRendererObj.getStringWidth(name) && mouseY < y + this.mc.fontRendererObj.FONT_HEIGHT);
	      drawCenteredString(this.mc.fontRendererObj, name, (this.width / buttons.length * count) + (this.width / buttons.length) / 2.0F + 8.0F, (this.height - 20), hovered ? -16740097 : -1);
	      count++;
	      b++;
	    } 
	    GlStateManager.pushMatrix();
	    GlStateManager.translate(this.width / 2.0F, this.height / 2.0F, 0.0F);
	    GlStateManager.scale(3.0F, 3.0F, 1.0F);
	    GlStateManager.translate(-(this.width / 2.0F), -(this.height / 2.0F), 0.0F);
	    if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24 && Xenor.versionoutdated != true) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Merry X-mas!", this.width / 2.0F, this.height / 2.0F - this.mc.fontRendererObj.FONT_HEIGHT / 2.0F, -1);
	    } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1 && Xenor.versionoutdated != true) {
		    drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Happy new Year!", this.width / 2.0F, this.height / 2.0F - this.mc.fontRendererObj.FONT_HEIGHT / 2.0F, -1);
	    } else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && Xenor.versionoutdated != true) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " Happy Halloween!", this.width / 2.0F, this.height / 2.0F - this.mc.fontRendererObj.FONT_HEIGHT / 2.0F, -1);
	    } else if (Xenor.versionoutdated) {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME + " is outdated!", this.width / 2.0F, this.height / 2 - 20, -1);
	    	drawCenteredString(this.mc.fontRendererObj, "Install the latest version", this.width / 2.0F, this.height / 2 - 5, -1);
	    	drawCenteredString(this.mc.fontRendererObj, "on our Discord Server!", this.width / 2.0F, this.height / 2 + 5, -1);
	    } else {
	    	drawCenteredString(this.mc.fontRendererObj, Xenor.NAME, this.width / 2.0F, this.height / 2.0F - this.mc.fontRendererObj.FONT_HEIGHT / 2.0F, -1);
	    }
	    GlStateManager.popMatrix();
	  }
	 
	  public void mouseClicked(int mouseX, int mouseY, int button) {
	    String[] buttons = { "Singleplayer", "Multiplayer", "Options", "Language", "Quit" };
	    int count = 0;
	    byte b;
	    int i;
	    String[] arrayOfString1;
	    for (i = (arrayOfString1 = buttons).length, b = 0; b < i; ) {
	      String name = arrayOfString1[b];
	      float x = (this.width / buttons.length * count) + (this.width / buttons.length) / 2.0F + 8.0F - this.mc.fontRendererObj.getStringWidth(name) / 2.0F;
	      float y = (this.height - 20);
	      if (mouseX >= x && mouseY >= y && mouseX < x + this.mc.fontRendererObj.getStringWidth(name) && mouseY < y + this.mc.fontRendererObj.FONT_HEIGHT) {
	        String str;
	        switch ((str = name).hashCode()) {
	          case -2064742086:
	            if (!str.equals("Multiplayer"))
	              break; 
	            this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer(this));
	            break;
	          case -1548945544:
	            if (!str.equals("Language"))
	              break; 
	            this.mc.displayGuiScreen((GuiScreen)new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
	            break;
	          case -1500504759:
	            if (!str.equals("Singleplayer"))
	              break; 
	            this.mc.displayGuiScreen((GuiScreen)new GuiSelectWorld(this));
	            break;
	          case 2528879:
	            if (!str.equals("Quit"))
	              break; 
	            this.mc.shutdown();
	            break;
	          case 415178366:
	            if (!str.equals("Options"))
	              break; 
	            this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
	            break;
	        } 
	      } 
	      count++;
	      b++;
	    } 
	  }
	 
	  public void onGuiClosed() {}
	}
