package it.zeze.util;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;

public class JSONClient {

	private static ResteasyClient client = new ResteasyClientBuilder().build();

	public String callJsonService(String url) {
		String toReturn = null;
		Response response = null;
		try {
			ResteasyWebTarget target = client.target(url);
			response = target.request().get();
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			toReturn = response.readEntity(String.class);

		} finally {
			if (response != null) {
				response.close();
			}
		}
		return toReturn;
	}
	
	public <T> T callJsonService(String url, Class<T> obj) {
		T toReturn = null;
		Response response = null;
		try {
			ResteasyWebTarget target = client.target(url);
			response = target.request().get();
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			Gson gson = new Gson();
			toReturn = gson.fromJson(response.readEntity(String.class), obj);

		} finally {
			if (response != null) {
				response.close();
			}
		}
		return toReturn;
	}
}
