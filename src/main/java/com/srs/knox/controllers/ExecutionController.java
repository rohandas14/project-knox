package com.srs.knox.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srs.knox.execution.utils.FINotificationRequest;
import com.srs.knox.execution.utils.InvokeExecutionRequest;
import com.srs.knox.execution.utils.InvokeExecutionResponse;
import com.srs.knox.services.ExecutionService;
import com.srs.knox.utils.KnoxException;

@RestController
@RequestMapping(value="/execution", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExecutionController {
	
Logger logger = LoggerFactory.getLogger(ExecutionController.class);
	
	@Autowired
	ExecutionService executionService;
	
	@PostMapping(value="/invoke")
	@ResponseBody
	public ResponseEntity<String> invokeFunction(@RequestBody InvokeExecutionRequest requestBody, @RequestHeader("vdpr-api-key") String key) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			InvokeExecutionResponse response = executionService.invokeExecution(requestBody, key);
			return new ResponseEntity<String>(objectMapper.writeValueAsString(response), HttpStatus.OK);
		} catch (KnoxException ex) {
			logger.error("Invoke Execution Error: " + ex.getLocalizedMessage());
			return new ResponseEntity<String>(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			logger.error("Invoke Execution Error: " + ex.getLocalizedMessage());
			return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/notification")
	@ResponseBody
	public ResponseEntity<String> notify(@RequestBody FINotificationRequest requestBody, @RequestHeader("vdpr-api-key") String key) {
		try {
			executionService.notify(requestBody, key);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (KnoxException ex) {
			logger.error("Invoke Execution Error: " + ex.getLocalizedMessage());
			return new ResponseEntity<String>(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			logger.error("Invoke Execution Error: " + ex.getLocalizedMessage());
			return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}