package io.sakhri.sourceboost.type;

/**
 * List of validation error codes
 * 
 * @author Wael.Sakhri
 *
 */
public abstract class CodeTypes {

	public static enum AttributeCode {

		UNDEFINED("99", "Indefinit"), OBJECT("OB", "Objet"), ID("ID", "Identifiant"), CODE("CD", "Code"), LIBELE("LB",
				"Libellé");

		private final String code;
		private final String value;

		AttributeCode(String code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}

	};

	public static enum OperationCode {

		UNDEFINED("99", "Indefinit"), ADD("01", "Ajout"), DELETE("02", "Suppression"), CREATE("03",
				"Creation"), SAVE("04", "Modification"), GET_ALL("05", "Recuperer tout"), GET_ONE("06",
						"Recuperer un"), DUPLICATE("07", "Dupliquation"), CORRESPONDANCE("08", "Correspondance"), INIT_CODE_CODE("09", "Initialiser code cnam");

		private final String code;
		private final String value;

		OperationCode(String code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}
	};

	public static enum ValidatorCode {

		UNDEFINED("99", "Indefinit"), NULL_POINTER("00", "Objet vide (null)"), EXIST("11",
				"Objet dupliqué (existe déja dans la base de données)"), NOT_VALID("69",
						"Objet non valide (nombre charactere)");

		private final String code;
		private final String value;

		ValidatorCode(String code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}
	};

	public static enum ServiceCode {

		UNDEFINED("99", "Indefinit"), GESTION_ANALYSE("S34", "Gestion analyse"), GESTION_ADRESSE("S11", "Gestion adresse"),GESTION_CONTACT("S12", "Gestion adresse"), GESTION_CORRESPONDANT("S13", "Gestion correspondant"), GESTION_TARIF_FACTURATION("S14", "Gestion adresse"), GESTION_ANTIBIOTIQUE("S61",
				"Gestion antibiotique"), GESTION_FAMILLE_ANTIBIOTIQUE("S62",
						"Gestion famille antibiotique"), GESTION_GERME("S63", "Gestion germe"), GESTION_FAMILLE_GERME(
								"S64", "Gestion fmille germe"), GESTION_FAMILLE_ANALYSE("S67",
										"Gestion famille analyse"), GESTION_CODE_CNAM("S68",
												"Gestion code CNAM"), GESTION_ALERTE_ANALYSE("S69",
														"Gestion alerte analyse"), GESTION_APB("S80",
																"Gestion APB"), GESTION_TRADUCTION("S81",
																		"Gestion Traduction"),GESTION_MISE_EN_FORME("S82", "Gestion mise en forme"),;

		private final String code;
		private final String value;

		ServiceCode(String code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}
	};

}
