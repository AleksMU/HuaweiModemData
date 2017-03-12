/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wikiadmin.huaweimodemreader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author aleksdem
 */
public class HuaweiGetData {

    String i1, i2, i3;

    HuaweiGetData() {

        try {
            String mIP = ("http://"+Hgui.jip+"/api/device/signal");
            URL url = new URL(mIP);
            URLConnection connection = url.openConnection();

            Document doc = parseXML(connection.getInputStream());

            NodeList rssiNodes = doc.getElementsByTagName("rssi");
            NodeList rsrpNodes = doc.getElementsByTagName("rsrp");
            NodeList sinrNodes = doc.getElementsByTagName("sinr");



            for(int i=0; i<rssiNodes.getLength();i++)
            {
                i1 = rssiNodes.item(i).getTextContent();
                //System.out.println("Мощность приёма сигнала\n (rssi, -100 и ниже - очень слабо): "+i1);
            }


            for(int i=0; i<rsrpNodes.getLength();i++)
            {
                i2 = rsrpNodes.item(i).getTextContent();
                //System.out.println("среднее значение мощности принятых пилотных сигналов\n (rsrp, -100 и ниже - очень слабо): "+i2);
            }


            for(int i=0; i<sinrNodes.getLength();i++)
            {
                i3 = sinrNodes.item(i).getTextContent();
                //System.out.println("Отношение Сигнал/Шум\n (sinr, чем больше тем лучше): "+i3);
            }
        } catch (Exception ex) {
            Logger.getLogger(HuaweiGetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //}
    private Document parseXML(InputStream stream)
    throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(IOException | ParserConfigurationException ex)
        {
            throw ex;
        }

        return doc;
    }

}
