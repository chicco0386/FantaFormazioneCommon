package it.zeze.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JSONUtil {

	public <T> T parse(String json, Class<T> obj) {
		T toReturn = null;
		Gson gson = new Gson();
		toReturn = gson.fromJson(json, obj);
		return toReturn;
	}
	
	public class giocatoriQuotazioni {
		private List<List<String>> data = new ArrayList<List<String>>();

		public List<List<String>> getData() {
			return data;
		}

		public void setData(List<List<String>> data) {
			this.data = data;
		}
	}
}
