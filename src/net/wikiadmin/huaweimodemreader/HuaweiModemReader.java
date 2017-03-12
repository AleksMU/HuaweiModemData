/*
 * 
 */
package net.wikiadmin.huaweimodemreader;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HuaweiModemReader {
    String modemIP = "192.168.8.1";


    public static void main(String[] args){

        Hgui gui = new Hgui();

        for(int i = 1; i < 60; i++) {
            try {
                HuaweiGetData newgd = new HuaweiGetData();
                gui.setRssi(newgd.i1);
                gui.setRsrp(newgd.i2);
                gui.setSinr(newgd.i3);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(HuaweiModemReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}