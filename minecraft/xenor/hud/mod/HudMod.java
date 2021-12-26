package xenor.hud.mod;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import xenor.Xenor;
import xenor.hud.DraggableComponent;
import xenor.settings.Setting;

public class HudMod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public ArrayList<Setting> settings;
	
	public String name;
	public boolean enabled = true;
	public DraggableComponent drag;
	
	public int x, y;
	
	public HudMod(String name, int x, int y) {
		this.name = name;

		try {
			this.x = (int) Xenor.INSTANCE.config.config.get(name.toLowerCase() + " x");
			this.y = (int) Xenor.INSTANCE.config.config.get(name.toLowerCase() + " y");
			this.setEnabled((boolean) Xenor.INSTANCE.config.config.get(name.toLowerCase() + " enabled"));
		} catch(NullPointerException e) {
			e.printStackTrace();
			this.x = x;
			this.y = y;
			this.enabled = false;
		}
		
		settings = new ArrayList<Setting>();
		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
	}
	
	public void addSettings(Setting...sets) {
		this.settings.add((Setting) Arrays.asList(sets));
	}
	
	public int getWidth() {
		return 50;
	}
	
	public int getHeight() {
		return 50;
	}
	
	public void draw() {
		
	}
	
	public void disable() {
		
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void onEnable() {
		Xenor.INSTANCE.eventManager.register(this);
	}
	
	public void onDisable() {
		Xenor.INSTANCE.eventManager.unregister(this);
	}
	
	public void toggle() {
		this.setEnabled(!enabled);
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
