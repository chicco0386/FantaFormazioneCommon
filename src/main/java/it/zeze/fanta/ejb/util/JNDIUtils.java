package it.zeze.fanta.ejb.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.zeze.fanta.service.definition.ejb.CalendarioRemote;
import it.zeze.fanta.service.definition.ejb.FormazioniFGRemote;
import it.zeze.fanta.service.definition.ejb.FormazioniGazzettaRemote;
import it.zeze.fanta.service.definition.ejb.GiocatoriRemote;
import it.zeze.fanta.service.definition.ejb.GiornateRemote;
import it.zeze.fanta.service.definition.ejb.SquadreRemote;
import it.zeze.fanta.service.definition.ejb.StatisticheRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.GiocatoriSeamRemote;

public class JNDIUtils {

	private static InitialContext ic = null;

	static {
		try {
			// Get the Initial Context for the JNDI lookup for a local EJB
			ic = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static <T> T lookupEjb(String ejbName, Class<T> ejbInterface) throws NamingException {
		// Retrieve the Home interface using JNDI lookup
		return (T) ic.lookup("java:global/FantaFormazioneEAR/FantaWebService-0.0.1-SNAPSHOT/" + ejbName + "!" + ejbInterface.getName());
	}

	public static <T> T getCalendarioEJB() throws NamingException {
		return (T) lookupEjb("CalendarioEJB", CalendarioRemote.class);
	}
	
	public static <T> T getGiornateEJB() throws NamingException {
		return (T) lookupEjb("GiornateEJB", GiornateRemote.class);
	}
	
	public static <T> T getGiocatoriEJB() throws NamingException {
		return (T) lookupEjb("GiocatoriEJB", GiocatoriRemote.class);
	}
	
	public static <T> T getGiocatoriSeamEJB() throws NamingException {
		return (T) lookupEjb("GiocatoriSeamEJB", GiocatoriSeamRemote.class);
	}
	
	public static <T> T getFormazioniFGEJB() throws NamingException {
		return (T) lookupEjb("FormazioniFGEJB", FormazioniFGRemote.class);
	}
	
	public static <T> T getFormazioniGazzettaEJB() throws NamingException {
		return (T) lookupEjb("FormazioniGazzettaEJB", FormazioniGazzettaRemote.class);
	}
	
	public static <T> T getSquadreEJB() throws NamingException {
		return (T) lookupEjb("SquadreEJB", SquadreRemote.class);
	}
	
	public static <T> T getStatisticheEJB() throws NamingException {
		return (T) lookupEjb("StatisticheEJB", StatisticheRemote.class);
	}

}
