package xenor.http.gsonobjs;

import java.util.UUID;

public class ObjUserCosmetics {
	
	private String uuid;
	
	private String cape_style;
	private Hat hat;
	private int googly_eyes;
	private int halo;
	
	public class Hat {
		private int enabled;
		private int r;
		private int g;
		private int b;
		
		public boolean isEnabled() {
			return enabled == 1;
		}
		
		public float[] getColor() {
			return new float[] {convert(r), convert(g), convert(b)};
		}
		
		private float convert(int color) {
			return ( color / 255F );
		}
	}
	
	public Hat getHat() {
		return hat;
	}
	
	public UUID getUuid() {
		return UUID.fromString(uuid);
	}
	
	public boolean hasCape() {
		return cape_style != null;
	}
	
	public boolean isGooglyEyesEnabled() {
		return googly_eyes == 1;
	}
	
	public String getCapeStyle() {
		return cape_style;
	}
	
}
