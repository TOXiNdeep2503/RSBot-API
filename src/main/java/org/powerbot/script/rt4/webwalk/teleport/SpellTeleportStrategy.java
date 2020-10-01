package org.powerbot.script.rt4.webwalk.teleport;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Magic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpellTeleportStrategy implements TeleportStrategy {

	private final Magic.MagicSpell spell;
	private final Map<RuneType, Integer> materials = new HashMap<>();

	public SpellTeleportStrategy(final Magic.MagicSpell spell, final RuneType[] runes, final int[] amounts) {
		this.spell = spell;
		for (int i = 0; i < runes.length; i++) {
			materials.put(runes[i], amounts[i]);
		}
	}

	@Override
	public boolean teleport(final ClientContext ctx) {
		if (!ctx.magic.cast(spell)) {
			return false;
		}
		final Tile start = ctx.players.local().tile();
		return Condition.wait(() -> !ctx.players.local().tile().equals(start), 1500, 4);
	}

	@Override
	public boolean canTeleport(final ClientContext ctx) {
		if (ctx.magic.book() != spell.book() || ctx.skills.realLevel(Constants.SKILLS_MAGIC) < spell.level()) {
			return false;
		}
		return materials.entrySet().stream().allMatch(mat -> hasRuneFor(ctx, mat) || hasStaffFor(ctx, mat));
	}

	private boolean hasRuneFor(final ClientContext ctx, final Map.Entry<RuneType, Integer> material) {
		return ctx.inventory.select().name(material.getKey().getNames()).count(true) >= material.getValue();
	}

	private boolean hasStaffFor(final ClientContext ctx, final Map.Entry<RuneType, Integer> material) {
		return ctx.equipment.select().select(item -> {
			String itemName = item.name().toLowerCase();
			if (!itemName.contains("staff")) {
				return false;
			}
			return Arrays.stream(material.getKey().getNames()).anyMatch(name -> itemName.contains(name.toLowerCase()));
		}).count() > 0;
	}
}
