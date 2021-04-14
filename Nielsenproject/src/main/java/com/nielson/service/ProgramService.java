package com.nielson.service;

import java.util.List;

import com.nielson.domain.ChartView;
import com.nielson.domain.Programs;

public interface ProgramService {

	public Programs saveProgram(Programs program);
	public List<Programs> findallPrograms();
	public List<ChartView> findchartviews(String hov1, String hov2);
}
