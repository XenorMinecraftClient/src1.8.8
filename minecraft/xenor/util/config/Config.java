package xenor.util.config;

import java.io.File;
import java.io.IOException;

import xenor.Xenor;
import xenor.hud.mod.HudMod;

public class Config {
	
	public File configFolder = new File("Xenor");
	public File modsFolder = new File("Xenor/Mods");
	
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("Xenor/Mods/ModConfiguration.ironflipper"));
	
	
	public void saveModConfig() {
		
		if(!configFolder.exists()) {
			configFolder.mkdirs();
		}
		
		if(!modsFolder.exists()) {
			modsFolder.mkdir();
		}
		
		System.out.println("Saving Mod Config");
		
		for(HudMod m : Xenor.INSTANCE.hudManager.hudMods) {
			configToSave.set(m.name.toLowerCase() + " x", m.getX());
			configToSave.set(m.name.toLowerCase() + " y", m.getY());
			configToSave.set(m.name.toLowerCase() + " enabled", m.isEnabled());
		}
		
		try {
			configToSave.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadModConfig() {
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("Xenor/Mods/ModConfiguration.ironflipper"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
