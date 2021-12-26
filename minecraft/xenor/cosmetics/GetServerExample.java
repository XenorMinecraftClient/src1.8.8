package xenor.cosmetics;

import net.minecraft.client.Minecraft;

public class GetServerExample {
	
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	String ip = mc.getCurrentServerData().serverIP;
	
	public GetServerExample() {
		if(ip != "hypixel.net") {
			
		}
	}
}
