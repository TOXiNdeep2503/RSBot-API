package org.powerbot.script.rt4.webwalk.requests;

import com.google.gson.Gson;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.webwalk.WebNode;

public class ClosestNodeRequest implements Request<WebNode> {

	private final int x, y, z;

	public ClosestNodeRequest(final Locatable locatable) {
		this.x = locatable.tile().x();
		this.y = locatable.tile().y();
		this.z = locatable.tile().floor();
	}

	@Override
	public String getEndpoint() {
		return "/closest_node/?x=" + x + "&y=" + y + "&z=" + z;
	}

	@Override
	public WebNode parseResponse(final String json) {
		return new Gson().fromJson(json, WebNode.class);
	}
}
