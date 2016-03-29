package io.sakhri.sourceboost.generic;

public abstract class BoostApiController {

	public static final String API_PATH = "/api/v1";
	public static final String GET_ALL = "/get/all";
	public static final String GET_BY_ID = "/get/id/{id}";
	public static final String GET_BY_CODE = "/get/code/{code}";
	public static final String SAVE = "/save";
	public static final String CREATE = "/create";
	public static final String DUPLICATE = "/duplicate";
	public static final String RESTORE = "/restore";
	public static final String DELETE = "/delete/{id}";
	public static final String DELETE_ALL = "/delete/all/{id}";
	public static final String GENERATE_GRID = "/grid/generate";
	public static final String PROCESS_GRID = "/grid/process";

}
