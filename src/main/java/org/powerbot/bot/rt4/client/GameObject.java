package org.powerbot.bot.rt4.client;

import org.powerbot.bot.*;

public class GameObject extends BasicObject {
	private static final Reflector.FieldCache a = new Reflector.FieldCache(),
			b = new Reflector.FieldCache(),
			c = new Reflector.FieldCache(),
			d = new Reflector.FieldCache(),
			e = new Reflector.FieldCache(),
			f = new Reflector.FieldCache(),
			g = new Reflector.FieldCache(),
		h = new Reflector.FieldCache(),
	i = new Reflector.FieldCache();

	public GameObject(final Reflector engine, final Object parent) {
		super(engine, parent);
	}

	@Override
	public long getUid() {
		return reflector.accessLong(this, a);
	}

	@Override
	public int getMeta() {
		return reflector.accessInt(this, b);
	}

	@Override
	public int getX() {
		return reflector.accessInt(this, c);
	}

	@Override
	public int getZ() {
		return reflector.accessInt(this, d);
	}

	@Override
	public int getX1() {
		return reflector.accessInt(this, e);
	}

	@Override
	public int getY1() {
		return reflector.accessInt(this, f);
	}

	@Override
	public int getX2() {
		return reflector.accessInt(this, g);
	}

	@Override
	public int getY2() {
		return reflector.accessInt(this, h);
	}
}
