package com.nielson.dao;

import java.util.List;

import com.nielson.domain.ChartView;

public interface ProgramDAO {

	public List<ChartView> findTotalView(String hov1, String hov2);
	
}
