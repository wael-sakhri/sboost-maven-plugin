package io.sakhri.sourceboost.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BoxyJpaRepository<T> extends JpaRepository<T, Long> {

	@Query("Select t from #{#entityName} t where t.code =:code")
	public T findByCode(@Param("code") String code);

}
