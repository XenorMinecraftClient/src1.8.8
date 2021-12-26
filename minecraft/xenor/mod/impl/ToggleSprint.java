package xenor.mod.impl;

import net.minecraft.potion.Potion;
import xenor.event.EventTarget;
import xenor.event.impl.EventUpdate;
import xenor.hud.mod.HudMod;
import xenor.mod.Category;
import xenor.mod.Mod;

public class ToggleSprint extends HudMod {

	public ToggleSprint() {
		super("ToggleSprint", 150, 150);
		
	}
	
	@EventTarget
	public void draw() {
		if(isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& !mc.thePlayer.isSwingInProgress
				&& !mc.thePlayer.isUsingItem() 
				&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0) 
				&& !mc.thePlayer.isCollidedHorizontally 
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindBack.isKeyDown()
				&& !mc.gameSettings.keyBindLeft.isKeyDown()
				&& !mc.gameSettings.keyBindRight.isKeyDown()) {
					
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void disable() {
		super.disable();
		
		mc.thePlayer.setSprinting(false);
	}

}
