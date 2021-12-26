package xenor.event.impl;

import net.minecraft.network.Packet;
import xenor.event.Event;

public final class EventPacketReceive extends Event {
	
    private final Packet packet;

    public EventPacketReceive(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }
}
