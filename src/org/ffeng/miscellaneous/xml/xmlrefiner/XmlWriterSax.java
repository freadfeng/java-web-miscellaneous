package org.ffeng.miscellaneous.xml.xmlrefiner;

import java.io.FileOutputStream;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class XmlWriterSax {
	public void writeSimpleElementAsXml(SimpleElement rootElement, String xmlPath) throws Exception {
		SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler handler = saxTransformerFactory.newTransformerHandler();
		Transformer transformer = handler.getTransformer();
		// transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		Result result = new StreamResult(new FileOutputStream(xmlPath));
		handler.setResult(result);
		handler.startDocument();
		
		this.renderContent(rootElement, handler);
		
		handler.endDocument();
	}

	private void renderContent(SimpleElement element, TransformerHandler handler) throws SAXException {
		AttributesImpl attributes = new AttributesImpl();
		if (element.getAttributeMap().size() > 0) {
			Set<Entry<String, String>> entrySet = element.getAttributeMap().entrySet();
			for (Entry<String, String> entry : entrySet) {
				attributes.addAttribute("", "", entry.getKey(), "", entry.getValue());
			}
		}
		handler.startElement("", "", element.getName(), attributes);
		if (element.getText() != null) {
			handler.characters(element.getText().toCharArray(), 0, element.getText().length());
		}
		if (element.getChildren().size() > 0) {
			for (SimpleElement child : element.getChildren()) {
				renderContent(child, handler);
			}
		}
		handler.endElement("", "", element.getName());
	}
}
