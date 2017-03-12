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


import javax.swing.JFrame;

/**
 * графическая оболочка для программы.
 * @author aleksdem
 */
public class Hgui {

    public static String jip;// = "192.168.8.1";
    String updSec;// = "2";
    String jrssp = "no data";
    String jrscp = "no data";
    String jsinr = "no data";
    String jvers = "0.01";
    public static String jrssi;

    Hgui() {

        XmlProp settings = new XmlProp();
            settings.readData();
            jip = settings.getIp();
            updSec = settings.getSec();


        jFrame1 = new JFrame("HW-data, ver "+jvers);
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Адрес модема: "+jip);
        jFrame1.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 20));

        jLabel11.setText("Частота обновления: "+updSec+" сек.");
        jFrame1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 20));

        jLabel2.setText("Мощность приёма сигнала (rssi): "+jrssp);
        jFrame1.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 380, 40));

        jLabel3.setText("Уровень пилотного сигнала (rscp):  "+jrscp);
        jFrame1.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 40));

        jLabel4.setText("Отношение Сигнал/Шум (ecio):  "+jsinr);
        jFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 40));

        jFrame1.pack();
        jFrame1.setVisible(true);
        jFrame1.setLocationRelativeTo(null);

    }

    void setRssi(String i){
        jrssp = i;
        jLabel2.setText("Мощность приёма сигнала (rssi): "+jrssp);
    }

    void setRsrp(String i){
        jrscp = i;
        jLabel3.setText("Cр. мощности принятых пилотных с-в (rsrp): "+jrscp);
    }

    void setSinr(String i){
        jsinr = i;
        jLabel4.setText("Отношение Сигнал/Шум (sinr): "+jsinr);
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFrame jFrame1;
    // End of variables declaration
}