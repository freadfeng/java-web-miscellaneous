package org.ffeng.miscellaneous.xml.xmlrefiner;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.ffeng.miscellaneous.common.io.FileUtil;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleXmlParser {
	private SimpleElement rootElement;
	
	public SimpleElement parseToSimpleElement(String xmlPath) throws Exception{
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(xmlPath);
			InputSource inputSource = new InputSource(fileReader);
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			xmlReader.setContentHandler(new XmlHandler());
			xmlReader.parse(inputSource);
		} catch (Exception e) {
			FileUtil.closeIgnoreException(fileReader);
			throw e;
		}
		return rootElement;
		
	}

	class XmlHandler extends DefaultHandler {
		private LinkedList<SimpleElement> elementStack = new LinkedList<SimpleElement>();
		private SimpleElement currentElement = null;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			this.currentElement = new SimpleElement();
			this.currentElement.setName(qName);
			// this.currentElement.setText(); this does not work
			this.currentElement.setAttributeMap(this.convertAttributesToMap(attributes));
			if(!elementStack.isEmpty()) {
				elementStack.getLast().getChildren().add(currentElement);
			} else {
				SimpleXmlParser.this.rootElement = currentElement;
			}
			elementStack.add(currentElement);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			elementStack.removeLast();
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String text = new String(ch, start, length);
			this.currentElement.setText(text);
		}
		
		private Map<String, String> convertAttributesToMap(Attributes attributes) {
			Map<String, String> map = new TreeMap<String, String>();
			int length = attributes.getLength();
			for(int i=0;i<length;i++) {
				String attributeName = attributes.getQName(i);
				String attributeValue = attributes.getValue(i);
				map.put(attributeName, attributeValue);
			}
			return map;
		}
	}
	
}
