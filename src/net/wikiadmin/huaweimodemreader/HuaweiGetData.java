/*
 * Copyright (c) 2017, aleksdem
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
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
 * Класс для получения данных из xml по URL.
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
            }

            for(int i=0; i<rsrpNodes.getLength();i++)
            {
                i2 = rsrpNodes.item(i).getTextContent();
            }

            for(int i=0; i<sinrNodes.getLength();i++)
            {
                i3 = sinrNodes.item(i).getTextContent();
            }
        } catch (Exception ex) {
            Logger.getLogger(HuaweiGetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
