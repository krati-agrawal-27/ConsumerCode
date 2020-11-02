package com.Consumer.Controller;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Consumer.entity.FbProfile;
//import com.Consumer.entity.Fbprofile;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class ConsumerController {
@RequestMapping("ccc")

public void consume() {
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> response=null;
	try{
	response=restTemplate.exchange("http://localhost:10000/employeelist",HttpMethod.GET, abc(),String.class);
	}catch (Exception ex)
	{
		System.out.println(ex);
	}
	System.out.println(response.getBody());
}

@RequestMapping(value = "/consumeCreateProfile", method = RequestMethod.POST)
public void consumeCreateProfile(@RequestBody FbProfile profile) {
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity = null;
	
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<FbProfile> entity = new HttpEntity<FbProfile>(profile,headers);
    
	try {
		responseEntity = restTemplate.exchange("http://localhost:10000/createProfile", HttpMethod.POST , entity, String.class);
	}catch(Exception e) {
		System.out.println(e);
	}
	System.out.println(responseEntity.getBody());
	
}
@RequestMapping(value = "/consumeEditProfile", method = RequestMethod.POST)
public void consumeEditProfile(@RequestBody FbProfile profile) {
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity = null;
	
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<FbProfile> entity = new HttpEntity<FbProfile>(profile, headers);
    
	try {
		responseEntity = restTemplate.exchange("http://localhost:10000/editProfile", HttpMethod.PUT , entity, String.class);
	}catch(Exception e) {
		System.out.println(e);
	}
	System.out.println(responseEntity.getBody());
}
@RequestMapping(value = "/consumeDeleteProfile", method = RequestMethod.POST)
public void consumeDeleteProfile(@RequestBody FbProfile profile) {
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity = null;
	
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<FbProfile> entity = new HttpEntity<FbProfile>(profile, headers);
    
	try {
		responseEntity = restTemplate.exchange("http://localhost:10000/deleteProfile", HttpMethod.DELETE , entity, String.class);
	}catch(Exception e) {
		System.out.println(e);
	}
	System.out.println(responseEntity.getBody());
}

private HttpEntity abc() throws IOException {
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	return new HttpEntity(headers);
}
}
