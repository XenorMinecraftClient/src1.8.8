package xenor.mod.impl;

import net.minecraft.potion.Potion;
import xenor.event.EventTarget;
import xenor.event.impl.EventUpdate;
import xenor.hud.mod.HudMod;
import xenor.mod.Category;
import xenor.mod.Mod;

public class ToggleSneak extends HudMod {

	public ToggleSneak() {
		super("ToggleSneak", 150, 150);
		
	}
	
	@EventTarget
	public void draw() {
		if(isEnabled() 
				&& (mc.thePlayer.isSneaking()) 
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.thePlayer.isSprinting()) {
					
			mc.thePlayer.setSneaking(true);
		}
	}
	
	@Override
	public void disable() {
		super.disable();
		
		mc.thePlayer.setSneaking(false);
	}

}
