
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import it.zeze.util.JSONClient;

public class TestJSON {

	public static void main(String[] args) {
		JSONClient json = new JSONClient();

		JsonObj response = json.callJsonService("http://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/milano/portieri_199390156547.txt", JsonObj.class);
		printResponse(response);
		response = json.callJsonService("http://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/milano/difensori_199390156547.txt", JsonObj.class);
		printResponse(response);
		response = json.callJsonService("http://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/milano/centrocampisti_199390156547.txt", JsonObj.class);
		printResponse(response);
		response = json.callJsonService("http://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/milano/attaccanti_199390156547.txt", JsonObj.class);
		printResponse(response);
	}

	private static void printResponse(JsonObj toPrint) {
		String currentGiocatoreSquadra;
		String currentNomeGiocatore;
		String currentSquadra;
		for (List<String> currentGiocatore : toPrint.getData()) {
			currentGiocatoreSquadra = currentGiocatore.get(0);
			currentNomeGiocatore = StringUtils.substringBefore(currentGiocatoreSquadra, "(").trim();
			currentSquadra = StringUtils.substringBetween(currentGiocatoreSquadra, "(", ")").trim();
			System.out.println("[" + currentSquadra + "] " + currentNomeGiocatore + " - " + currentGiocatore.get(1) + " - " + currentGiocatore.get(2));
		}
	}

	public class JsonObj {
		private List<List<String>> data = new ArrayList<List<String>>();

		public List<List<String>> getData() {
			return data;
		}

		public void setData(List<List<String>> data) {
			this.data = data;
		}
	}

}
