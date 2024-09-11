package com.project.accident.blackspots.controller;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.accident.blackspots.model.User;
import com.project.accident.blackspots.model.accident;
import com.project.accident.blackspots.model.location;
import com.project.accident.blackspots.repository.AccidentRepository;
import com.project.accident.blackspots.services.Queries;
import com.project.accident.blackspots.services.Clustering.Cluster;
import com.project.accident.blackspots.services.Clustering.DBSCAN;


@RestController
@RequestMapping("/controller")
@CrossOrigin(origins = "http://localhost:3000")
public class accidentController {
	
	@Autowired
	private AccidentRepository accRepo;

	@Autowired
	private Queries query;
	
	@Autowired
	private DBSCAN dbCluster;
	
	@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	   
	    for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		    XSSFRow row=worksheet.getRow(i);
		    accident tempData=new accident();
		    
		    tempData.setLat(new BigDecimal(row.getCell(0).getNumericCellValue()).round(new MathContext(15)));
		    tempData.setLng(new BigDecimal(row.getCell(1).getNumericCellValue()).round(new MathContext(15)));
		    tempData.setWard(row.getCell(2).toString());
		    tempData.setAccType(row.getCell(3).toString());
		    tempData.setTime(row.getCell(4).toString());
		    tempData.setDate(row.getCell(5).toString());
		    tempData.setWeather(row.getCell(6).toString());
		    
		    accRepo.save(tempData);
	    }
	    String originalName = file.getOriginalFilename();
//		System.out.println(tempData.toString());
		return originalName;
	}
	
	@GetMapping("/blackspots/clusters/{weather}/{time}")
	public List<Cluster> getClusters(@PathVariable(value="weather") String weather, @PathVariable(value="time") String time) throws JsonMappingException, JsonProcessingException{
		List<location> locations=query.getLocations(weather, time);
//		DBSCAN dbCluster= new DBSCAN(locations);
		dbCluster.setPoints(locations);
		List<Cluster> clusters=dbCluster.cluster();
		return clusters;	
	}
	

	@PostMapping("/details/unsecured")
	public List<Object>  getAccountDetailsUnsecured(@RequestBody User data){
		List<Object> details=query.getDetailsUnsecured(data.getEmail(), data.getPass_word());
		return details;
	}

	@PostMapping("/details/secured")
	public List<User>  getAccountDetailSecured(@RequestBody User data){
		List<User> details=query.getDetailsSecured(data.getEmail(), data.getPass_word());
		return details;
	}
	
	/*	@GetMapping("/blackspots/{weather}/{time}")
	public List<accident> getBlackspots(@PathVariable(value="weather") String weather,@PathVariable(value="time") String time){
		return accRepo.findAllByWeatherAndTime(weather, time);
	}
*/	
	@GetMapping("/blackspots")
	public List<accident> getAccidentList(){
		return accRepo.findAll();
	}
/*	
	@PostMapping("/blackspots")
	public accident addAccident(@RequestBody accident data) {
		return accRepo.save(data);
	}
	
	@DeleteMapping("/blackspots")
	public String deleteData() {
		accRepo.deleteAll();
		return "Data Deleted";
	}
	*/
}
