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
	
	@PostMapping("showTotalviews")
	public ResponseEntity<?> shownumberviews(@RequestBody String homes){
		
		
		JSONObject homeviews = new JSONObject(homes);
		
		String hov1 = homeviews.getString("homeview1");
		String hov2 = homeviews.getString("homeview2");
		List<ChartView> viewlist = proSer.findchartviews(hov1, hov2);
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
