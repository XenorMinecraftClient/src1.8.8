package xenor.event.impl;

import net.minecraft.world.World;
import xenor.event.Event;

public class WorldUnloadEvent extends Event {
	
	private final World world;
	
	public WorldUnloadEvent(World world) {
		this.world = world;
	}
	
	public World getWorld() {
		return world;
	}

}
