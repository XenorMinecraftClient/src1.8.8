package xenor.http;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import xenor.http.gsonobjs.ObjGlobalSettings;
import xenor.http.gsonobjs.ObjIsBanned;
import xenor.http.gsonobjs.ObjIsWhitelisted;
import xenor.http.gsonobjs.ObjUserCosmetics;

public class MySQLFunctions {
	
	private static final Gson gson = new Gson();
	
	private static MySQLUserCosmetics[] userCosmetics;
	
	public static ArrayList<UUID> UUIDCapeQuestioned = new ArrayList<>();
	public static ArrayList<UUID> UUIDCapeTrue = new ArrayList<>();
	public static ArrayList<UUID> UUIDCapeFalse = new ArrayList<>();
	
	public static ArrayList<UUID> UUIDWingsQuestioned = new ArrayList<>();
	public static ArrayList<UUID> UUIDWingsTrue = new ArrayList<>();
	public static ArrayList<UUID> UUIDWingsFalse = new ArrayList<>();
	
	public static ArrayList<UUID> UUIDHatQuestioned = new ArrayList<>();
	public static ArrayList<UUID> UUIDHatTrue = new ArrayList<>();
	public static ArrayList<UUID> UUIDHatFalse = new ArrayList<>();
	
	public static ArrayList<UUID> UUIDcapestyleQuestioned = new ArrayList<>();
	public static ArrayList<UUID> UUIDcapestyle_xenorcape = new ArrayList<>();
	
	public static int cape = MySQLUserCosmetics.getCape(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	public static int googlyeyes = MySQLUserCosmetics.getGooglyEyes(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	public static String capestyle = MySQLUserCosmetics.getCapeStyle(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	public static float[] tophatcolor = MySQLUserCosmetics.getTopHatColor(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	public static int hat = MySQLUserCosmetics.getHat(Minecraft.getMinecraft().thePlayer.getUUID(Minecraft.getMinecraft().thePlayer.getGameProfile()));
	
	/*public static boolean shouldRenderCape(AbstractClientPlayer player) {
		MySQLUserCosmetics muc = getCosmetics(player);
		if(muc == null) {
			return false;
		}
		
		return muc.hasCape
	}
	
	public static MySQLUserCosmetics getCosmetics(AbstractClientPlayer player) {
		for(MySQLUserCosmetics muc : userCosmetics) {
			if(player.getGameProfile().getId().equals(muc.getUuid())) {
				return muc;
			}
		}
		return null;
	}*/

	public static boolean getCape(AbstractClientPlayer player) {
		if(!UUIDCapeQuestioned.contains(player.getUniqueID())) {
			if(MySQLUserCosmetics.getCape(player.getUniqueID()) == 1) {
				UUIDCapeQuestioned.add(player.getUniqueID());
				UUIDCapeTrue.add(player.getUniqueID());
				return true;
			} else {
				UUIDCapeQuestioned.add(player.getUniqueID());
				UUIDCapeFalse.add(player.getUniqueID());
				return false;
			}
		} else {
			if(UUIDCapeTrue.contains(player.getUniqueID())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public static boolean getWings(AbstractClientPlayer player) {
		if(!UUIDWingsQuestioned.contains(player.getUniqueID())) {
			if(MySQLUserCosmetics.getGooglyEyes(player.getUniqueID()) == 1) {
				UUIDWingsQuestioned.add(player.getUniqueID());
				UUIDWingsTrue.add(player.getUniqueID());
				return true;
			} else {
				UUIDWingsQuestioned.add(player.getUniqueID());
				UUIDWingsFalse.add(player.getUniqueID());
				return false;
			}
		} else {
			if(UUIDWingsTrue.contains(player.getUniqueID())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public static String capestyle(AbstractClientPlayer player) {
		if(!UUIDcapestyleQuestioned.contains(player.getUniqueID())) {
			if(MySQLUserCosmetics.getCapeStyle(player.getUniqueID()) == "xenorcape") {
				UUIDcapestyle_xenorcape.add(player.getUniqueID());
				UUIDcapestyleQuestioned.add(player.getUniqueID());
				return "xenorcape";
			} else {
				return "xenorcape";
			}
		} else {
			if(UUIDcapestyle_xenorcape.contains(player.getUniqueID())) {
				return "xenorcape";
			}
			else {
				return "xenorcape";
			}
		}
	}
	
	public static boolean getHat(AbstractClientPlayer player) {
		if(!UUIDHatQuestioned.contains(player.getUniqueID())) {
			if(MySQLUserCosmetics.getHat(player.getUniqueID()) == 1) {
				UUIDHatQuestioned.add(player.getUniqueID());
				UUIDHatTrue.add(player.getUniqueID());
				return true;
			} else {
				UUIDHatQuestioned.add(player.getUniqueID());
				UUIDHatFalse.add(player.getUniqueID());
				return false;
			}
		} else {
			if(UUIDHatTrue.contains(player.getUniqueID())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
	
}
