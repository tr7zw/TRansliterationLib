package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;

public class TRLArm implements Arm {

	public static final Arm LEFT = new TRLArm(net.minecraft.util.Arm.LEFT);
	public static final Arm RIGHT = new TRLArm(net.minecraft.util.Arm.RIGHT);

	private final net.minecraft.util.Arm handle;

	private TRLArm(net.minecraft.util.Arm arm) {
		handle = arm;
	}

	@Override
	public Arm getLeft() {
		return LEFT;
	}

	@Override
	public Arm getRight() {
		return RIGHT;
	}

	@Override
	public Object getHandler() {
		return handle;
	}

	@Override
	public <H> H getHandler(Class<H> clazz) {
		return (H) handle;
	}

	@Override
	public Arm of(Object val) {
		if (val == net.minecraft.util.Arm.LEFT) {
			return LEFT;
		} else {
			return RIGHT;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((handle == null) ? 0 : handle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TRLArm other = (TRLArm) obj;
		if (handle != other.handle)
			return false;
		return true;
	}

}
