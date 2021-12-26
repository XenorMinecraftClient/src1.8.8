package xenor.util;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData {
	
	public static final ResourceLocation STAR = new ResourceLocation("Xenor/star.png");

	public ServerDataFeatured(String servername, String serverIP) {
		super(servername, serverIP, false);
	}

}
