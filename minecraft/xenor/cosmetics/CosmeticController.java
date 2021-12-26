package xenor.cosmetics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import xenor.Xenor;
import xenor.http.MySQLFunctions;
import xenor.http.MySQL;
import xenor.http.MySQLUserCosmetics;
import xenor.http.gsonobjs.ObjUserCosmetics;

public class CosmeticController {
	
/*	private static ObjUserCosmetics[] userCosmetics;
	
	static AbstractClientPlayer entitylivingbaseIn;
	public static String uuid;
	
	public static List capeusersXenor = new ArrayList();
	public static List capeusersNormal = new ArrayList();
	public static List RedHat = new ArrayList();
	public static List YellowHat = new ArrayList();
	public static List BlueHat = new ArrayList();
	
	//MySQL
	
	public static void CapeCheck(AbstractClientPlayer entitylivingbaseIn) {
		capeusersXenor.add("IronFlipper");
		capeusersNormal.add("Zeny1n");
		capeusersXenor.add("DezeJK");
		capeusersNormal.add("BPBot");
		capeusersNormal.add("Admin_Lascha");
	}
		
		
	//	ObjUserCosmetics uc = getCosmetics(entitylivingbaseIn);
	//	if(uc == null) {
	//		return false;
	//	}
	//	return uc.getHat().isEnabled();
		
		if(MySQLUserCosmetics.getHat(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile())) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean shouldRenderCape(AbstractClientPlayer entitylivingbaseIn) {
		if(MySQLUserCosmetics.getCape(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile())) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean shouldRenderGooglyEyes(AbstractClientPlayer player) {
		if(MySQLUserCosmetics.getGooglyEyes(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile())) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static float[] getTopHatColor(AbstractClientPlayer entitylivingbaseIn) {
		return MySQLUserCosmetics.getTopHatColor(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	}
	*/
}
