package com.nielson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nielson.dao.ProgramDAO;
import com.nielson.domain.ChartView;
import com.nielson.domain.Programs;
import com.nielson.repository.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	ProgramRepository proRepo;
	
	@Autowired
	ProgramDAO prodao;

	@Override
	public Programs saveProgram(Programs program) {
		// TODO Auto-generated method stub
		return proRepo.save(program);
	}

	@Override
	public List<Programs> findallPrograms() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public List<ChartView> findchartviews() {
		// TODO Auto-generated method stub
		return prodao.findTotalView();
	}
	
	
	
}
