package xenor.event.impl;

import xenor.event.Event;

public class MotionUpdate extends Event {
	   private double x;
	   private double y;
	   private double z;
	   private double minBoundingBox;
	   private float yaw;
	   private float pitch;
	   private boolean ground;

	   public MotionUpdate(double x, double minBoundingBox, double y, double z, float yaw, float pitch, boolean ground) {
	      this.x = x;
	      this.y = y;
	      this.z = z;
	      this.minBoundingBox = minBoundingBox;
	      this.yaw = yaw;
	      this.pitch = pitch;
	      this.ground = ground;
	   }

	   public double getMinBoundingBox() {
	      return this.minBoundingBox;
	   }

	   public double getX() {
	      return this.x;
	   }

	   public double getY() {
	      return this.y;
	   }

	   public double getZ() {
	      return this.z;
	   }

	   public float getYaw() {
	      return this.yaw;
	   }

	   public float getPitch() {
	      return this.pitch;
	   }

	   public boolean isOnGround() {
	      return this.ground;
	   }
	}