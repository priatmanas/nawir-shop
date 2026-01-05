package main.admin;

import config.Koneksi;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fawzanpriatmana
 */
public class viewDetailBarangAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewDetailBarangAdmin.class.getName());

    /**
     * Creates new form viewBarang
     */
    public viewDetailBarangAdmin() {
        initComponents();
        tampilBarang();
        dataTabelDetailBarang();
        this.setLocationRelativeTo(null);
    }
    
    private void clearComponents() {
        kotakIdDetailBarang.setText(null);
        comboBarang.setSelectedIndex(0);
        kotakSatuan.setText(null);
        kotakHargaJual.setText(null);
        kotakHargaBeli.setText(null);
        kotakStok.setText(null);
        comboStatus.setSelectedIndex(0);
        kotakIdDetailBarang.setEnabled(true);
        comboBarang.setEnabled(true);
    }
    
    private void tampilBarang() {
        DefaultComboBoxModel comboBarang = new DefaultComboBoxModel();
        comboBarang.addElement("-- Pilih --");
        
        try {
            Koneksi koneksiTampilBarang = new Koneksi();
            String sqlBarang = "SELECT nama_brg FROM barang "
                    + "ORDER BY nama_brg ASC";
            
            Statement stmt = koneksiTampilBarang.createStatement();
            ResultSet rs = stmt.executeQuery(sqlBarang);
            
            while (rs.next()) {                
                comboBarang.addElement(
                        rs.getString("nama_brg")
                );
            }
            this.comboBarang.setModel(comboBarang);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void dataTabelDetailBarang() {
        
        DefaultTableModel tabelDetailBarang = new DefaultTableModel();
        tabelDetailBarang.addColumn("ID Detail Barang");
        tabelDetailBarang.addColumn("ID Barang");
        tabelDetailBarang.addColumn("Nama Barang");
        tabelDetailBarang.addColumn("Kategori Barang");
        tabelDetailBarang.addColumn("Satuan");
        tabelDetailBarang.addColumn("Harga Jual");
        tabelDetailBarang.addColumn("Harga Beli");
        tabelDetailBarang.addColumn("Stok");
        tabelDetailBarang.addColumn("Status");
        this.tabelDetailBarang.setModel(tabelDetailBarang);

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
                tabelDetailBarang.addRow(new Object[]{
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
    
    private void autoIdDetailBarang() {
        try {
            Koneksi koneksiAutoIdBarang = new Koneksi();
            String sql = "SELECT id_detail_barang "
                    + "FROM detail_barang "
                    + "ORDER BY id_detail_barang "
                    + "DESC LIMIT 1";

            Statement st = koneksiAutoIdBarang.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String id_user = rs.getString("id_detail_barang");
                int nomor = Integer.parseInt(id_user.substring(1));
                nomor++;

                String no_urut = String.format("D%04d", nomor);
                kotakIdDetailBarang.setText(no_urut);
            } else {
                kotakIdDetailBarang.setText("D0001");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal generate ID Barang!");
        }
    }

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
        formBarang = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tombolSimpan = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        comboBarang = new javax.swing.JComboBox<>();
        kotakIdDetailBarang = new javax.swing.JTextField();
        kotakHargaJual = new javax.swing.JTextField();
        kotakStok = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox<>();
        tombolBaru = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        kotakHargaBeli = new javax.swing.JTextField();
        kotakBarang = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        kotakSatuan = new javax.swing.JTextField();
        tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDetailBarang = new javax.swing.JTable();
        tombolRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Barang [Admin]");
        setAlwaysOnTop(true);

        title.setPreferredSize(new java.awt.Dimension(400, 133));

        jLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 36)); // NOI18N
        jLabel2.setText("TOKO NAWIR");

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 2, 18)); // NOI18N
        jLabel1.setText("Detail Barang");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel5.setText("ID Detail Barang");

        jLabel6.setText("Satuan");

        jLabel7.setText("Harga (Jual)");

        jLabel8.setText("Stok");

        jLabel9.setText("Status");

        tombolSimpan.setText("Tambah");
        tombolSimpan.addActionListener(this::tombolSimpanActionPerformed);

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(this::tombolUbahActionPerformed);

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(this::tombolHapusActionPerformed);

        comboBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "Aktif", "Tidak Aktif" }));

        tombolBaru.setText("Baru");
        tombolBaru.addActionListener(this::tombolBaruActionPerformed);

        jLabel10.setText("Harga (Beli)");

        kotakBarang.setText("Barang");
        kotakBarang.addActionListener(this::kotakBarangActionPerformed);

        jLabel11.setText("Pilih Barang");

        javax.swing.GroupLayout formBarangLayout = new javax.swing.GroupLayout(formBarang);
        formBarang.setLayout(formBarangLayout);
        formBarangLayout.setHorizontalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBarangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolBaru)
                    .addGroup(formBarangLayout.createSequentialGroup()
                        .addComponent(tombolSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolHapus))
                    .addGroup(formBarangLayout.createSequentialGroup()
                        .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(41, 41, 41)
                        .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kotakHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kotakStok, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kotakHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kotakSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formBarangLayout.createSequentialGroup()
                                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(kotakIdDetailBarang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBarang, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotakBarang)))))
                .addContainerGap())
        );
        formBarangLayout.setVerticalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBarangLayout.createSequentialGroup()
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kotakIdDetailBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotakBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kotakSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(kotakHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(kotakHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(kotakStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolUbah)
                    .addComponent(tombolHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombolBaru)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tabelDetailBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Kategori", "Satuan", "Harga", "Stok", "Status"
            }
        ));
        tabelDetailBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDetailBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDetailBarang);

        tombolRefresh.setText("Refresh");
        tombolRefresh.addActionListener(this::tombolRefreshActionPerformed);

        javax.swing.GroupLayout tabelLayout = new javax.swing.GroupLayout(tabel);
        tabel.setLayout(tabelLayout);
        tabelLayout.setHorizontalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGap(0, 802, Short.MAX_VALUE)
                        .addComponent(tombolRefresh))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
        );
        tabelLayout.setVerticalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tombolRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        
        String idDetailBarang = kotakIdDetailBarang.getText();
        String namaBarangDipilih = comboBarang.getSelectedItem().toString();
        String satuanDetailBarang = kotakSatuan.getText();
        String hargaJualDetailBarang = kotakHargaJual.getText();
        String hargaBeliDetailBarang = kotakHargaBeli.getText();
        String stokDetailBarang = kotakStok.getText();
        String statusDetailBarang = comboStatus.getSelectedItem().toString();

        if (statusDetailBarang.equals("-- Pilih --")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan pilih statusnya (Aktif/Tidak Aktif)",
                    "Pilih Status",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        try {
            Koneksi koneksiDetailBarangSimpan = new Koneksi();
            String idBarang = "";
            String namaBarang = "";

            String sqlAmbilBarang = "SELECT id_barang, nama_brg FROM barang "
                    + "WHERE nama_brg = ?";
            PreparedStatement pstmtAmbilBarang
                    = koneksiDetailBarangSimpan.prepareStatement(sqlAmbilBarang);
            pstmtAmbilBarang.setString(1, namaBarangDipilih);
            ResultSet rsAmbilBarang = pstmtAmbilBarang.executeQuery();

            if (rsAmbilBarang.next()) {
                idBarang = rsAmbilBarang.getString("id_barang");
                namaBarang = rsAmbilBarang.getString("nama_brg");
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "Barang tidak ditemukan di database!"
                );
                return;
            }

            String sqlInsert = "INSERT INTO detail_barang VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmtInsert
                    = koneksiDetailBarangSimpan.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, idDetailBarang);
            pstmtInsert.setString(2, idBarang);
            pstmtInsert.setString(3, satuanDetailBarang);
            pstmtInsert.setString(4, hargaJualDetailBarang);
            pstmtInsert.setString(5, hargaBeliDetailBarang);
            pstmtInsert.setString(6, stokDetailBarang);
            pstmtInsert.setString(7, statusDetailBarang);
            pstmtInsert.executeUpdate();

            JOptionPane.showMessageDialog(this, "Berhasil menyimpan detail "
                    + namaBarang + " ("+ idBarang + ")");
            System.out.println("ID Detail Barang: " + idDetailBarang);
            System.out.println("ID Barang: " + idBarang + "("+namaBarang+")");
            System.out.println("Satuan Detail Barang: " + satuanDetailBarang);
            System.out.println("Harga Jual Detail Barang: " + hargaJualDetailBarang);
            System.out.println("Harga Beli Detail Barang: " + hargaBeliDetailBarang);
            System.out.println("Stok Detail Barang: " + stokDetailBarang);
            System.out.println("Status Detail Barang: " + statusDetailBarang);
            System.out.println();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        dataTabelDetailBarang();
        clearComponents();

//        System.out.println("ID : "+kotakIdUser.getText());
//        System.out.println("Nama : "+kotakNama.getText());
//        System.out.println("Usernama : "+kotakUsername.getText());
//        System.out.println("Password : "+kotakPassword.getText());
//        System.out.println("Status : "+comboStatus.getSelectedItem().toString());

    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        clearComponents();
        autoIdDetailBarang();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void kotakBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kotakBarangActionPerformed
        viewBarangAdmin tampilBarangAdmin = new viewBarangAdmin();
        tampilBarangAdmin.setVisible(true);
    }//GEN-LAST:event_kotakBarangActionPerformed

    private void tombolRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolRefreshActionPerformed
        tampilBarang();
        dataTabelDetailBarang();
    }//GEN-LAST:event_tombolRefreshActionPerformed

    private void tabelDetailBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDetailBarangMouseClicked
        int i = tabelDetailBarang.getSelectedRow();
        
        String tempTableIdDetailBarang = tabelDetailBarang.getValueAt(i, 0).toString();
        String tempTableNamaBarang = tabelDetailBarang.getValueAt(i, 2).toString();
        String tempTableSatuanDetailBarang = tabelDetailBarang.getValueAt(i, 4).toString();
        String tempTableHargaBeliDetailBarang = tabelDetailBarang.getValueAt(i, 5).toString();
        String tempTableHargaJualDetailBarang = tabelDetailBarang.getValueAt(i, 6).toString();
        String tempTableStokDetailBarang = tabelDetailBarang.getValueAt(i, 7).toString();
        String tempTableStatusUser = (String) tabelDetailBarang.getValueAt(i, 8);
        
        kotakIdDetailBarang.setText(tempTableIdDetailBarang);
        comboBarang.setSelectedItem(tempTableNamaBarang);
        kotakSatuan.setText(tempTableSatuanDetailBarang);
        kotakHargaBeli.setText(tempTableHargaBeliDetailBarang);
        kotakHargaJual.setText(tempTableHargaJualDetailBarang);
        kotakStok.setText(tempTableStokDetailBarang);
        if (tempTableStatusUser.equals("aktif")) {
            comboStatus.setSelectedIndex(1);
        } else if (tempTableStatusUser.equals("tidak aktif")) {
            comboStatus.setSelectedIndex(2);
        }
        kotakIdDetailBarang.setEnabled(false);
        comboBarang.setEnabled(false);

    }//GEN-LAST:event_tabelDetailBarangMouseClicked

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        String idDetailBarang = kotakIdDetailBarang.getText();
        String namaBarang = comboBarang.getSelectedItem().toString();
        
        try {
            Koneksi koneksiDetailBarangHapus = new Koneksi();

            String sqlInsert = "DELETE FROM detail_barang WHERE "
                    + "id_detail_barang = ?";

            PreparedStatement pstmt = koneksiDetailBarangHapus.prepareStatement(sqlInsert);
            pstmt.setString(1, idDetailBarang);

            int confirmDelete = JOptionPane.showConfirmDialog(this,
                    "Apakah ingin menghapus barang dengan nama "
                    + namaBarang + " (" + idDetailBarang + ")?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmDelete == 0) {
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Berhasil menghapus " + namaBarang + " ("
                        + idDetailBarang + ")");
                System.out.println("Hapus barang dengan id (" + idDetailBarang + ")");
                System.out.println();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        dataTabelDetailBarang();
        clearComponents();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        String idDetailBarang = kotakIdDetailBarang.getText();
        String namaBarangDipilih = comboBarang.getSelectedItem().toString();
        String satuanDetailBarang = kotakSatuan.getText();
        String hargaJualDetailBarang = kotakHargaJual.getText();
        String hargaBeliDetailBarang = kotakHargaBeli.getText();
        String stokDetailBarang = kotakStok.getText();
        String statusDetailBarang = comboStatus.getSelectedItem().toString();

        if (statusDetailBarang.equals("-- Pilih --")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan pilih statusnya (Aktif/Tidak Aktif)",
                    "Pilih Status",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            Koneksi koneksiDetailBarangUpdate = new Koneksi();
            String idBarang = "";
            String namaBarang = "";

            String sqlAmbilBarang = "SELECT id_barang, nama_brg FROM barang "
                    + "WHERE nama_brg = ?";
            PreparedStatement pstmtAmbilBarang
                    = koneksiDetailBarangUpdate.prepareStatement(sqlAmbilBarang);
            pstmtAmbilBarang.setString(1, namaBarangDipilih);
            ResultSet rsAmbilBarang = pstmtAmbilBarang.executeQuery();

            if (rsAmbilBarang.next()) {
                idBarang = rsAmbilBarang.getString("id_barang");
                namaBarang = rsAmbilBarang.getString("nama_brg");
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "Barang tidak ditemukan di database!"
                );
                return;
            }

            String sqlUpdate = "UPDATE detail_barang SET "
                    + "satuan = ?, "
                    + "harga_jual = ?, "
                    + "harga_beli = ?, "
                    + "stok = ?, "
                    + "status = ? "
                    + "WHERE id_detail_barang = ?";
            PreparedStatement pstmtInsert
                    = koneksiDetailBarangUpdate.prepareStatement(sqlUpdate);
            pstmtInsert.setString(1, satuanDetailBarang);
            pstmtInsert.setString(2, hargaJualDetailBarang);
            pstmtInsert.setString(3, hargaBeliDetailBarang);
            pstmtInsert.setString(4, stokDetailBarang);
            pstmtInsert.setString(5, statusDetailBarang);
            pstmtInsert.setString(6, idDetailBarang);
            pstmtInsert.executeUpdate();

            JOptionPane.showMessageDialog(this, "Berhasil update detail "
                    + namaBarang + " (" + idBarang + ")");
            System.out.println("ID Detail Barang: " + idDetailBarang);
            System.out.println("ID Barang: " + idBarang + "(" + namaBarang + ")");
            System.out.println("Satuan Detail Barang: " + satuanDetailBarang);
            System.out.println("Harga Jual Detail Barang: " + hargaJualDetailBarang);
            System.out.println("Harga Beli Detail Barang: " + hargaBeliDetailBarang);
            System.out.println("Stok Detail Barang: " + stokDetailBarang);
            System.out.println("Status Detail Barang: " + statusDetailBarang);
            System.out.println();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        dataTabelDetailBarang();
        clearComponents();
    }//GEN-LAST:event_tombolUbahActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new viewDetailBarangAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBarang;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JPanel formBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kotakBarang;
    private javax.swing.JTextField kotakHargaBeli;
    private javax.swing.JTextField kotakHargaJual;
    private javax.swing.JTextField kotakIdDetailBarang;
    private javax.swing.JTextField kotakSatuan;
    private javax.swing.JTextField kotakStok;
    private javax.swing.JPanel tabel;
    private javax.swing.JTable tabelDetailBarang;
    private javax.swing.JPanel title;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolRefresh;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}
