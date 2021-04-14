package com.nielson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nielson.domain.ChartView;
import com.nielson.domain.Programs;

public interface ProgramRepository extends JpaRepository<Programs, Integer> {

//	@Query(value = "select genre, sum(Viewers) from programs where ViewerHometown = 'Pittsburgh' or ViewerHometown = 'Cleveland' group by genre;")
//	public List<ChartView> findTotalView();
}
