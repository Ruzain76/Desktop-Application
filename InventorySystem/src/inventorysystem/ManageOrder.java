/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorysystem;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import common.openPdf;
import dao.DatabaseConnection;
import dao.InventoryUtils;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ruzai
 */
public class ManageOrder extends javax.swing.JFrame {

    private int customerpk = 0;
    private int productpk = 0;
    private int finalTotalPrice = 0;
    private String orderId = "";

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        productpk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 36)); // NOI18N
        jLabel1.setText("Manage Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 56, -1, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 82, 384, 212));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 56, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 82, 422, 212));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1051, 56, -1, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 82, 380, 214));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Selected Customer:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 314, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 352, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 376, 385, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mobile Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 416, -1, -1));

        txtCustomerNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 438, 385, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 478, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 498, 385, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("Selected Product:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 314, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Product Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 352, -1, -1));

        txtProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 376, 422, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Product Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 416, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 438, 422, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Product Description");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 478, -1, -1));

        txtProductDescription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 498, 422, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Order Quantity");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 538, -1, -1));

        txtOrderQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 561, 422, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add To Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 601, 422, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 3, 20)); // NOI18N
        jLabel14.setText("Total Amount Rs:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 339, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI Black", 3, 20)); // NOI18N
        lblFinalTotalPrice.setText("000000");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1077, 339, -1, -1));

        btnSaveOrderDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveOrderDetails.setText("Save Order Details");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 400, 370, -1));

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 473, 370, -1));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 542, 370, -1));

        jButton5.setBackground(new java.awt.Color(255, 51, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 601, 370, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/All.jpg"))); // NOI18N
        jLabel15.setText("jLabel7");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        txtCustomerName.setEditable(false);
        txtCustomerNum.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();
        try {
            Connection con = DatabaseConnection.connection();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select * From customer");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});
            }
            rs = st.executeQuery("select * From product inner join category on product.category_fk = category.category_pk");

            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do You Want Close Application", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        if (finalTotalPrice != 0 && !txtCustomerName.equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = DatabaseConnection.connection();
                        Statement st = (Statement) con.createStatement();
                        st.executeUpdate("update product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " where product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-mm-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = DatabaseConnection.connection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into orderDetail(orderId,customer_fk,orderDate,totalPaid) value(?,?,?,?)");
                ps.setString(1, orderId);
                ps.setInt(2, customerpk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, finalTotalPrice);
                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //creating document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(InventoryUtils.billpath + "" + orderId + ".pdf"));
                doc.open();
                Paragraph projectName = new Paragraph("                      Advanced Inventory Management System\n");
                doc.add(projectName);
                Paragraph starLine = new Paragraph("************************************************************************");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tOrder ID: "+orderId+"\nDate: "+new Date()+"\nTotal Paid: "+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                
                PdfPTable tb1= new PdfPTable(5);
                PdfPCell nameCell= new PdfPCell(new Phrase("Name"));
                PdfPCell descriptionCell= new PdfPCell(new Phrase("Description"));
                PdfPCell priceCell= new PdfPCell(new Phrase("Price per Unit"));
                PdfPCell quantityCell= new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalCell= new PdfPCell(new Phrase("Sub Total Price"));
                
                BaseColor background= new BaseColor(255,204,51);
                nameCell.setBackgroundColor(background);
                descriptionCell.setBackgroundColor(background);
                priceCell.setBackgroundColor(background);
                quantityCell.setBackgroundColor(background);
                subTotalCell.setBackgroundColor(background);
                
                tb1.addCell(nameCell);
                tb1.addCell(descriptionCell);
                tb1.addCell(priceCell);
                tb1.addCell(quantityCell);
                tb1.addCell(subTotalCell);
                
                for(int i=0;i<tableCart.getRowCount();i++){
                tb1.addCell(tableCart.getValueAt(i,1).toString());
                tb1.addCell(tableCart.getValueAt(i,4).toString());
                tb1.addCell(tableCart.getValueAt(i,3).toString());
                tb1.addCell(tableCart.getValueAt(i,2).toString());
                tb1.addCell(tableCart.getValueAt(i,5).toString());
                }
                doc.add(tb1);
                doc.add(starLine);
                Paragraph thankMsg= new Paragraph("Thank You, Get Connected with us...");
                doc.add(thankMsg);
                openPdf.OpenById(orderId);
                
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
        }else{
        JOptionPane.showMessageDialog(null, "Please add some product into cart or select customer!!! ");
        }
    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();

        String id = model.getValueAt(index, 0).toString();
        customerpk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerNum.setText(mobileNumber);

        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();

        String id = model.getValueAt(index, 0).toString();
        productpk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);

        String productDescription = model.getValueAt(index, 4).toString();
        txtProductDescription.setText(productDescription);
    }//GEN-LAST:event_tableProductMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals("")) {
            String productName = txtProductName.getText();
            String productDescription = txtProductDescription.getText();
            String productPrice = txtProductPrice.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(productPrice);

            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;

            try {
                Connection con = DatabaseConnection.connection();
                Statement st = (Statement) con.createStatement();
                ResultSet rs = st.executeQuery("select * From product where product_pk=" + productpk + "");

                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "product is out of stock only" + rs.getInt("quantity") + "Left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productpk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, " Product allready exist in cart");
                        }
                    }
                }

                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{productpk, productName, noOfUnits, productPrice, productDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added successfilly!");
                }
                clearProductFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No of Quantity and Product fields are required");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tableCartMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerNum;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
