package org.powerbot.script.rt4.webwalk.teleport;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Magic;

public enum TeleportType {
	VARROCK_TAB(new Tile(3212, 3424, 0), new TabletTeleportStrategy("Varrock")),
	FALADOR_TAB(new Tile(2966, 3379, 0), new TabletTeleportStrategy("Falador")),
	LUMBRIDGE_TAB(new Tile(3225, 3219, 0), new TabletTeleportStrategy("Lumbridge")),
	CAMELOT_TAB(new Tile(2757, 3479, 0), new TabletTeleportStrategy("Camelot")),
	ARDOUGNE_TAB(new Tile(2661, 3300, 0), new TabletTeleportStrategy("Ardougne")),
	RIMMINGTON_TAB(new Tile(2954, 3224, 0), new TabletTeleportStrategy("Rimmington")),
	TAVERLY_TAB(new Tile(2894, 3465, 0), new TabletTeleportStrategy("Taverly")),
	YANILLE_TAB(new Tile(2544, 3095, 0), new TabletTeleportStrategy("Yanille")),
	RELLEKKA_TAB(new Tile(2668, 3631, 0), new TabletTeleportStrategy("Rellekka")),
	POLLNIVNEACH_TAB(new Tile(3340, 3004, 0), new TabletTeleportStrategy("Pollnivneach")),
	WEST_ARDOUGNE_TAB(new Tile(2500, 3290, 0), new TabletTeleportStrategy("West ardougne")),
	BRIMHAVEN_TAB(new Tile(2758, 3178, 0), new TabletTeleportStrategy("Brimhaven")),
	HOSIDIUS_TAB(new Tile(1744, 3517, 0), new TabletTeleportStrategy("Hosidius")),

	VARROCK_SPELL(VARROCK_TAB.getDestination(), new SpellTeleportStrategy(Magic.Spell.VARROCK_TELEPORT, new RuneType[]{ RuneType.LAW, RuneType.AIR, RuneType.FIRE}, new int[]{ 1, 3, 1 })),
	FALADOR_SPELL(FALADOR_TAB.getDestination(), new SpellTeleportStrategy(Magic.Spell.FALADOR_TELEPORT, new RuneType[]{ RuneType.LAW, RuneType.AIR, RuneType.WATER}, new int[]{ 1, 3, 1 })),
	LUMBRIDGE_SPELL(LUMBRIDGE_TAB.getDestination(), new SpellTeleportStrategy(Magic.Spell.LUMBRIDGE_TELEPORT, new RuneType[]{ RuneType.LAW, RuneType.AIR, RuneType.EARTH}, new int[]{ 1, 3, 1 })),
	CAMELOT_SPELL(CAMELOT_TAB.getDestination(), new SpellTeleportStrategy(Magic.Spell.CAMELOT_TELEPORT, new RuneType[]{ RuneType.LAW, RuneType.AIR }, new int[]{ 1, 5 })),
	ARDOUGNE_SPELL(ARDOUGNE_TAB.getDestination(), new SpellTeleportStrategy(Magic.Spell.ARDOUGNE_TELEPORT, new RuneType[]{ RuneType.LAW, RuneType.WATER }, new int[]{ 2, 2 })),

	RING_OF_DUELLING_CASTLE_WARS(new Tile(2440, 3090, 0), new ItemTeleportStrategy("Ring of Duelling", "([1-8])", "Castle Wars")),
	RING_OF_DUELLING_FEROX_ENCLAVE(new Tile(3151, 3634, 0), new ItemTeleportStrategy("Ring of Duelling", "([1-8])", "Ferox Enclave")),
	RING_OF_DUELLING_DUEL_ARENA(new Tile(3313, 3233, 0), new ItemTeleportStrategy("Ring of Duelling", "([1-8])", "Duel Arena"));

	private final Tile destination;
	private final TeleportStrategy strategy;

	TeleportType(final Tile destination, final TeleportStrategy strategy) {
		this.destination = destination;
		this.strategy = strategy;
	}
	
	public Tile getDestination() {
		return destination;
	}

	public TeleportStrategy getStrategy() {
		return strategy;
	}
}
