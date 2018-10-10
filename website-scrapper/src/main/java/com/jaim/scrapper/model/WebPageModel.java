package com.jaim.scrapper.model;

import java.util.ArrayList;
import java.util.List;


public class WebPageModel {
	
	// keep all <a> tag information
	private List<String> anchorTags = new ArrayList<>();
	
	// keep all <p> tag informations
	private List<String> paragraphTags = new ArrayList<>();

	// keep all images url from webpage.
	private List<String> images = new ArrayList<>();

	public List<String> getAnchorTags() {
		return anchorTags;
	}

	public void setAnchorTags(List<String> anchorTags) {
		this.anchorTags = anchorTags;
	}

	public List<String> getParagraphTags() {
		return paragraphTags;
	}

	public void setParagraphTags(List<String> paragraphTags) {
		this.paragraphTags = paragraphTags;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	
	
	
	
	
	
	
}
