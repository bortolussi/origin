package com.francetelecom.yoyo.presentation.client.resources;

/**
 * Interface to represent the constants contained in resource bundle:
 * 'src/main/java/com/francetelecom/yoyo/presentation/client/resources/Constantes.properties'
 * .
 */
public interface Constantes extends com.google.gwt.i18n.client.Constants {

	/**
	 * Translated "GWTApplication".
	 * 
	 * @return translated "GWTApplication"
	 */
	@DefaultStringValue("GWTApplication")
	@Key("ClassName")
	String ClassName();

	/**
	 * Translated "<< Retour".
	 * 
	 * @return translated "<< Retour"
	 */
	@DefaultStringValue("<< Retour")
	@Key("button.back")
	String button_back();

	/**
	 * Translated "Annuler".
	 * 
	 * @return translated "Annuler"
	 */
	@DefaultStringValue("Annuler")
	@Key("button.cancel")
	String button_cancel();

	/**
	 * Translated "Fermer".
	 * 
	 * @return translated "Fermer"
	 */
	@DefaultStringValue("Fermer")
	@Key("button.close")
	String button_close();

	/**
	 * Translated "Créer".
	 * 
	 * @return translated "Créer"
	 */
	@DefaultStringValue("Créer")
	@Key("button.create")
	String button_create();

	/**
	 * Translated "Supprimer".
	 * 
	 * @return translated "Supprimer"
	 */
	@DefaultStringValue("Supprimer")
	@Key("button.delete")
	String button_delete();

	/**
	 * Translated "Détails".
	 * 
	 * @return translated "Détails"
	 */
	@DefaultStringValue("Détails")
	@Key("button.detail")
	String button_detail();

	/**
	 * Translated "Télécharger".
	 * 
	 * @return translated "Télécharger"
	 */
	@DefaultStringValue("Télécharger")
	@Key("button.download")
	String button_download();

	/**
	 * Translated "Editer".
	 * 
	 * @return translated "Editer"
	 */
	@DefaultStringValue("Editer")
	@Key("button.edit")
	String button_edit();

	/**
	 * Translated "Valider".
	 * 
	 * @return translated "Valider"
	 */
	@DefaultStringValue("Valider")
	@Key("button.ok")
	String button_ok();

	/**
	 * Translated "Précédent".
	 * 
	 * @return translated "Précédent"
	 */
	@DefaultStringValue("Précédent")
	@Key("button.previous")
	String button_previous();

	/**
	 * Translated "Rechercher".
	 * 
	 * @return translated "Rechercher"
	 */
	@DefaultStringValue("Rechercher")
	@Key("button.search")
	String button_search();

	/**
	 * Translated "Modifier".
	 * 
	 * @return translated "Modifier"
	 */
	@DefaultStringValue("Modifier")
	@Key("button.update")
	String button_update();

	/**
	 * Translated "description".
	 * 
	 * @return translated "description"
	 */
	@DefaultStringValue("description")
	@Key("column.marketDescription")
	String column_marketDescription();

	/**
	 * Translated "id".
	 * 
	 * @return translated "id"
	 */
	@DefaultStringValue("id")
	@Key("column.marketId")
	String column_marketId();

	/**
	 * Translated "nom".
	 * 
	 * @return translated "nom"
	 */
	@DefaultStringValue("nom")
	@Key("column.marketName")
	String column_marketName();

	/**
	 * Translated "saisie des données".
	 * 
	 * @return translated "saisie des données"
	 */
	@DefaultStringValue("saisie des données")
	@Key("createMarketPage.form")
	String createMarketPage_form();

	/**
	 * Translated "création d'un marché".
	 * 
	 * @return translated "création d'un marché"
	 */
	@DefaultStringValue("création d'un marché")
	@Key("createMarketPage.title")
	String createMarketPage_title();

	/**
	 * Translated "dd/MM/yyyy".
	 * 
	 * @return translated "dd/MM/yyyy"
	 */
	@DefaultStringValue("dd/MM/yyyy")
	@Key("datePattern")
	String datePattern();

	/**
	 * Translated "dd/MM/yyyy HH:mm:ss".
	 * 
	 * @return translated "dd/MM/yyyy HH:mm:ss"
	 */
	@DefaultStringValue("dd/MM/yyyy HH:mm:ss")
	@Key("dateTimePattern")
	String dateTimePattern();

	/**
	 * Translated "suppression d'un marché".
	 * 
	 * @return translated "suppression d'un marché"
	 */
	@DefaultStringValue("suppression d'un marché")
	@Key("deleteMarketPage.title")
	String deleteMarketPage_title();

	/**
	 * Translated
	 * "Vous allez annuler vos modifications, désirez-vous continuer ?".
	 * 
	 * @return translated
	 *         "Vous allez annuler vos modifications, désirez-vous continuer ?"
	 */
	@DefaultStringValue("Vous allez annuler vos modifications, désirez-vous continuer ?")
	@Key("edit.cancel.confirm")
	String edit_cancel_confirm();

	/**
	 * Translated "Accès non autorisé".
	 * 
	 * @return translated "Accès non autorisé"
	 */
	@DefaultStringValue("Accès non autorisé")
	@Key("error.access.denied")
	String error_access_denied();

	/**
	 * Translated "Ce marché a été supprimé par un autre utilisateur".
	 * 
	 * @return translated
	 *         "Ce marché a été supprimé par un autre utilisateur"
	 */
	@DefaultStringValue("Ce marché a été supprimé par un autre utilisateur")
	@Key("error.deletion")
	String error_deletion();

	/**
	 * Translated "Une erreur technique est survenue".
	 * 
	 * @return translated "Une erreur technique est survenue"
	 */
	@DefaultStringValue("Une erreur technique est survenue")
	@Key("error.internal")
	String error_internal();

	/**
	 * Translated "Ce marché a été modifié par un autre utilisateur".
	 * 
	 * @return translated "Ce marché a été modifié par un autre utilisateur"
	 */
	@DefaultStringValue("Ce marché a été modifié par un autre utilisateur")
	@Key("error.optimisticlock")
	String error_optimisticlock();

	/**
	 * Translated "Votre session est expirée, veuillez vous reconnecter".
	 * 
	 * @return translated
	 *         "Votre session est expirée, veuillez vous reconnecter"
	 */
	@DefaultStringValue("Votre session est expirée, veuillez vous reconnecter")
	@Key("error.timeout")
	String error_timeout();

	/**
	 * Translated "description".
	 * 
	 * @return translated "description"
	 */
	@DefaultStringValue("description")
	@Key("field.description")
	String field_description();

	/**
	 * Translated "nom du marché".
	 * 
	 * @return translated "nom du marché"
	 */
	@DefaultStringValue("nom du marché")
	@Key("field.name")
	String field_name();

	/**
	 * Translated "nom du marché".
	 * 
	 * @return translated "nom du marché"
	 */
	@DefaultStringValue("nom du marché")
	@Key("field.searchMarketName")
	String field_searchMarketName();

	/**
	 * Translated "France Telecom 2011 &copy;".
	 * 
	 * @return translated "France Telecom 2011 &copy;"
	 */
	@DefaultStringValue("France Telecom 2011 &copy;")
	@Key("footer.copyright")
	String footer_copyright();

	/**
	 * Translated "utilisateur".
	 * 
	 * @return translated "utilisateur"
	 */
	@DefaultStringValue("utilisateur")
	@Key("footer.user.name")
	String footer_user_name();

	/**
	 * Translated "profil".
	 * 
	 * @return translated "profil"
	 */
	@DefaultStringValue("profil")
	@Key("footer.user.profile")
	String footer_user_profile();

	/**
	 * Translated "version ${project.version}".
	 * 
	 * @return translated "version ${project.version}"
	 */
	@DefaultStringValue("version ${project.version}")
	@Key("footer.version")
	String footer_version();

	/**
	 * Translated "anglais".
	 * 
	 * @return translated "anglais"
	 */
	@DefaultStringValue("anglais")
	@Key("header.english")
	String header_english();

	/**
	 * Translated "français".
	 * 
	 * @return translated "français"
	 */
	@DefaultStringValue("français")
	@Key("header.french")
	String header_french();

	/**
	 * Translated "bonjour".
	 * 
	 * @return translated "bonjour"
	 */
	@DefaultStringValue("bonjour")
	@Key("header.hello")
	String header_hello();

	/**
	 * Translated "aide (nouvelle fenêtre)".
	 * 
	 * @return translated "aide (nouvelle fenêtre)"
	 */
	@DefaultStringValue("aide (nouvelle fenêtre)")
	@Key("header.help")
	String header_help();

	/**
	 * Translated "accueil".
	 * 
	 * @return translated "accueil"
	 */
	@DefaultStringValue("accueil")
	@Key("header.home")
	String header_home();

	/**
	 * Translated "information".
	 * 
	 * @return translated "information"
	 */
	@DefaultStringValue("information")
	@Key("header.information")
	String header_information();

	/**
	 * Translated "se déconnecter".
	 * 
	 * @return translated "se déconnecter"
	 */
	@DefaultStringValue("se déconnecter")
	@Key("header.logout")
	String header_logout();

	/**
	 * Translated "mailto:xxx.yyy@orange-ftgroup.com".
	 * 
	 * @return translated "mailto:xxx.yyy@orange-ftgroup.com"
	 */
	@DefaultStringValue("mailto:xxx.yyy@orange-ftgroup.com")
	@Key("header.mailaddress")
	String header_mailaddress();

	/**
	 * Translated "imprimer".
	 * 
	 * @return translated "imprimer"
	 */
	@DefaultStringValue("imprimer")
	@Key("header.print")
	String header_print();

	/**
	 * Translated "écrivez-nous".
	 * 
	 * @return translated "écrivez-nous"
	 */
	@DefaultStringValue("écrivez-nous")
	@Key("header.writeus")
	String header_writeus();

	/**
	 * Translated "Cette application a été créée à partir de l'archetype
	 * <b>orange-archetype-GWT-jpa</b>. Elle peut servir de point de départ à
	 * tout projet mettant en oeuvre les technologies préconisées
	 * suivantes&nbsp;:
	 * <ul>
	 * <li>Maven</li>
	 * <li>Hibernate JPA</li>
	 * <li>Spring</li>
	 * <li>GWT</li>
	 * </ul>
	 * <br/>
	 * L'onglet marché propose un exemple de gestion d'une entité (méthodes
	 * CRUD), à l'aide de fonctions simples ou avancées de GWT.".
	 * 
	 * @return translated "Cette application a été créée à partir de
	 *         l'archetype <b>orange-archetype-GWT-jpa</b>. Elle peut servir de
	 *         point de départ à tout projet mettant en oeuvre les
	 *         technologies préconisées suivantes&nbsp;:
	 *         <ul>
	 *         <li>Maven</li>
	 *         <li>Hibernate JPA</li>
	 *         <li>Spring</li>
	 *         <li>GWT</li>
	 *         </ul>
	 * <br/>
	 *         L'onglet marché propose un exemple de gestion d'une entité
	 *         (méthodes CRUD), à l'aide de fonctions simples ou avancées de
	 *         GWT."
	 */
	@DefaultStringValue("Cette application a été créée à partir de l'archetype <b>orange-archetype-GWT-jpa</b>. Elle peut servir de point de départ à tout projet mettant en oeuvre les technologies préconisées suivantes&nbsp;:<ul><li>Maven</li><li>Hibernate JPA</li><li>Spring</li><li>GWT</li></ul><br/>L'onglet marché propose un exemple de gestion d'une entité (méthodes CRUD), à l'aide de fonctions simples ou avancées de GWT.")
	@Key("homePage.content")
	String homePage_content();

	/**
	 * Translated "présentation".
	 * 
	 * @return translated "présentation"
	 */
	@DefaultStringValue("présentation")
	@Key("homePage.title")
	String homePage_title();

	/**
	 * Translated "accueil".
	 * 
	 * @return translated "accueil"
	 */
	@DefaultStringValue("accueil")
	@Key("homeTab")
	String homeTab();

	/**
	 * Translated "(contient)".
	 * 
	 * @return translated "(contient)"
	 */
	@DefaultStringValue("(contient)")
	@Key("includes")
	String includes();

	/**
	 * Translated "Vous allez quitter l'application, désirez-vous continuer ?".
	 * 
	 * @return translated
	 *         "Vous allez quitter l'application, désirez-vous continuer ?"
	 */
	@DefaultStringValue("Vous allez quitter l'application, désirez-vous continuer ?")
	@Key("logout.confirm")
	String logout_confirm();

	/**
	 * Translated ": champ obligatoire".
	 * 
	 * @return translated ": champ obligatoire"
	 */
	@DefaultStringValue(": champ obligatoire")
	@Key("mandatory")
	String mandatory();

	/**
	 * Translated "vous pouvez ajouter un nouveau marché".
	 * 
	 * @return translated "vous pouvez ajouter un nouveau marché"
	 */
	@DefaultStringValue("vous pouvez ajouter un nouveau marché")
	@Key("marketPage.create")
	String marketPage_create();

	/**
	 * Translated "visualisation d'un marché".
	 * 
	 * @return translated "visualisation d'un marché"
	 */
	@DefaultStringValue("visualisation d'un marché")
	@Key("marketPage.details")
	String marketPage_details();

	/**
	 * Translated "sur".
	 * 
	 * @return translated "sur"
	 */
	@DefaultStringValue("sur")
	@Key("marketPage.pager")
	String marketPage_pager();

	/**
	 * Translated "liste des résultats trouvés".
	 * 
	 * @return translated "liste des résultats trouvés"
	 */
	@DefaultStringValue("liste des résultats trouvés")
	@Key("marketPage.result")
	String marketPage_result();

	/**
	 * Translated "vous pouvez choisir un critère de recherche".
	 * 
	 * @return translated "vous pouvez choisir un critère de recherche"
	 */
	@DefaultStringValue("vous pouvez choisir un critère de recherche")
	@Key("marketPage.search")
	String marketPage_search();

	/**
	 * Translated "gestion des marchés".
	 * 
	 * @return translated "gestion des marchés"
	 */
	@DefaultStringValue("gestion des marchés")
	@Key("marketPage.title")
	String marketPage_title();

	/**
	 * Translated "marché".
	 * 
	 * @return translated "marché"
	 */
	@DefaultStringValue("marché")
	@Key("marketTab")
	String marketTab();

	/**
	 * Translated
	 * "le champ 'nom du marché' est obligatoire (doit contenir au minimum 5 caractères)"
	 * .
	 * 
	 * @return translated
	 *         "le champ 'nom du marché' est obligatoire (doit contenir au minimum 5 caractères)"
	 */
	@DefaultStringValue("le champ 'nom du marché' est obligatoire (doit contenir au minimum 5 caractères)")
	@Key("name.Required")
	String name_Required();

	/**
	 * Translated "non trouvé".
	 * 
	 * @return translated "non trouvé"
	 */
	@DefaultStringValue("non trouvé")
	@Key("not.found")
	String not_found();

	/**
	 * Translated "onglets".
	 * 
	 * @return translated "onglets"
	 */
	@DefaultStringValue("onglets")
	@Key("tabs")
	String tabs();

	/**
	 * Translated "information".
	 * 
	 * @return translated "information"
	 */
	@DefaultStringValue("information")
	@Key("title.defaultTab")
	String title_defaultTab();

	/**
	 * Translated "page d'erreur".
	 * 
	 * @return translated "page d'erreur"
	 */
	@DefaultStringValue("page d'erreur")
	@Key("title.error")
	String title_error();

	/**
	 * Translated "bienvenue".
	 * 
	 * @return translated "bienvenue"
	 */
	@DefaultStringValue("bienvenue")
	@Key("title.homeTab")
	String title_homeTab();

	/**
	 * Translated "gestion des marchés".
	 * 
	 * @return translated "gestion des marchés"
	 */
	@DefaultStringValue("gestion des marchés")
	@Key("title.marketTab")
	String title_marketTab();

	/**
	 * Translated "Bienvenue".
	 * 
	 * @return translated "Bienvenue"
	 */
	@DefaultStringValue("Bienvenue")
	@Key("title.welcome")
	String title_welcome();

	/**
	 * Translated "saisie des données".
	 * 
	 * @return translated "saisie des données"
	 */
	@DefaultStringValue("saisie des données")
	@Key("updateMarketPage.form")
	String updateMarketPage_form();

	/**
	 * Translated "modification d'un marché".
	 * 
	 * @return translated "modification d'un marché"
	 */
	@DefaultStringValue("modification d'un marché")
	@Key("updateMarketPage.title")
	String updateMarketPage_title();

	/**
	 * Translated "Aucune information ne correspond aux critères spécifiés".
	 * 
	 * @return translated
	 *         "Aucune information ne correspond aux critères spécifiés"
	 */
	@DefaultStringValue("Aucune information ne correspond aux critères spécifiés")
	@Key("warning.not.found")
	String warning_not_found();
}
