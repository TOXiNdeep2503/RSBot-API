package org.powerbot.script.rt4.webwalk.teleport;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Item;

public class TabletTeleportStrategy implements TeleportStrategy {

	private final String destinationName;
	private Item item;

	public TabletTeleportStrategy(final String destinationName) {
		this.destinationName = destinationName;
	}

	@Override
	public boolean teleport(final ClientContext ctx) {
		if (!ctx.game.tab(Game.Tab.INVENTORY)) {
			return false;
		}
		if (!item.interact("Break")) {
			return false;
		}
		final Tile start = ctx.players.local().tile();
		return Condition.wait(() -> !ctx.players.local().tile().equals(start), 1500, 4);
	}

	@Override
	public boolean canTeleport(final ClientContext ctx) {
		return (item = ctx.inventory.select().name(destinationName + " teleport").poll()).valid();
	}
}
