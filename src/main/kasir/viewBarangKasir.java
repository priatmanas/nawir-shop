package main.kasir;

//import main.admin.*;
import config.Koneksi;
import java.sql.*;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fawzanpriatmana
 */
public class viewBarangKasir extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewBarangKasir.class.getName());

    /**
     * Creates new form viewBarang
     */
    public viewBarangKasir() {
        initComponents();
//        tampilBarang();
        dataTabelDaftarBarang();
        this.setLocationRelativeTo(null);
    }
    
//    private void clearComponents() {
//        kotakIdDetailBarang.setText(null);
//        comboBarang.setSelectedIndex(0);
//        kotakSatuan.setText(null);
//        kotakHargaJual.setText(null);
//        kotakHargaBeli.setText(null);
//        kotakStok.setText(null);
//        comboStatus.setSelectedIndex(0);
//        kotakIdDetailBarang.setEnabled(true);
//        comboBarang.setEnabled(true);
//    }
    
//    private void tampilBarang() {
//        DefaultComboBoxModel comboBarang = new DefaultComboBoxModel();
//        comboBarang.addElement("-- Pilih --");
//        
//        try {
//            Koneksi koneksiTampilBarang = new Koneksi();
//            String sqlBarang = "SELECT nama_brg FROM barang "
//                    + "ORDER BY nama_brg ASC";
//            
//            Statement stmt = koneksiTampilBarang.createStatement();
//            ResultSet rs = stmt.executeQuery(sqlBarang);
//            
//            while (rs.next()) {                
//                comboBarang.addElement(
//                        rs.getString("nama_brg")
//                );
//            }
//            this.comboBarang.setModel(comboBarang);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
    
    private void dataTabelDaftarBarang() {
        
        DefaultTableModel tabelDaftarBarang = new DefaultTableModel();
        tabelDaftarBarang.addColumn("ID Detail Barang");
        tabelDaftarBarang.addColumn("ID Barang");
        tabelDaftarBarang.addColumn("Nama Barang");
        tabelDaftarBarang.addColumn("Kategori Barang");
        tabelDaftarBarang.addColumn("Satuan");
        tabelDaftarBarang.addColumn("Harga Jual");
        tabelDaftarBarang.addColumn("Harga Beli");
        tabelDaftarBarang.addColumn("Stok");
        tabelDaftarBarang.addColumn("Status");
        this.tabelDaftarBarang.setModel(tabelDaftarBarang);

        try {
            Koneksi koneksiTampilTabel = new Koneksi();

            String sql = "SELECT "
                    + "detail_barang.id_detail_barang, "
                    + "barang.id_barang, "
                    + "barang.nama_brg, "
                    + "kategori.nama_kategori,"
                    + "detail_barang.satuan, "
                    + "detail_barang.harga_beli, "
                    + "detail_barang.harga_jual, "
                    + "detail_barang.stok, "
                    + "detail_barang.status "
                    + "FROM detail_barang INNER JOIN barang "
                    + "ON detail_barang.id_barang = barang.id_barang "
                    + "INNER JOIN kategori "
                    + "ON barang.id_kategori = kategori.id_kategori "
                    + "ORDER BY barang.nama_brg ASC";

            Statement stm = koneksiTampilTabel.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                tabelDaftarBarang.addRow(new Object[]{
                    rs.getString("id_detail_barang"),
                    rs.getString("id_barang"),
                    rs.getString("nama_brg"),
                    rs.getString("nama_kategori"),
                    rs.getString("satuan"),
                    rs.getString("harga_beli"),
                    rs.getString("harga_jual"),
                    rs.getString("stok"),
                    rs.getString("status")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
//    private void autoIdDetailBarang() {
//        try {
//            Koneksi koneksiAutoIdBarang = new Koneksi();
//            String sql = "SELECT id_detail_barang "
//                    + "FROM detail_barang "
//                    + "ORDER BY id_detail_barang "
//                    + "DESC LIMIT 1";
//
//            Statement st = koneksiAutoIdBarang.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            if (rs.next()) {
//                String id_user = rs.getString("id_detail_barang");
//                int nomor = Integer.parseInt(id_user.substring(1));
//                nomor++;
//
//                String no_urut = String.format("D%04d", nomor);
//                kotakIdDetailBarang.setText(no_urut);
//            } else {
//                kotakIdDetailBarang.setText("D0001");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Gagal generate ID Barang!");
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDaftarBarang = new javax.swing.JTable();
        tombolRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Barang [Kasir]");
        setAlwaysOnTop(true);

        title.setPreferredSize(new java.awt.Dimension(400, 133));

        jLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 36)); // NOI18N
        jLabel2.setText("TOKO NAWIR");

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 2, 18)); // NOI18N
        jLabel1.setText("Daftar Barang");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        tabelDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Kategori", "Satuan", "Harga", "Stok", "Status"
            }
        ));
        tabelDaftarBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDaftarBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDaftarBarang);

        tombolRefresh.setText("Refresh");
        tombolRefresh.addActionListener(this::tombolRefreshActionPerformed);

        javax.swing.GroupLayout tabelLayout = new javax.swing.GroupLayout(tabel);
        tabel.setLayout(tabelLayout);
        tabelLayout.setHorizontalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tombolRefresh)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        tabelLayout.setVerticalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addComponent(tombolRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolRefreshActionPerformed
//        tampilBarang();
        dataTabelDaftarBarang();
    }//GEN-LAST:event_tombolRefreshActionPerformed

    private void tabelDaftarBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDaftarBarangMouseClicked
//        int i = tabelDetailBarang.getSelectedRow();
//        
//        String tempTableIdDetailBarang = tabelDetailBarang.getValueAt(i, 0).toString();
//        String tempTableNamaBarang = tabelDetailBarang.getValueAt(i, 2).toString();
//        String tempTableSatuanDetailBarang = tabelDetailBarang.getValueAt(i, 4).toString();
//        String tempTableHargaBeliDetailBarang = tabelDetailBarang.getValueAt(i, 5).toString();
//        String tempTableHargaJualDetailBarang = tabelDetailBarang.getValueAt(i, 6).toString();
//        String tempTableStokDetailBarang = tabelDetailBarang.getValueAt(i, 7).toString();
//        String tempTableStatusUser = (String) tabelDetailBarang.getValueAt(i, 8);
//        
//        kotakIdDetailBarang.setText(tempTableIdDetailBarang);
//        comboBarang.setSelectedItem(tempTableNamaBarang);
//        kotakSatuan.setText(tempTableSatuanDetailBarang);
//        kotakHargaBeli.setText(tempTableHargaBeliDetailBarang);
//        kotakHargaJual.setText(tempTableHargaJualDetailBarang);
//        kotakStok.setText(tempTableStokDetailBarang);
//        if (tempTableStatusUser.equals("aktif")) {
//            comboStatus.setSelectedIndex(1);
//        } else if (tempTableStatusUser.equals("tidak aktif")) {
//            comboStatus.setSelectedIndex(2);
//        }
//        kotakIdDetailBarang.setEnabled(false);
//        comboBarang.setEnabled(false);

    }//GEN-LAST:event_tabelDaftarBarangMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new viewBarangKasir().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tabel;
    private javax.swing.JTable tabelDaftarBarang;
    private javax.swing.JPanel title;
    private javax.swing.JButton tombolRefresh;
    // End of variables declaration//GEN-END:variables
}
