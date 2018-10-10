package com.jaim.scrapper.htmlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.jaim.scrapper.model.WebPageModel;

/**
 * 
 * @author arjun.singh
 *
 */
@Component
public class HtmlParser {
	
	private static final String HREF = "href";
	private static final String ANCHOR_TAG = "a";

	public WebPageModel parseHtml(String url){
		
		WebPageModel webPageModel = new WebPageModel();
		Document document = getDocument(url);
		if (document != null) {
			webPageModel.setAnchorTags(getAnchorTags(document));
			webPageModel.setImages(getImages(document));
			//webPageModel.setParagraphTags(getParagraphTag(document));
		}
		
		return webPageModel;
	}

	private List<String> getParagraphTag(Document document) {
		return getAttributeData(document, "p", null);
	}

	private List<String> getImages(Document document) {
		return getAttributeData(document, "img", "src");
	}

	/**
	 * extract all anchor(<a>) tags from document
	 * @param document
	 * @return
	 */
	private List<String> getAnchorTags(Document document) {
		return getAttributeData(document , ANCHOR_TAG , HREF);
	}

	private List<String> getAttributeData(Document document, String tag, String attributeName) {
		List<String> aList = new ArrayList<>();
		Elements elementsByTag = document.getElementsByTag(tag);
		Iterator<Element> iterator = elementsByTag.iterator();
		while (iterator.hasNext()) {
			Element type = iterator.next();
			String attr = type.attr(attributeName);
			aList.add(attr);
		}
		return aList;
	}

	private Document getDocument(String url){
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
