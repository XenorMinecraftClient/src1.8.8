package ui.gui;

import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiCustomizeSkin;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiLockIconButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOptionsSounds;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.client.gui.GuiSnooper;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.gui.stream.GuiStreamOptions;
import net.minecraft.client.gui.stream.GuiStreamUnavailable;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.stream.IStream;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.EnumDifficulty;
import ui.clickgui.comp.ModButton;
import ui.clickgui.comp.ModButton2;
import xenor.Xenor;
import xenor.hud.mod.HudMod;

public class GuiMods extends GuiScreen {
	
    /** Reference to the GameSettings object. */
    private GuiButton field_175357_i;
    private GuiLockIconButton field_175356_r;
    
    ArrayList <ModButton> modButtons = new ArrayList<>();
    ArrayList <ModButton2> modButtons2 = new ArrayList<>();
    
    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
    	String text;
    	FontRenderer fontRendererIn;
    	super.initGui();
    	this.modButtons.add(new ModButton(this.width / 4 - 20, 60, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.keystrokesMod));
    	this.modButtons.add(new ModButton(this.width / 4 - 20, 100, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.targetHud));
    	this.modButtons.add(new ModButton(this.width / 4 - 20, 140, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.coordinates));
        this.modButtons.add(new ModButton(this.width / 3 + 30, 60, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.fpsMod));
        this.modButtons.add(new ModButton(this.width / 3 + 30, 100, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.serverip));
        this.modButtons.add(new ModButton(this.width / 3 + 30, 140, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.cpsMod));
        this.modButtons.add(new ModButton(this.width / 2 + 30, 60, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.fullbright));
        this.modButtons.add(new ModButton(this.width / 2 + 30, 100, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.toggleSprint));
        //this.modButtons.add(new ModButton(this.width / 2 + 80, 60, 19, mc.fontRendererObj.FONT_HEIGHT + 5, Xenor.INSTANCE.hudManager.cpsMod));
    }
    
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
		
		for(ModButton2 m2 : modButtons2) {
			m2.onClick(mouseX, mouseY, mouseButton);
		}
	}

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawWorldBackground(0);
        this.drawString(this.fontRendererObj, "Mods", this.width / 2, 15, 16777215);
        this.drawString(this.fontRendererObj, "Keystrokes", this.width / 4 - 19, 45, 16777215);
        this.drawString(this.fontRendererObj, "TargetHUD", this.width / 4 - 19, 85, 16777215);
        this.drawString(this.fontRendererObj, "Coordinates", this.width / 4 - 19, 125, 16777215);
        this.drawString(this.fontRendererObj, "Server IP", this.width / 3 + 30, 85, 16777215);
        this.drawString(this.fontRendererObj, "FPS", this.width / 3 + 30, 45, 16777215);
        this.drawString(this.fontRendererObj, "CPS", this.width / 3 + 30, 125, 16777215);
        this.drawString(this.fontRendererObj, "Fullbright", this.width / 2 + 30, 45, 16777215);
        this.drawString(this.fontRendererObj, "ToggleSprint", this.width / 2 + 30, 85, 16777215);
        this.drawString(this.fontRendererObj, "ToggleSneak", this.width / 2 + 30, 125, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        for(ModButton m : modButtons) {
			m.draw();
		}
        
        for(ModButton2 m2 : modButtons2) {
			m2.draw();
		}
    }
	
}
