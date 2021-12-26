package xenor.hud.mod;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import xenor.hud.mod.impl.ArmorStatus;
import xenor.hud.mod.impl.CPSMod;
import xenor.hud.mod.impl.CoordinatesMod;
import xenor.hud.mod.impl.EquippedItemMod;
import xenor.hud.mod.impl.FPSBoost;
import xenor.hud.mod.impl.FPSMod;
import xenor.hud.mod.impl.Fullbright;
import xenor.hud.mod.impl.Keystrokes;
import xenor.hud.mod.impl.ServerIPMod;
import xenor.hud.mod.impl.TargetHud;
import xenor.hud.mod.impl.TestMod;
import xenor.mod.impl.ToggleSneak;
import xenor.mod.impl.ToggleSprint;

public class HudManager{
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public FPSMod fpsMod;
	public ToggleSprint toggleSprint;
	public Keystrokes keystrokesMod;
	public CPSMod cpsMod;
	public ArmorStatus armorStatus;
	public TargetHud targetHud;
	public ServerIPMod serverip;
	public CoordinatesMod coordinates;
	public EquippedItemMod equippeditemmod;
	public Fullbright fullbright;
	public FPSBoost fpsBoost;
	
	public HudManager() {
		hudMods.add(fpsMod = new FPSMod());
		hudMods.add(keystrokesMod = new Keystrokes());
		hudMods.add(cpsMod = new CPSMod());
		hudMods.add(armorStatus = new ArmorStatus());
		//hudMods.add(targetHud = new TargetHud());
		hudMods.add(serverip = new ServerIPMod());
		hudMods.add(coordinates = new CoordinatesMod());
		hudMods.add(equippeditemmod = new EquippedItemMod());
		hudMods.add(fullbright = new Fullbright());
		hudMods.add(toggleSprint = new ToggleSprint());
		hudMods.add(fpsBoost = new FPSBoost());
	}
	
	public void renderMods() {
		boolean isDrawn = false;
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
				m.draw();
			} else if(!m.isEnabled()) {
				if(!isDrawn || m.name == "Fullbright") {
					m.disable();
					isDrawn = true;
				}
			}
		}
	}
}
