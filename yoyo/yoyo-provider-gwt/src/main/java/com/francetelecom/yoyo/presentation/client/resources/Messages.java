package com.francetelecom.yoyo.presentation.client.resources;

/**
 * Interface to represent the messages contained in resource bundle:
 * E:/developpement
 * /workspace/gwt/yoyo/yoyo-provider-gwt/src/main/java/com/
 * francetelecom/yoyo/presentation/client/resources/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {

	/**
	 * Translated "voulez-vous supprimer le marché {0} ?".
	 * 
	 * @return translated "voulez-vous supprimer le marché {0} ?"
	 */
	@DefaultMessage("voulez-vous supprimer le marché {0} ?")
	@Key("deleteMarketPage.confirm")
	String deleteMarketPage_confirm(String arg0);

	/**
	 * Translated "le marché {0} a été créé".
	 * 
	 * @return translated "le marché {0} a été créé"
	 */
	@DefaultMessage("le marché {0} a été créé")
	@Key("info.marketCreated")
	String info_marketCreated(String arg0);

	/**
	 * Translated "le marché {0} a été supprimé".
	 * 
	 * @return translated "le marché {0} a été supprimé"
	 */
	@DefaultMessage("le marché {0} a été supprimé")
	@Key("info.marketDeleted")
	String info_marketDeleted(String arg0);

	/**
	 * Translated "le marché {0} a été modifié".
	 * 
	 * @return translated "le marché {0} a été modifié"
	 */
	@DefaultMessage("le marché {0} a été modifié")
	@Key("info.marketUpdated")
	String info_marketUpdated(String arg0);

	/**
	 * Translated "{0} enregistrements trouvés".
	 * 
	 * @return translated "{0} enregistrements trouvés"
	 */
	@DefaultMessage("{0} enregistrements trouvés")
	@Key("list.counter")
	String list_counter(String arg0);

	/**
	 * Translated "aucun enregistrement trouvé".
	 * 
	 * @return translated "aucun enregistrement trouvé"
	 */
	@DefaultMessage("aucun enregistrement trouvé")
	@Key("list.counter.none")
	String list_counter_none();

	/**
	 * Translated "1 enregistrement trouvé".
	 * 
	 * @return translated "1 enregistrement trouvé"
	 */
	@DefaultMessage("1 enregistrement trouvé")
	@Key("list.counter[one]")
	String list_counter_one_();

	/**
	 * Translated "${parent.artifactId}".
	 * 
	 * @return translated "${parent.artifactId}"
	 */
	@DefaultMessage("${parent.artifactId}")
	@Key("title.main")
	String title_main();

	/**
	 * Translated "le marché {0} existe déjà".
	 * 
	 * @return translated "le marché {0} existe déjà"
	 */
	@DefaultMessage("le marché {0} existe déjà")
	@Key("warning.marketAlreadyExists")
	String warning_marketAlreadyExists(String arg0);

	/**
	 * Translated "le marché {0} n existe pas".
	 * 
	 * @return translated "le marché {0} n existe pas"
	 */
	@DefaultMessage("le marché {0} n existe pas")
	@Key("warning.marketDoesNotExist")
	String warning_marketDoesNotExist(String arg0);
}
