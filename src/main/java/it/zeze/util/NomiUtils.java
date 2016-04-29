package it.zeze.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class NomiUtils {
	
	private static Map<String, String> specialChars = new HashMap<String, String>();
	
	static {
		if (specialChars.isEmpty()){
			specialChars.put("'", "");
			specialChars.put("ò", "o");
			specialChars.put("à", "a");
			specialChars.put("ù", "u");
			specialChars.put("è", "e");
			specialChars.put("é", "e");
			specialChars.put("ì", "i");
		}
	}
	
	public static String pulisciNome(String nome){
		String toReturn = nome.trim();
		Iterator<String> itKey = specialChars.keySet().iterator();
		String currentKey;
		while (itKey.hasNext()){
			currentKey = itKey.next();
			if (toReturn.toLowerCase().contains(currentKey)){
				toReturn = StringUtils.replaceChars(toReturn, currentKey, specialChars.get(currentKey));
			}
		}
		toReturn = StringUtils.capitalize(toReturn.toLowerCase());
		return toReturn;
	}

}
