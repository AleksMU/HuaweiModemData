/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wikiadmin.huaweimodemreader;


import javax.swing.JFrame;

/**
 *
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
        //jLabel5 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        //String url = HuaweiModemReader.;


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

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFrame jFrame1;
    // End of variables declaration
}