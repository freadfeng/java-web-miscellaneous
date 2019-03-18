package org.ffeng.miscellaneous.xml.xmlrefiner;

import java.util.Iterator;
import java.util.Properties;

import org.ffeng.miscellaneous.common.PropertiesUtil;

public class XmlRefinerMain {
	/**
	 * 
	 * @param args args[0]: cfg, args[1]: sourceXmlPath, args[2]:destXmlPath
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Replace these variable with args
		String cfgPath = "D:/workspaces/workspace-spring/java-web-miscellaneous/src/org/ffeng/miscellaneous/xml/xmlrefiner/test_cfg.properties";
		String sourceXmlPath = "D:/workspaces/workspace-spring/java-web-miscellaneous/src/org/ffeng/miscellaneous/xml/xmlrefiner/test_source.xml";
		String destXmlPath = "D:/workspaces/workspace-spring/java-web-miscellaneous/src/org/ffeng/miscellaneous/xml/xmlrefiner/test_dest.xml";

		XmlRefinerMain xmlRefiner = new XmlRefinerMain();

		Properties cfgProperties = PropertiesUtil.loadProperties(cfgPath);

		SimpleXmlParser simpleXmlParser = new SimpleXmlParser();
		SimpleElement simpleElement = simpleXmlParser.parseToSimpleElement(sourceXmlPath);

		xmlRefiner.refineElementsAgainstProperties(cfgProperties, null, simpleElement);

		XmlWriterSax writer = new XmlWriterSax();
		writer.writeSimpleElementAsXml(simpleElement, destXmlPath);
	}

	/**
	 * 
	 * @param cfgProperties
	 * @param parentIterator
	 * @param currentElement
	 */
	private void refineElementsAgainstProperties(Properties cfgProperties, Iterator<SimpleElement> parentIterator,
			SimpleElement currentElement) {

		if (currentElement.getChildren().size() > 0) {
			Iterator<SimpleElement> iterator = currentElement.getChildren().iterator();
			while (iterator.hasNext()) {
				SimpleElement simpleElement = iterator.next();
				this.refineElementsAgainstProperties(cfgProperties, iterator, simpleElement);
			}
		}

		if (parentIterator != null && currentElement.getChildren().size() == 0) {
			String configValue = cfgProperties.getProperty(currentElement.getName(), null);
			if (configValue == null) {
				parentIterator.remove();
			} else {
				currentElement.setText(configValue);
			}
		}

	}

}
