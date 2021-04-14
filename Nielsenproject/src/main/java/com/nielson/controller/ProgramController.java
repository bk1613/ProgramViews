package com.nielson.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nielson.domain.ChartView;
import com.nielson.domain.Programs;
import com.nielson.service.ProgramService;

@Controller
public class ProgramController {

	@Autowired
	ProgramService proSer;
	
	
	@GetMapping("chartform")
	public String chartform() {
		return "ChartForm";
	}
	
	@PostMapping("addprograms")
	public ResponseEntity<Programs> addPrograms(@RequestBody Programs program){
		
		System.out.println(program);
		proSer.saveProgram(program);
		return new ResponseEntity<Programs>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("showTotalviews")
	public ResponseEntity<?> shownumberviews(){
		
		
		List<ChartView> viewlist = proSer.findchartviews();
		JSONObject jsa = new JSONObject();
		jsa.put("views", viewlist);
		return new ResponseEntity<String>(jsa.toString(), HttpStatus.OK);
	}
	
	@GetMapping("gatallprograms")
	public ResponseEntity<List<Programs>> getAllPrograms(){
		
		List<Programs> list = proSer.findallPrograms();
		
		return new ResponseEntity<List<Programs>>(list, HttpStatus.OK);
	}
	
	
}
