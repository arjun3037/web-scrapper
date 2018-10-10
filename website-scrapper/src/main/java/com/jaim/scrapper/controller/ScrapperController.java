package com.jaim.scrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaim.scrapper.model.WebPageModel;
import com.jaim.scrapper.service.ScrapperService;

@RestController
public class ScrapperController {
	
	@Autowired
	private ScrapperService scrapperService; 
	
	/**
	 * initiate the crawling process		
	 * @return
	 */
	@RequestMapping(value = "/scrap", method = RequestMethod.GET,produces = { "application/json" })
	public WebPageModel doScrap(@RequestParam("url") String url){
		WebPageModel doScrap = scrapperService.doScrap(url);
		return doScrap;
	}

}
