package xenor.http;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class MySQLUserCosmetics {

	private String uuid;
	
	public static int getHat(UUID uuid) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT hat_enabled FROM cosmetics WHERE UUID = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery(); */
			ResultSet rs = MySQL.getResult("SELECT * FROM cosmetics WHERE UUID = '" + uuid + "'");
			while(rs.next()) {
				return rs.getInt("hat_enabled");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getFeaturedServerName(int id) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT hat_enabled FROM cosmetics WHERE UUID = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery(); */
			ResultSet rs = MySQL.getResult("SELECT * FROM featuredserverlist WHERE id = '" + id + "'");
			while(rs.next()) {
				return rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getFeaturedServerAdress(int id) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT hat_enabled FROM cosmetics WHERE UUID = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery(); */
			ResultSet rs = MySQL.getResult("SELECT * FROM featuredserverlist WHERE id = '" + id + "'");
			while(rs.next()) {
				return rs.getString("adresse");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getCape(UUID uuid) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT cape_enabled FROM cosmetics WHERE UUID = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();*/
			ResultSet rs = MySQL.getResult("SELECT * FROM cosmetics WHERE UUID = '" + uuid + "'");
			while(rs.next()) {
				return rs.getInt("cape_enabled");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public UUID getUuid() {
		return UUID.fromString(uuid);
	}
	
	public static int getGooglyEyes(UUID uuid) {
			try {
				/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT googly_eyes FROM cosmetics WHERE UUID = ?;");
				ps.setString(1, uuid.toString());
				ResultSet rs = ps.executeQuery();*/
				ResultSet rs = MySQL.getResult("SELECT * FROM cosmetics WHERE UUID = '" + uuid + "'");
				while(rs.next()) {
					return rs.getInt("googly_eyes");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	public static String getCapeStyle(UUID uuid) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT cape_style FROM cosmetics WHERE UUID = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();*/
			ResultSet rs = MySQL.getResult("SELECT * FROM cosmetics WHERE UUID = '" + uuid + "'");
			while(rs.next()) {
				return rs.getString("cape_style");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static float[] getTopHatColor(UUID uuid) {
		try {
			/*PreparedStatement ps = MySQL.getConnection().prepareStatement("USE xenor_client; SELECT @var1 := hat_color_r, @var2 := hat_color_g, @var3 := hat_color_b FROM cosmetics WHERE uuid = ?;");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();*/
			ResultSet rs = MySQL.getResult("SELECT @var1 := hat_color_r, @var2 := hat_color_g, @var3 := hat_color_b FROM cosmetics WHERE UUID = '" + uuid + "'");
			while(rs.next()) {
				return new float[] {convert(rs.getInt("@var1 := hat_color_r")), convert(rs.getInt("@var2 := hat_color_g")), convert(rs.getInt("@var3 := hat_color_b"))};
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new float[] {0, 0, 0};
	}
	
	private static float convert(int color) {
		return ( color / 255F );
	}
	
}
