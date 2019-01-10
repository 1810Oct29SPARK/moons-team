package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Moon;
import com.revature.service.SpaceService;

@Controller
public class MoonController {

	@Autowired
	private SpaceService spaceService;
	
	@GetMapping(value="/moons")
	@ResponseBody
	public ResponseEntity<List<Moon>> getAllMoons() {
		return new ResponseEntity<>(spaceService.getAllMoons(), HttpStatus.OK);
	}


}
