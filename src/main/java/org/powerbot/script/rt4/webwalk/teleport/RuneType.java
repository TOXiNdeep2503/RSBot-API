package org.powerbot.script.rt4.webwalk.teleport;

public enum RuneType {
	AIR("Air", "Smoke", "Mist", "Dust"),
	EARTH("Earth", "Lava", "Mud", "Dust"),
	FIRE("Fire", "Lava", "Smoke", "Steam"),
	WATER("Water", "Mud", "Steam", "Mist"),
	LAW("Law"),
	NATURE("Nature"),
	SOUL("Soul");

	private final String[] names;

	RuneType(final String... names) {
		this.names = names;
	}

	public String[] getNames() {
		return names;
	}
}
