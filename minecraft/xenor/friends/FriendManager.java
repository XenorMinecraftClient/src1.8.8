package xenor.friends;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xenor.Xenor;
import xenor.util.Files;
import xenor.util.Strings;
import xenor.util.config.FriendConfig;

public class FriendManager {

	private List<String> friends;
	private List<String> enemies;

	private FriendConfig friendsConfig;
	private FriendConfig enemiesConfig;

	public FriendManager() {
		this.friends = new ArrayList<String>();
		this.enemies = new ArrayList<String>();

		String clientFolder = new File(".").getAbsolutePath();

		clientFolder = (clientFolder.contains("jars") ? new File(".").getAbsolutePath().substring(0, clientFolder.length() - 2) : new File(".").getAbsolutePath()) + Strings.getSplitter() + Xenor.INSTANCE.NAME;

		this.friendsConfig = new FriendConfig(clientFolder + "/friends.cfg");
		this.enemiesConfig = new FriendConfig(clientFolder + "/enemies.cfg");

		try {
			Files.create(friendsConfig.getFile());
			Files.create(enemiesConfig.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		friendsConfig.addDefault("friends", "");
		enemiesConfig.addDefault("enemies", "");

		this.friends = friendsConfig.getStringList("friends", null);
		this.enemies = enemiesConfig.getStringList("enemies", null);
	}

	public List<String> getFriends() {
		return friends;
	}

	public List<String> getEnemies() {
		return enemies;
	}

	public void addFriend(String playerName) {
		if (!(isFriend(playerName))) {
			friends.add(playerName);
			friendsConfig.set("friends", friends);
		}
	}

	public void removeFriend(String playerName) {
		if (isFriend(playerName)) {
			friends.remove(playerName);
			friendsConfig.set("friends", friends);
		}
	}

	public void addEnemy(String playerName) {
		if (!(isEnemy(playerName))) {
			enemies.add(playerName);
			friendsConfig.set("enemies", enemies);
		}
	}

	public void removeEnemy(String playerName) {
		if (isEnemy(playerName)) {
			enemies.add(playerName);
			friendsConfig.set("enemies", enemies);
		}
	}

	public boolean isFriend(String playerName) {
		return friends.stream().anyMatch(playerName::equalsIgnoreCase);
	}

	public boolean isEnemy(String playerName) {
		return enemies.stream().anyMatch(playerName::equalsIgnoreCase);
	}

	public void clear() {
		friends.clear();
		enemies.clear();
		friendsConfig.set("friends", friends);
		friendsConfig.set("enemies", enemies);
	}

}