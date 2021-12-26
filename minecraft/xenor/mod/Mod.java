package xenor.mod;

import net.minecraft.client.Minecraft;
import xenor.Xenor;

public class Mod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public String name, description;
	public boolean enabled;
	public Category category;
	
	public Mod(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		
		this.enabled = true;
	}
	
	public void onEnable() {
		Xenor.INSTANCE.eventManager.register(this);
	}
	
	public void onDisable() {
		Xenor.INSTANCE.eventManager.unregister(this);
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void toggle() {
		setEnabled(!this.enabled);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isEnabled() {
		return enabled;
	}

}
