package telefonia.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telefonia.model.ChiamateModel;

public interface ChiamateRepository extends JpaRepository<ChiamateModel, Integer> {

    @Query(value = "SELECT SUM(durata)" + "	FROM public.chiamate"
	    + "	WHERE data_inizio>=:dateStart AND data_fine<=:dateEnd", nativeQuery = true)
    Long sommaDurate(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
}
