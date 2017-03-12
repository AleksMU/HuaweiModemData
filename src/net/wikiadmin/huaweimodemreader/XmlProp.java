/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wikiadmin.huaweimodemreader;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author aleksdem
 */

class XmlProp {

	private String fileP = "settings.xml";
        private String ipModem;
        private String updateSec;

	void readData() {

            try {
                File fxmlFile = new File(fileP);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fxmlFile);
                doc.getDocumentElement().normalize();

        	NodeList nList = doc.getElementsByTagName("settings");

                for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
                        Element eElement = (Element) nNode;
                        ipModem = eElement.getElementsByTagName("ipModem").item(0).getTextContent();
                        updateSec = eElement.getElementsByTagName("updateSec").item(0).getTextContent();
                    }
            } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
                System.out.println("i need settings.xml");
        }
    }

    String getIp() {
           return ipModem;
        }

    String getSec(){
        return updateSec;
        }

}
