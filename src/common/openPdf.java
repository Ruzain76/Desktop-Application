/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import dao.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ruzai
 */
public class openPdf {

    public static void OpenById(String id) {
        try {
            if ((new File(InventoryUtils.billpath + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + InventoryUtils.billpath + "" + id + ".pdf");
            }else{
            JOptionPane.showMessageDialog(null, "File is not exist");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
