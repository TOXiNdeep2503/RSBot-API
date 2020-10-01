package org.powerbot.script.rt4.webwalk.teleport;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Item;

import java.util.regex.Pattern;

public class ItemTeleportStrategy implements TeleportStrategy {

	private final Pattern itemNamePattern;
	private final String action;
	private boolean inEquipment;
	private Item item;

	public ItemTeleportStrategy(final String baseItemName, final String chargePattern, final String action) {
		this.itemNamePattern = Pattern.compile(baseItemName + " " + chargePattern);
		this.action = action;
	}

	@Override
	public boolean teleport(final ClientContext ctx) {
		boolean interacted = false;
		if (inEquipment) {
			interacted = ctx.game.tab(Game.Tab.EQUIPMENT) && item.interact(action);
		} else if (ctx.game.tab(Game.Tab.INVENTORY)) {
			interacted = item.interact(action);
		}
		if (!interacted) {
			return false;
		}
		final Tile start = ctx.players.local().tile();
		return Condition.wait(() -> !ctx.players.local().tile().equals(start), 1500, 4);
	}

	@Override
	public boolean canTeleport(final ClientContext ctx) {
		item = ctx.inventory.select().name(itemNamePattern).poll();
		if (item.valid()) {
			inEquipment = false;
			return true;
		}
		item = ctx.equipment.select().name(itemNamePattern).poll();
		if (item.valid()) {
			inEquipment = true;
			return true;
		}
		return false;
	}
}
