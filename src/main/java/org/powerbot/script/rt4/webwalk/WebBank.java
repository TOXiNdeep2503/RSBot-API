package org.powerbot.script.rt4.webwalk;

import org.powerbot.script.Tile;

public enum WebBank {
	AL_KHARID(3269, 3167, false),
	CANIFIS(3512, 3479, true),
	CAMELOT(2726, 3492, true),
	CASTLE_WARS(2442, 3085, true),
	DUEL_ARENA(3382, 3267, false),
	LUNAR_ISLE(2100, 3918, true),
	DRAYNOR_VILLAGE(3092, 3245, false),
	EDGEVILLE(3096, 3494, false),
	GRAND_EXCHANGE(3167, 3488, false),
	LUMBRIDGE(3208, 3220, 2, false),
	FALADOR_EAST(3012, 3356, false),
	FALADOR_WEST(2946, 3368, false),
	SEERS_VILLAGE(2727, 3493, true),
	CATHERBY(2809, 3441, true),
	VARROCK_WEST(3185, 3436, false),
	VARROCK_EAST(3253, 3420, false),
	ARDOUGNE_NORTH(2617, 3333, true),
	ARDOUGNE_SOUTH(2653, 3284, true),
	YANILLE(2612, 3092, true),
	SHANTAY(3307, 3120, true),
	VOID_OUPOST(2666, 2643, true),
	HOSIDIUS(1748, 3599, true),
	PORT_PISCARILIUS(1804, 3790, true);
	
	private final Tile tile;
	private final boolean members;

	WebBank(final int x, final int y, final boolean members) {
		this(x, y, 0, members);
	}

	WebBank(final int x, final int y, final int z, final boolean members) {
		this.tile = new Tile(x, y, z);
		this.members = members;
	}

	public Tile getTile() {
		return tile;
	}

	public boolean isMembers() {
		return members;
	}
}
