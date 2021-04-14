package com.nielson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielson.domain.Programs;

public class ReadCVSfile {

	public static void main(String[] args) {

		String line = "";  
		String splitBy = ",";  
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bk161\\spring microsoft project\\Nielsenproject\\src\\main\\java\\Software Engineering Programming Exercise (1).csv"));
			br.readLine();
			int count = 1;
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] program = line.split(splitBy);    // use comma as separator  
				Programs pro = new Programs(count++, program[0], program[1], program[2], program[3], Integer.parseInt(program[4]));
				
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(pro);
			   
			    JSONObject jsonObject = new JSONObject(jsonString);
			    HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity("http://localhost:8083//addprograms", request, Object[].class);
			}  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
