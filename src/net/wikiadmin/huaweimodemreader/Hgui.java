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


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 * графическая оболочка для программы.
 * @author aleksdem
 */
public class Hgui {

    public static String jip;// = "192.168.8.1";
    String updSec;// = "2";

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
    Date date = new Date();
    String jdate= sdf.format(date);

    String jrssp = "no data";
    String jrscp = "no data";
    String jsinr = "no data";
    String jvers = "0.02";
    public static String jrssi;

    Hgui() {

        XmlProp settings = new XmlProp();
            settings.readData();
            jip = settings.getIp();
            updSec = settings.getSec();


        jFrameMain = new JFrame("HW-data, ver "+jvers);
        jLabelAddr = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelUpdateTime = new javax.swing.JLabel();
        jLabelPow = new javax.swing.JLabel();
        jLabelSCP = new javax.swing.JLabel();
        jLabelCIO = new javax.swing.JLabel();

        jFrameMain.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrameMain.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAddr.setText("Адрес модема: "+jip);
        jFrameMain.getContentPane().add(jLabelAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 20));

        jLabelDate.setText("Дата: "+jdate);
        jFrameMain.getContentPane().add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 200, 20));

        jLabelUpdateTime.setText("Частота обновления: "+updSec+" сек.");
        jFrameMain.getContentPane().add(jLabelUpdateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 20));

        jLabelPow.setText("Мощность приёма сигнала (rssi): "+jrssp);
        jFrameMain.getContentPane().add(jLabelPow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 380, 40));

        jLabelSCP.setText("Уровень пилотного сигнала (rscp):  "+jrscp);
        jFrameMain.getContentPane().add(jLabelSCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 40));

        jLabelCIO.setText("Отношение Сигнал/Шум (ecio):  "+jsinr);
        jFrameMain.getContentPane().add(jLabelCIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 40));

        jFrameMain.pack();
        jFrameMain.setVisible(true);
        jFrameMain.setLocationRelativeTo(null);

    }

    void setRssi(String i){
        jrssp = i;
        jLabelPow.setText("Мощность приёма сигнала (rssi): "+jrssp);
    }

    void setRsrp(String i){
        jrscp = i;
        jLabelSCP.setText("Cр. мощности пилотных сигналов (rsrp): "+jrscp);
    }

    void setSinr(String i){
        jsinr = i;
        jLabelCIO.setText("Отношение Сигнал/Шум (sinr): "+jsinr);
    }

    // Variables declaration
    private javax.swing.JLabel jLabelAddr;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelUpdateTime;
    private javax.swing.JLabel jLabelPow;
    private javax.swing.JLabel jLabelSCP;
    private javax.swing.JLabel jLabelCIO;
    private javax.swing.JFrame jFrameMain;
    // End of variables declaration
}