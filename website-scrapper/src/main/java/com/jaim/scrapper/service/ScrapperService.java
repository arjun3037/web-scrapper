package com.jaim.scrapper.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaim.scrapper.htmlparser.HtmlParser;
import com.jaim.scrapper.model.WebPageModel;

@Service
public class ScrapperService {
	
	@Autowired
	private HtmlParser parser;
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public WebPageModel doScrap(String url){
		if (StringUtils.isBlank(url)) {
			return null;
		}
		return parser.parseHtml(url);
		
	}
	
	
	

}
