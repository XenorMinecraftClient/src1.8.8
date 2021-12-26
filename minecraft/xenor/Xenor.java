package xenor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import ui.gui.ClickGUI;
import ui.gui.GuiHWIDBanned;
import ui.gui.GuiMods;
import ui.gui.SplashProgress;
import xenor.accounts.AltManager;
import xenor.accounts.MicrosoftAccountManager;
import xenor.cosmetics.CosmeticController;
import xenor.discord.DiscordRP;
import xenor.event.EventManager;
import xenor.event.EventTarget;
import xenor.event.impl.ClientTick;
import xenor.event.impl.EventUpdate;
import xenor.friends.FriendManager;
import xenor.http.MySQLFunctions;
import xenor.http.MySQL;
import xenor.http.MySQLUserCosmetics;
import xenor.http.gsonobjs.ObjGlobalSettings;
import xenor.hud.HUDConfigScreen;
import xenor.hud.mod.HudManager;
import xenor.mod.ModManager;
import xenor.util.SendUsername;
import xenor.util.SessionChanger;
import xenor.util.config.Config;
import xenor.websockets.SocketClient;

public class Xenor {
	
	public static String NAME = "Xenor";
	public String VERSION = "1.0";
	
	public String AUTHOR = "Ironflipper";
	public static Xenor INSTANCE = new Xenor();
	public static Minecraft mc = Minecraft.getMinecraft();
	public static final Xenor getInstance() { return INSTANCE; }
	public boolean hasSent = false;
	AbstractClientPlayer entitylivingbaseIn;
	
	public EventManager eventManager;
	public Config config;
	public HudManager hudManager;
	public ModManager modManager;
	private FriendManager friendsManager;
	public static AltManager altManager;
	public static MicrosoftAccountManager microsoftAccountManager;
	public static boolean versionoutdated;
	
	private DiscordRP discordRP = new DiscordRP();
	
	private volatile boolean isBanned;
	public boolean isWhitelisted;
	private ObjGlobalSettings globalSettings;
	
	public void startup() throws IOException {
	/*	URL versionchecker = new URL("http://direct.dotxyz.cf/xenor/version.html");
		boolean updated = false;
		BufferedReader in = new BufferedReader(new InputStreamReader(versionchecker.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		    if(inputLine.contains(VERSION)) {
		        updated = true;
		    } 
		
		if(updated) {
			System.out.println("This version is outdated!");
		    versionoutdated = true;
		}  */
		
		SplashProgress.setProgress(1, "Starting Xenor");
		eventManager = new EventManager();
		config = new Config();
		config.loadModConfig();
		modManager = new ModManager();
		hudManager = new HudManager();
		this.friendsManager = new FriendManager();
		microsoftAccountManager = new MicrosoftAccountManager();
		
		altManager = new AltManager();
		
		//SessionChanger.getInstance().setUserOffline("");
		
		//MYSQL
		MySQL.connect();
		
		/*try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("mysql command");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//PreparedStatement ps = MySQL.getConnection().prepareStatement(jaja);
		
		SplashProgress.setProgress(2, "Starting Discord Integration");
		discordRP.start();
		//microsoftAccountManager.MicrosoftAccountManage();
		System.out.println("Starting " + NAME + " " + VERSION);
		
		
		
		eventManager.register(this);
		
		SendUsername.sendMessage("**" + mc.getSession().getUsername() + "** just logged into the client!");
	}
	
	public void shutdown() {
		//System.out.println(SocketClient.client.request("start_tutorial", mc.thePlayer.getGameProfile().getName() + ":false"));
		discordRP.shutdown();
		config.saveModConfig();
		SendUsername.sendMessage("**" + mc.getSession().getUsername() + "** just closed the client!");
		System.out.println("Closing " + NAME + " " + VERSION);
		eventManager.unregister(this);
		
		MySQL.disconnect();
		
		
	}
	
	public static String getServerIP() {
		return mc.getCurrentServerData().serverIP;
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.GUI_MODS.isPressed()) {
			mc.displayGuiScreen(new ClickGUI());
		}
		if(mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		
	}
	
	public FriendManager getFriendsManager() {
		return friendsManager;
	}
	
}
