/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import config.Koneksi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fawzanpriatmana
 */
public class viewAppKasirJual extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewAppKasirJual.class.getName());

    /**
     * Creates new form viewAppKasir
     */
    public viewAppKasirJual() {
        initComponents();
        dataListBarang();
        dataDetailTransaksi();
        this.setLocationRelativeTo(null);
    }
    
    private void dataListBarang() {
        DefaultTableModel tabelBarang = new DefaultTableModel();
        tabelBarang.addColumn("ID Detail Barang");
        tabelBarang.addColumn("Nama Barang");
        tabelBarang.addColumn("Satuan");
        tabelBarang.addColumn("Harga");
        tabelBarang.addColumn("Stok");
        this.tabelBarang.setModel(tabelBarang);
        
        try {
            Koneksi koneksiTampilTabel = new Koneksi();

            String sql = "SELECT detail_barang.id_detail_barang, barang.nama_brg, detail_barang.satuan, detail_barang.harga_jual, detail_barang.stok "
                    + "FROM barang INNER JOIN detail_barang "
                    + "ON barang.id_barang = detail_barang.id_barang "
                    + "WHERE detail_barang.status = 'aktif' "
                    + "ORDER BY barang.nama_brg ASC";

            Statement stmt = koneksiTampilTabel.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                tabelBarang.addRow(new Object[]{
                    rs.getString("id_detail_barang"),
                    rs.getString("nama_brg"),
                    rs.getString("satuan"),
                    rs.getString("harga_jual"),
                    rs.getString("stok")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void dataDetailTransaksi() {
        DefaultTableModel tabelListDetailTransaksi = new DefaultTableModel();
        tabelListDetailTransaksi.addColumn("ID Detail Jual");
        tabelListDetailTransaksi.addColumn("ID Detail Barang");
        tabelListDetailTransaksi.addColumn("Nama Barang");
        tabelListDetailTransaksi.addColumn("Satuan");
        tabelListDetailTransaksi.addColumn("Harga");
        tabelListDetailTransaksi.addColumn("Qty");
        tabelListDetailTransaksi.addColumn("Total Harga");
        this.tabelListDetailTransaksi.setModel(tabelListDetailTransaksi);

        long totalBelanjaKeseluruhan = 0;

        try {
            Koneksi koneksiTampilTabelDetailTransaksi = new Koneksi();

            String sql = "SELECT "
                    + "detail_penjualan.id_detail_jual, "
                    + "detail_penjualan.id_detail_brg, "
                    + "barang.nama_brg, "
                    + "detail_barang.satuan, "
                    + "detail_penjualan.harga, "
                    + "detail_penjualan.qty, "
                    + "(detail_penjualan.harga * detail_penjualan.qty) AS total_harga "
                    + "FROM detail_penjualan "
                    + "JOIN detail_barang ON detail_penjualan.id_detail_brg = detail_barang.id_detail_barang "
                    + "JOIN barang ON detail_barang.id_barang = barang.id_barang "
                    + "WHERE detail_penjualan.id_jual = ?";

            java.sql.PreparedStatement pstmt = koneksiTampilTabelDetailTransaksi.prepareStatement(sql);

            pstmt.setString(1, kotakTransaksiJual.getText());

            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int totalPerBaris = rs.getInt("total_harga");
                totalBelanjaKeseluruhan += totalPerBaris;

                tabelListDetailTransaksi.addRow(new Object[]{
                    rs.getString("id_detail_jual"),
                    rs.getString("id_detail_brg"),
                    rs.getString("nama_brg"),
                    rs.getString("satuan"),
                    rs.getInt("harga"),
                    rs.getInt("qty"),
                    totalPerBaris
                });
            }

            kotakTotalHarga.setText(String.valueOf(totalBelanjaKeseluruhan));

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal ambil data: " + e.getMessage());
            e.printStackTrace();
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
        tombolTransaksiBaru = new javax.swing.JButton();
        kotakTransaksiJual = new javax.swing.JTextField();
        kotakIdDetailBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        kotakCariBarang = new javax.swing.JTextField();
        tombolCariBarang = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        kotakHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kotakQty = new javax.swing.JTextField();
        tombolMasukList = new javax.swing.JButton();
        tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelListDetailTransaksi = new javax.swing.JTable();
        tombolEditList = new javax.swing.JButton();
        tombolSelesaiTransaksi = new javax.swing.JButton();
        kotakTotalHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kotakIdDetailJualList = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        kotakNamaBarangList = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kotakQtyList = new javax.swing.JTextField();
        tombolHapusList = new javax.swing.JButton();
        kotakUangDiterima = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listStruk = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Program Kasir Penjualan");

        title.setPreferredSize(new java.awt.Dimension(400, 133));

        jLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 36)); // NOI18N
        jLabel2.setText("TOKO NAWIR");

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 2, 18)); // NOI18N
        jLabel1.setText("Kasir");

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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel5.setText("ID Detail Barang");

        tombolTransaksiBaru.setText("Transaksi Baru");
        tombolTransaksiBaru.addActionListener(this::tombolTransaksiBaruActionPerformed);

        kotakIdDetailBarang.setEditable(false);

        jLabel7.setText("Pilih Barang");

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Detail Barang", "Nama Barang", "Satuan", "Harga", "Stok"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        tombolCariBarang.setText("Cari Barang");
        tombolCariBarang.addActionListener(this::tombolCariBarangActionPerformed);

        jLabel6.setText("Harga (Satuan)");

        kotakHarga.setEditable(false);

        jLabel8.setText("Qty");

        tombolMasukList.setText("Masuk List (+)");
        tombolMasukList.addActionListener(this::tombolMasukListActionPerformed);

        javax.swing.GroupLayout formBarangLayout = new javax.swing.GroupLayout(formBarang);
        formBarang.setLayout(formBarangLayout);
        formBarangLayout.setHorizontalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formBarangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formBarangLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(kotakCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tombolCariBarang)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(formBarangLayout.createSequentialGroup()
                        .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formBarangLayout.createSequentialGroup()
                                    .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8))
                                    .addGap(18, 18, 18)
                                    .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kotakQty, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(formBarangLayout.createSequentialGroup()
                                            .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kotakHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(kotakIdDetailBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tombolMasukList)))))
                            .addGroup(formBarangLayout.createSequentialGroup()
                                .addComponent(tombolTransaksiBaru)
                                .addGap(26, 26, 26)
                                .addComponent(kotakTransaksiJual, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        formBarangLayout.setVerticalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBarangLayout.createSequentialGroup()
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolTransaksiBaru)
                    .addComponent(kotakTransaksiJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(kotakCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCariBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kotakIdDetailBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolMasukList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kotakHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(kotakQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tabelListDetailTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Detail Transaksi", "ID Detail Barang", "Nama Barang", "Satuan", "Harga", "Qty", "Harga (Total)"
            }
        ));
        tabelListDetailTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelListDetailTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelListDetailTransaksi);

        tombolEditList.setText("Edit List Barang");
        tombolEditList.addActionListener(this::tombolEditListActionPerformed);

        tombolSelesaiTransaksi.setText("Selesai Transaksi");
        tombolSelesaiTransaksi.addActionListener(this::tombolSelesaiTransaksiActionPerformed);

        kotakTotalHarga.setFont(new java.awt.Font("Adwaita Sans", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        jLabel9.setText("Total Harga (Rp.)");

        jLabel10.setText("ID Detail Jual");

        kotakIdDetailJualList.setEditable(false);

        jLabel11.setText("Nama Barang");

        kotakNamaBarangList.setEditable(false);

        jLabel12.setText("Qty");

        tombolHapusList.setText("Hapus List Barang");
        tombolHapusList.addActionListener(this::tombolHapusListActionPerformed);

        jLabel13.setText("Uang Diterima");

        javax.swing.GroupLayout tabelLayout = new javax.swing.GroupLayout(tabel);
        tabel.setLayout(tabelLayout);
        tabelLayout.setHorizontalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(kotakTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kotakNamaBarangList)
                            .addComponent(kotakIdDetailJualList)
                            .addGroup(tabelLayout.createSequentialGroup()
                                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(kotakQtyList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelLayout.createSequentialGroup()
                        .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tombolSelesaiTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabelLayout.createSequentialGroup()
                                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tombolEditList)
                                    .addComponent(tombolHapusList))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addComponent(kotakUangDiterima)
                        .addContainerGap())))
        );
        tabelLayout.setVerticalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotakIdDetailJualList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotakNamaBarangList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotakQtyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolEditList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolHapusList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotakUangDiterima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolSelesaiTransaksi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kotakTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(listStruk);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(formBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(tabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolTransaksiBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTransaksiBaruActionPerformed
        try {
            
            LocalDateTime tanggalHariIniUnformat = LocalDateTime.now();
            DateTimeFormatter tanggalHariIniFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
            String finalTanggalHariIniFormat = tanggalHariIniFormat.format(tanggalHariIniUnformat);
            
            Koneksi koneksiTransaksiBaru = new Koneksi();
            String sqlCekData = "SELECT id_jual "
                    + "FROM transaksi_penjualan "
                    + "WHERE id_jual LIKE 'TJL-"+finalTanggalHariIniFormat+"-%' "
                    + "ORDER BY id_jual DESC LIMIT 1";
            Statement stmt = koneksiTransaksiBaru.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCekData);
            
            String noUrutIdJual;
            
            if (rs.next()) {
                String idJual = rs.getString("id_jual");
                int nomor = Integer.parseInt(idJual.substring(13));
                nomor++;
                
                noUrutIdJual = String.format("TJL-"+finalTanggalHariIniFormat+"-%04d", nomor);
                kotakTransaksiJual.setText(noUrutIdJual);
            } else {
                kotakTransaksiJual.setText("TJL-"+finalTanggalHariIniFormat+"-0001");
            }
            
            String sqlInsert = "INSERT INTO transaksi_penjualan VALUES "
                    + "(?, NOW(), 0)";
            PreparedStatement pstmt = koneksiTransaksiBaru.prepareStatement(sqlInsert);
            pstmt.setString(1, kotakTransaksiJual.getText());
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Berhasil membuat transaksi baru "
                    + "("+kotakTransaksiJual.getText()+")");
            System.out.println("ID Transaksi: " + kotakTransaksiJual.getText());
            System.out.println("Tanggal Transaksi: " + finalTanggalHariIniFormat);
            System.out.println();
            kotakTransaksiJual.setEditable(false);
            tombolTransaksiBaru.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolTransaksiBaruActionPerformed

    private void tombolMasukListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolMasukListActionPerformed
        
        String idTransaksiJual = kotakTransaksiJual.getText();
        String idDetailBarang = kotakIdDetailBarang.getText();
        String qty = kotakQty.getText();
        
        if (idTransaksiJual.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan buat transaksi baru terlebih dahulu",
                    "ID User Kosong",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        
        if (idDetailBarang.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan pilih barang terlebih dahulu",
                    "ID Detail Barang Kosong",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        
        if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukan jumlah barang!",
                    "Jumlah Barang (Qty) Kosong",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        try {
            Koneksi koneksiList = new Koneksi();
            
            String sqlCekList = "SELECT id_detail_jual FROM detail_penjualan "
                    + "WHERE id_detail_jual LIKE ? "
                    + "ORDER BY id_detail_jual DESC "
                    + "LIMIT 1";
            PreparedStatement pstmtCekList = koneksiList.prepareStatement(sqlCekList);
            pstmtCekList.setString(1, "D" + kotakTransaksiJual.getText() + "-%");
            ResultSet rs = pstmtCekList.executeQuery();
            
            String idDetailJual;
            String noUrutIdDetailJual;
            if (rs.next()) {
                idDetailJual = rs.getString("id_detail_jual");
                String nomorStr = idDetailJual.substring(idDetailJual.length() - 3);
                int nomor = Integer.parseInt(nomorStr);
                nomor++; // Tambah 1
                
                noUrutIdDetailJual = String.format("D"+kotakTransaksiJual.getText()+"-%03d", nomor);
            } else {
                noUrutIdDetailJual = "D"+kotakTransaksiJual.getText()+"-001";
            }
            
            // Untuk insert ke tabel detail penjualan
            String sqlInsert = "INSERT INTO detail_penjualan VALUES "
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement pstmtInsert = koneksiList.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, noUrutIdDetailJual);
            pstmtInsert.setString(2, kotakTransaksiJual.getText());
            pstmtInsert.setString(3, kotakIdDetailBarang.getText());
            pstmtInsert.setInt(4, Integer.parseInt(kotakQty.getText()));
            pstmtInsert.setInt(5, Integer.parseInt(kotakHarga.getText()));
            pstmtInsert.executeUpdate();
            
            System.out.println("ID (Detail) Penjualan: " + noUrutIdDetailJual);
            System.out.println("ID (Master) Penjualan: " + kotakTransaksiJual.getText());
            System.out.println("ID Barang: " + kotakIdDetailBarang.getText());
            System.out.println("Qty: " + kotakQty.getText());
            System.out.println("Harga: " + kotakHarga.getText());
            System.out.println();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        kotakIdDetailJualList.setText(null);
        kotakNamaBarangList.setText(null);
        kotakQtyList.setText(null);
        kotakIdDetailBarang.setText(null);
        kotakHarga.setText(null);
        kotakQty.setText(null);
        dataDetailTransaksi();
        dataListBarang();
    }//GEN-LAST:event_tombolMasukListActionPerformed

    private void tabelListDetailTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelListDetailTransaksiMouseClicked
        int i = tabelListDetailTransaksi.getSelectedRow();

        String tempTableIdDetailJual = tabelListDetailTransaksi.getValueAt(i, 0).toString();
        String tempTableNamaBarang = tabelListDetailTransaksi.getValueAt(i, 2).toString();
        String tempTableQty = tabelListDetailTransaksi.getValueAt(i, 5).toString();
        
        kotakIdDetailJualList.setText(tempTableIdDetailJual);
        kotakNamaBarangList.setText(tempTableNamaBarang);
        kotakQtyList.setText(tempTableQty);
    }//GEN-LAST:event_tabelListDetailTransaksiMouseClicked

    private void tombolCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariBarangActionPerformed
        DefaultTableModel tabelCariBarang = new DefaultTableModel();
        tabelCariBarang.addColumn("ID Barang");
        tabelCariBarang.addColumn("Nama Barang");
        tabelCariBarang.addColumn("Satuan");
        tabelCariBarang.addColumn("Harga");
        tabelCariBarang.addColumn("Stok");
        tabelBarang.setModel(tabelCariBarang);

        try {
            Koneksi koneksiTampilTabel = new Koneksi();

            String sql = "SELECT detail_barang.id_detail_barang, barang.nama_brg, detail_barang.satuan, detail_barang.harga_jual, detail_barang.stok "
                    + "FROM barang INNER JOIN detail_barang "
                    + "ON barang.id_barang = detail_barang.id_barang "
                    + "WHERE barang.nama_brg LIKE ? " // Tambahkan spasi sebelum ORDER BY
                    + "ORDER BY barang.nama_brg ASC";

            PreparedStatement pstmt = koneksiTampilTabel.prepareStatement(sql);
            pstmt.setString(1, kotakCariBarang.getText()+"%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                tabelCariBarang.addRow(new Object[]{
                    rs.getString("id_detail_barang"),
                    rs.getString("nama_brg"),
                    rs.getString("satuan"),
                    rs.getString("harga_jual"),
                    rs.getString("stok")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolCariBarangActionPerformed

    private void tombolEditListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditListActionPerformed
        try {
            Koneksi koneksiDetailJualEdit = new Koneksi();
            String sqlUpdate = "UPDATE detail_penjualan SET "
                    + "qty = ? "
                    + "WHERE id_detail_jual = ?";
            PreparedStatement pstmtUpdate = koneksiDetailJualEdit.prepareStatement(sqlUpdate);
            pstmtUpdate.setString(1, kotakQtyList.getText());
            pstmtUpdate.setString(2, kotakIdDetailJualList.getText());
            pstmtUpdate.executeUpdate();
            System.out.println("Edit list barang dengan id (" + kotakIdDetailJualList.getText() + ")\n"
                    + "Ubah qty barang menjadi "+kotakQtyList.getText());

            kotakIdDetailJualList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            dataDetailTransaksi();
            dataListBarang();

            dataDetailTransaksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolEditListActionPerformed

    private void tombolSelesaiTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSelesaiTransaksiActionPerformed
        int confirmTransaksiBaru = JOptionPane.showConfirmDialog(this,
                "Apakah ingin menyelesaikan transaksi ini?\n"
                        + "Anda tidak dapat mengakses dengan transaksi ini lagi.",
                "Konfirmasi Transaksi Selesai",
                JOptionPane.YES_NO_OPTION
        );
        
        String idTransaksiJual = kotakTransaksiJual.getText();
        
        if (idTransaksiJual.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Tidak ada transaksi sama sekali!",
                    "Tidak ada Transaksi",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        
        if (kotakUangDiterima.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silakan masukan uang diterima",
                    "Uang Diterima Tidak Ada",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        
        int ambilKomponenTotalHarga = Integer.parseInt(kotakTotalHarga.getText());
        int ambilKomponenUangDiterima = Integer.parseInt(kotakUangDiterima.getText());
        
        if (ambilKomponenTotalHarga > ambilKomponenUangDiterima) {
            JOptionPane.showMessageDialog(
                    this,
                    "Uang diterima kurang dari total harga",
                    "Uang Diterima Kurang",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        if (confirmTransaksiBaru == 0) {
            JOptionPane.showMessageDialog(this,
                    "Transaksi dengan ID Transaksi Jual ("+kotakTransaksiJual.getText()+") "
                            + "telah selesai.\nSilahkan tekan tombol transaksi baru untuk "
                            + "memulai transaksi baru :)",
                    "Transaksi Telah Selesai",
                    JOptionPane.INFORMATION_MESSAGE
            );
            try {
                Koneksi koneksiUpdateMaster = new Koneksi();
                String sqlMasterTransaksiUpdate = "UPDATE transaksi_penjualan "
                        + "SET uang_diterima = ? "
                        + "WHERE id_jual = ?";
                PreparedStatement pstmtDataMasterTransaksiUpdate
                        = koneksiUpdateMaster.prepareStatement(sqlMasterTransaksiUpdate);
                pstmtDataMasterTransaksiUpdate.setInt(1, Integer.parseInt(kotakUangDiterima.getText()));
                pstmtDataMasterTransaksiUpdate.setString(2, kotakTransaksiJual.getText());
                pstmtDataMasterTransaksiUpdate.executeUpdate();

                Koneksi koneksiTampilStruk = new Koneksi();
                DefaultListModel listStruk = new DefaultListModel();

                String sqlMasterTransaksi = "SELECT * "
                        + "FROM laporan_penjualan "
                        + "WHERE id_jual = ? "
                        + "ORDER BY tanggal DESC LIMIT 1";
                PreparedStatement pstmtDataMasterTransaksi
                        = koneksiTampilStruk.prepareStatement(sqlMasterTransaksi);
                pstmtDataMasterTransaksi.setString(1, kotakTransaksiJual.getText());
                ResultSet rsDataMasterTransaksi = pstmtDataMasterTransaksi.executeQuery();

                String sqlDetailTransaksi = "SELECT * "
                        + "FROM laporan_detail_penjualan "
                        + "WHERE id_jual = ? "
                        + "ORDER BY id_detail_jual";
                PreparedStatement pstmtDataDetailTransaksi
                        = koneksiTampilStruk.prepareStatement(sqlDetailTransaksi);
                pstmtDataDetailTransaksi.setString(1, kotakTransaksiJual.getText());
                ResultSet rsDataDetailTransaksi = pstmtDataDetailTransaksi.executeQuery();

                String idTransaksi = null,
                        tanggal = null,
                        totalFinalBarang = null,
                        uangDiterima = null,
                        uangKembalian = null;
                if (rsDataMasterTransaksi.next()) {
                    idTransaksi = rsDataMasterTransaksi.getString("id_jual");
                    tanggal = rsDataMasterTransaksi.getString("tanggal");
                    totalFinalBarang = rsDataMasterTransaksi.getString("total_harga_barang");
                    uangDiterima = rsDataMasterTransaksi.getString("uang_diterima");
                    uangKembalian = rsDataMasterTransaksi.getString("uang_kembalian");
                }

                listStruk.addElement("-------------------------------------------------------");
                listStruk.addElement("  TOKO NAWIR");
                listStruk.addElement("-------------------------------------------------------");
                listStruk.addElement("  Tanggal            : " + tanggal);
                listStruk.addElement("  ID Transaksi    : " + idTransaksi);
                listStruk.addElement("-------------------------------------------------------");
                while (rsDataDetailTransaksi.next()) {
                    String namaBarang = rsDataDetailTransaksi.getString("nama_brg");
                    String qtyBarang = rsDataDetailTransaksi.getString("qty");
                    String hargaBarang = rsDataDetailTransaksi.getString("harga");
                    String totalHargaBarang = rsDataDetailTransaksi.getString("total_harga_barang");

                    listStruk.addElement("  - " + namaBarang);
                    listStruk.addElement("    " + qtyBarang + " x " + hargaBarang + " = Rp " + totalHargaBarang);
                }
                listStruk.addElement("-------------------------------------------------------");
                listStruk.addElement("  Total Harga            : Rp " + totalFinalBarang);
                listStruk.addElement("  Uang Diterima       : Rp " + uangDiterima);
                listStruk.addElement("  Uang Kembalian    : Rp " + uangKembalian);
                listStruk.addElement("-------------------------------------------------------");
                this.listStruk.setModel(listStruk);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
                e.printStackTrace();
            }

            DefaultTableModel tabelListDetailTransaksiHapusIsi
                    = (DefaultTableModel) tabelListDetailTransaksi.getModel();
            tabelListDetailTransaksiHapusIsi.setRowCount(0);
            kotakIdDetailJualList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            kotakTotalHarga.setText(null);
            kotakTransaksiJual.setText(null);
            tombolTransaksiBaru.setEnabled(true);
        }
        
    }//GEN-LAST:event_tombolSelesaiTransaksiActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int i = tabelBarang.getSelectedRow();
        
        String tempTableIdBarang = tabelBarang.getValueAt(i, 0).toString();
        String tempTableHargaBarang = tabelBarang.getValueAt(i, 3).toString();
        
        kotakIdDetailBarang.setText(tempTableIdBarang);
        kotakHarga.setText(tempTableHargaBarang);
        
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void tombolHapusListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusListActionPerformed
        try {
            Koneksi koneksiDetailJualHapus = new Koneksi();
            String sqlDelete = "DELETE FROM detail_penjualan "
                    + "WHERE id_detail_jual = ?";
            PreparedStatement pstmtHapus = koneksiDetailJualHapus.prepareStatement(sqlDelete);
            pstmtHapus.setString(1, kotakIdDetailJualList.getText());
            pstmtHapus.executeUpdate();
            System.out.println("Hapus list barang dengan id (" + kotakIdDetailJualList.getText() + ")");
            
            kotakIdDetailJualList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            dataDetailTransaksi();
            dataListBarang();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolHapusListActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new viewAppKasirJual().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField kotakCariBarang;
    private javax.swing.JTextField kotakHarga;
    private javax.swing.JTextField kotakIdDetailBarang;
    private javax.swing.JTextField kotakIdDetailJualList;
    private javax.swing.JTextField kotakNamaBarangList;
    private javax.swing.JTextField kotakQty;
    private javax.swing.JTextField kotakQtyList;
    private javax.swing.JTextField kotakTotalHarga;
    private javax.swing.JTextField kotakTransaksiJual;
    private javax.swing.JTextField kotakUangDiterima;
    private javax.swing.JList<String> listStruk;
    private javax.swing.JPanel tabel;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelListDetailTransaksi;
    private javax.swing.JPanel title;
    private javax.swing.JButton tombolCariBarang;
    private javax.swing.JButton tombolEditList;
    private javax.swing.JButton tombolHapusList;
    private javax.swing.JButton tombolMasukList;
    private javax.swing.JButton tombolSelesaiTransaksi;
    private javax.swing.JButton tombolTransaksiBaru;
    // End of variables declaration//GEN-END:variables
}
