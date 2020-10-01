package org.powerbot.script.rt4.webwalk.requests;

import org.powerbot.script.rt4.ClientContext;

public interface PostRequest<T> extends Request<T> {

	String getPayload(final ClientContext ctx);
}
