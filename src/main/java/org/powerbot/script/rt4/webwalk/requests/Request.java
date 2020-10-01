package org.powerbot.script.rt4.webwalk.requests;

public interface Request<T> {

	String getEndpoint();

	T parseResponse(final String json);
}
