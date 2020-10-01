package org.powerbot.script.rt4.webwalk.requests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.powerbot.script.Locatable;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.webwalk.WebPath;

public class PathBetweenRequest implements PostRequest<WebPath> {

	private final int x1, y1, z1;
	private final int x2, y2, z2;

	public PathBetweenRequest(final Locatable source, final Locatable target) {
		final Tile a = source.tile();
		x1 = a.x();
		y1 = a.y();
		z1 = a.floor();

		final Tile b = target.tile();
		x2 = b.x();
		y2 = b.y();
		z2 = b.floor();
	}

	@Override
	public String getEndpoint() {
		return String.format("/path_between/?x1=%d&y1=%d&z1=%d&x2=%d&y2=%d&z2=%d", x1, y1, z1, x2, y2, z2);
	}

	@Override
	public String getPayload(final ClientContext ctx) {
		final JsonObject root = new JsonObject();

		final JsonArray inventory = new JsonArray();
		for (Item item : ctx.inventory.select()) {
			final JsonObject obj = new JsonObject();
			obj.addProperty("name", item.name());
			obj.addProperty("quantity", item.stackSize());
			inventory.add(obj);
		}
		root.add("inventory", inventory);

		final JsonArray equipment = new JsonArray();
		for (Item item : ctx.equipment.select()) {
			equipment.add(item.name());
		}
		root.add("equipment", equipment);

		return new Gson().toJson(root);
	}

	@Override
	public WebPath parseResponse(final String json) {
		return new Gson().fromJson(json, WebPath.class);
	}
}
