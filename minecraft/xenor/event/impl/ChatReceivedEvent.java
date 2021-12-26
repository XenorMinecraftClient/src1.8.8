package xenor.event.impl;

import java.util.List;

import net.minecraft.util.IChatComponent;
import xenor.event.Event;

public class ChatReceivedEvent extends Event {
	   private IChatComponent component;
	   private List chatLines;

	   public ChatReceivedEvent(IChatComponent component, List chatLines) {
	      this.component = component;
	      this.chatLines = chatLines;
	   }

	   public IChatComponent getComponent() {
	      return this.component;
	   }

	   public List getChatLines() {
	      return this.chatLines;
	   }
	}