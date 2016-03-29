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

		UNDEFINED("99", "Indefinit"), ADD("01", "Ajout"), DELETE("02", "Suppression"), CREATE("03", "Creation"), SAVE(
				"04", "Modification"), GET_ALL("05", "Recuperer tout"), GET_ONE("06", "Recuperer un"), DUPLICATE("07",
						"Dupliquation"), CORRESPONDANCE("08",
								"Correspondance"), INIT_CODE_CODE("09", "Initialiser code cnam");

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

}
