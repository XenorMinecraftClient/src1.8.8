package xenor.mod.impl;

import xenor.mod.Category;
import xenor.mod.Mod;

public class TestMod extends Mod {

	public TestMod() {
		super("TestMod", "Test Mod", Category.MISC);
		
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("Meine Mod ist an :D");
	}

}
