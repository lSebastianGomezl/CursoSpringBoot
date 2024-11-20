package edu.eud.springBootTest.util;

public class SQLConstants {
	
	private SQLConstants() {
		throw new UnsupportedOperationException("Esta clase no se puede instanciar");
	}

	
	public static final String NAME_JOB_ENTITY_RESULTSET_MAPPING = "JobEntity.findRangeSalary";
	
	public static final String FIND_JOBS_BY_SALARY_RANGE = ""
			+ "SELECT job_id, job_title, min_salary, max_salary "
			+ "FROM jobs "
			+ "WHERE :salary BETWEEN min_salary AND max_salary "
			+ "ORDER BY job_title ASC";
}
