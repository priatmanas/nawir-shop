package main;

import config.Koneksi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fawzanpriatmana
 */
public class viewAppKasirBeli extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewAppKasirBeli.class.getName());

    /**
     * Creates new form viewAppKasir
     */
    public viewAppKasirBeli() {
        initComponents();
        tampilSupplier();
        
        dataListBarang();
        dataDetailTransaksi();
        this.setLocationRelativeTo(null);
    }
    
    private void tampilSupplier() {
        DefaultComboBoxModel comboSupplier = new DefaultComboBoxModel();
        comboSupplier.addElement("-- Pilih --");
        this.comboSupplier.setModel(comboSupplier);
        
        try {
            Koneksi koneksiTampilSupplier = new Koneksi();
            String sqlSupplier = "SELECT id_supplier, nama_suppl "
                    + "FROM supplier "
                    + "WHERE status = 'aktif'"
                    + "ORDER BY id_supplier ASC";
            
            Statement stmtSupplier = koneksiTampilSupplier.createStatement();
            ResultSet rs = stmtSupplier.executeQuery(sqlSupplier);
            
            while (rs.next()) {                
                comboSupplier.addElement(
                        rs.getString("id_supplier")+" - "+rs.getString("nama_suppl"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
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

            String sql = "SELECT detail_barang.id_detail_barang, barang.nama_brg, detail_barang.satuan, detail_barang.harga_beli, detail_barang.stok "
                    + "FROM barang INNER JOIN detail_barang "
                    + "ON barang.id_barang = detail_barang.id_barang "
                    + "WHERE detail_barang.status = 'aktif'"
                    + "ORDER BY barang.nama_brg ASC";

            Statement stmt = koneksiTampilTabel.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                tabelBarang.addRow(new Object[]{
                    rs.getString("id_detail_barang"),
                    rs.getString("nama_brg"),
                    rs.getString("satuan"),
                    rs.getString("harga_beli"),
                    rs.getString("stok"),
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void dataDetailTransaksi() {
        DefaultTableModel tabelListDetailTransaksi = new DefaultTableModel();
        tabelListDetailTransaksi.addColumn("ID Detail Beli");
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
                    + "detail_pembelian.id_detail_beli, "
                    + "detail_pembelian.id_detail_brg, "
                    + "barang.nama_brg, "
                    + "detail_barang.satuan, "
                    + "detail_pembelian.harga, "
                    + "detail_pembelian.qty, "
                    + "(detail_pembelian.harga * detail_pembelian.qty) AS total_harga "
                    + "FROM detail_pembelian "
                    + "JOIN detail_barang ON detail_pembelian.id_detail_brg = detail_barang.id_detail_barang "
                    + "JOIN barang ON detail_barang.id_barang = barang.id_barang "
                    + "WHERE detail_pembelian.id_beli = ?";

            java.sql.PreparedStatement pstmt = koneksiTampilTabelDetailTransaksi.prepareStatement(sql);

            pstmt.setString(1, kotakTransaksiBeli.getText());

            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int totalPerBaris = rs.getInt("total_harga");
                totalBelanjaKeseluruhan += totalPerBaris;

                tabelListDetailTransaksi.addRow(new Object[]{
                    rs.getString("id_detail_beli"),
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
        kotakTransaksiBeli = new javax.swing.JTextField();
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
        jLabel13 = new javax.swing.JLabel();
        comboSupplier = new javax.swing.JComboBox<>();
        tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelListDetailTransaksi = new javax.swing.JTable();
        tombolEditList = new javax.swing.JButton();
        tombolSelesaiTransaksi = new javax.swing.JButton();
        kotakTotalHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kotakIdDetailBeliList = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        kotakNamaBarangList = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kotakQtyList = new javax.swing.JTextField();
        tombolHapusList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Program Kasir Pembelian");

        title.setPreferredSize(new java.awt.Dimension(400, 133));

        jLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 36)); // NOI18N
        jLabel2.setText("TOKO NAWIR");

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 2, 18)); // NOI18N
        jLabel1.setText("Beli Barang");

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
        tombolTransaksiBaru.setEnabled(false);
        tombolTransaksiBaru.addActionListener(this::tombolTransaksiBaruActionPerformed);

        kotakTransaksiBeli.setEditable(false);
        kotakTransaksiBeli.setEnabled(false);

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

        jLabel13.setText("Pilih Supplier");

        comboSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        comboSupplier.addActionListener(this::comboSupplierActionPerformed);

        javax.swing.GroupLayout formBarangLayout = new javax.swing.GroupLayout(formBarang);
        formBarang.setLayout(formBarangLayout);
        formBarangLayout.setHorizontalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBarangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(20, 20, 20)
                                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kotakTransaksiBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(formBarangLayout.createSequentialGroup()
                        .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(formBarangLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(kotakCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tombolCariBarang)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        formBarangLayout.setVerticalGroup(
            formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolTransaksiBaru)
                    .addComponent(kotakTransaksiBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(kotakCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCariBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel10.setText("ID Detail Beli");

        kotakIdDetailBeliList.setEditable(false);

        jLabel11.setText("Nama Barang");

        kotakNamaBarangList.setEditable(false);

        jLabel12.setText("Qty");

        tombolHapusList.setText("Hapus List Barang");
        tombolHapusList.addActionListener(this::tombolHapusListActionPerformed);

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
                            .addComponent(tombolSelesaiTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tabelLayout.createSequentialGroup()
                                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tombolEditList)
                                    .addComponent(tombolHapusList))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kotakNamaBarangList)
                            .addComponent(kotakIdDetailBeliList)
                            .addGroup(tabelLayout.createSequentialGroup()
                                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(kotakQtyList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        tabelLayout.setVerticalGroup(
            tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotakIdDetailBeliList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolSelesaiTransaksi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kotakTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(tabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolTransaksiBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTransaksiBaruActionPerformed
        if (comboSupplier.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silakan pilih supplier terlebih dahulu!",
                    "Pilih Supplier",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        try {
            
            LocalDateTime tanggalHariIniUnformat = LocalDateTime.now();
            DateTimeFormatter tanggalHariIniFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
            String finalTanggalHariIniFormat = tanggalHariIniFormat.format(tanggalHariIniUnformat);
            
            Koneksi koneksiTransaksiBaru = new Koneksi();
            String sqlCekData = "SELECT id_beli "
                    + "FROM transaksi_pembelian "
                    + "WHERE id_beli LIKE 'TBL-"+finalTanggalHariIniFormat+"-%' "
                    + "ORDER BY id_beli DESC LIMIT 1";
            Statement stmt = koneksiTransaksiBaru.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCekData);
            
            String noUrutIdBeli;
            
            if (rs.next()) {
                String idBeli = rs.getString("id_beli");
                int nomor = Integer.parseInt(idBeli.substring(13));
                nomor++;
                
                noUrutIdBeli = String.format("TBL-"+finalTanggalHariIniFormat+"-%04d", nomor);
                kotakTransaksiBeli.setText(noUrutIdBeli);
            } else {
                kotakTransaksiBeli.setText("TBL-"+finalTanggalHariIniFormat+"-0001");
            }
            
            String pilihanSupplier = comboSupplier.getSelectedItem().toString();
            String kodeSupplier = pilihanSupplier.split(" - ")[0];
            
            String sqlInsert = "INSERT INTO transaksi_pembelian VALUES "
                    + "(?, ?, NOW())";
            PreparedStatement pstmt = koneksiTransaksiBaru.prepareStatement(sqlInsert);
            pstmt.setString(1, kotakTransaksiBeli.getText());
            pstmt.setString(2, kodeSupplier);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Berhasil membuat transaksi baru "
                    + "("+kotakTransaksiBeli.getText()+")");
            System.out.println("ID Transaksi: " + kotakTransaksiBeli.getText());
            System.out.println("Tanggal Transaksi: " + finalTanggalHariIniFormat);
            System.out.println();
            kotakTransaksiBeli.setEditable(false);
            tombolTransaksiBaru.setEnabled(false);
            comboSupplier.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolTransaksiBaruActionPerformed

    private void tombolMasukListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolMasukListActionPerformed
        
        String idTransaksiBeli = kotakTransaksiBeli.getText();
        String idDetailBarang = kotakIdDetailBarang.getText();
        String qty = kotakQty.getText();
        
        if (idTransaksiBeli.isEmpty()) {
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
            
            String sqlCekList = "SELECT id_detail_beli FROM detail_pembelian "
                    + "WHERE id_detail_beli LIKE ? "
                    + "ORDER BY id_detail_beli DESC "
                    + "LIMIT 1";
            PreparedStatement pstmtCekList = koneksiList.prepareStatement(sqlCekList);
            pstmtCekList.setString(1, "D" + kotakTransaksiBeli.getText() + "-%");
            ResultSet rs = pstmtCekList.executeQuery();
            
            String idDetailBeli;
            String noUrutIdDetailBeli;
            if (rs.next()) {
                idDetailBeli = rs.getString("id_detail_beli");
                String nomorStr = idDetailBeli.substring(idDetailBeli.length() - 3);
                int nomor = Integer.parseInt(nomorStr);
                nomor++; // Tambah 1
                
                noUrutIdDetailBeli = String.format("D"+kotakTransaksiBeli.getText()+"-%03d", nomor);
            } else {
                noUrutIdDetailBeli = "D"+kotakTransaksiBeli.getText()+"-001";
            }
            
            // Untuk insert ke tabel detail penjualan
            String sqlInsert = "INSERT INTO detail_pembelian VALUES "
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement pstmtInsert = koneksiList.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, noUrutIdDetailBeli);
            pstmtInsert.setString(2, kotakTransaksiBeli.getText());
            pstmtInsert.setString(3, kotakIdDetailBarang.getText());
            pstmtInsert.setInt(4, Integer.parseInt(kotakQty.getText()));
            pstmtInsert.setInt(5, Integer.parseInt(kotakHarga.getText()));
            pstmtInsert.executeUpdate();
            
            System.out.println("ID (Detail) Pembelian: " + noUrutIdDetailBeli);
            System.out.println("ID (Master) Pembelian: " + kotakTransaksiBeli.getText());
            System.out.println("ID Barang: " + kotakIdDetailBarang.getText());
            System.out.println("Qty: " + kotakQty.getText());
            System.out.println("Harga: " + kotakHarga.getText());
            System.out.println();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
        kotakIdDetailBeliList.setText(null);
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
        
        kotakIdDetailBeliList.setText(tempTableIdDetailJual);
        kotakNamaBarangList.setText(tempTableNamaBarang);
        kotakQtyList.setText(tempTableQty);
    }//GEN-LAST:event_tabelListDetailTransaksiMouseClicked

    private void tombolCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariBarangActionPerformed
        DefaultTableModel tabelCariBarang = new DefaultTableModel();
        tabelCariBarang.addColumn("ID Barang");
        tabelCariBarang.addColumn("Nama Barang");
        tabelCariBarang.addColumn("Satuan");
        tabelCariBarang.addColumn("Harga");
        tabelBarang.setModel(tabelCariBarang);

        try {
            Koneksi koneksiTampilTabel = new Koneksi();

            String sql = "SELECT detail_barang.id_detail_barang, barang.nama_brg, detail_barang.satuan, detail_barang.harga_jual "
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
                    rs.getString("harga_jual")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolCariBarangActionPerformed

    private void tombolEditListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditListActionPerformed
        try {
            Koneksi koneksiDetailBeliEdit = new Koneksi();
            String sqlUpdate = "UPDATE detail_pembelian SET "
                    + "qty = ? "
                    + "WHERE id_detail_beli = ?";
            PreparedStatement pstmtUpdate = koneksiDetailBeliEdit.prepareStatement(sqlUpdate);
            pstmtUpdate.setString(1, kotakQtyList.getText());
            pstmtUpdate.setString(2, kotakIdDetailBeliList.getText());
            pstmtUpdate.executeUpdate();
            System.out.println("Edit list barang dengan id (" + kotakIdDetailBeliList.getText() + ")\n"
                    + "Ubah qty barang menjadi "+kotakQtyList.getText());

            kotakIdDetailBeliList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            dataDetailTransaksi();
            dataListBarang();

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
        
        String idTransaksiJual = kotakTransaksiBeli.getText();
        
        if (idTransaksiJual.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Tidak ada transaksi sama sekali!",
                    "Tidak ada Transaksi",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        if (confirmTransaksiBaru == 0) {
            JOptionPane.showMessageDialog(this,
                    "Transaksi dengan ID Transaksi Jual ("+kotakTransaksiBeli.getText()+") "
                            + "telah selesai.\nSilahkan tekan tombol transaksi baru untuk "
                            + "memulai transaksi baru :)",
                    "Transaksi Telah Selesai",
                    JOptionPane.INFORMATION_MESSAGE
            );
            kotakIdDetailBeliList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            kotakTotalHarga.setText(null);
            kotakTransaksiBeli.setText(null);
            tombolTransaksiBaru.setEnabled(true);

            DefaultTableModel tabelListDetailTransaksiHapusIsi
                    = (DefaultTableModel) tabelListDetailTransaksi.getModel();
            tabelListDetailTransaksiHapusIsi.setRowCount(0);
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
            Koneksi koneksiDetailBeliHapus = new Koneksi();
            String sqlDelete = "DELETE FROM detail_pembelian "
                    + "WHERE id_detail_beli = ?";
            PreparedStatement pstmtHapus = koneksiDetailBeliHapus.prepareStatement(sqlDelete);
            pstmtHapus.setString(1, kotakIdDetailBeliList.getText());
            pstmtHapus.executeUpdate();
            System.out.println("Hapus list barang dengan id (" + kotakIdDetailBeliList.getText() + ")");
            
            kotakIdDetailBeliList.setText(null);
            kotakNamaBarangList.setText(null);
            kotakQtyList.setText(null);
            dataDetailTransaksi();
            dataListBarang();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolHapusListActionPerformed

    private void comboSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSupplierActionPerformed
        if (comboSupplier.getSelectedIndex() == 0) {
            tombolTransaksiBaru.setEnabled(false);
            kotakTransaksiBeli.setEnabled(false);
        } else {
            tombolTransaksiBaru.setEnabled(true);
            kotakTransaksiBeli.setEnabled(true);
        }
    }//GEN-LAST:event_comboSupplierActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new viewAppKasirBeli().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSupplier;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kotakCariBarang;
    private javax.swing.JTextField kotakHarga;
    private javax.swing.JTextField kotakIdDetailBarang;
    private javax.swing.JTextField kotakIdDetailBeliList;
    private javax.swing.JTextField kotakNamaBarangList;
    private javax.swing.JTextField kotakQty;
    private javax.swing.JTextField kotakQtyList;
    private javax.swing.JTextField kotakTotalHarga;
    private javax.swing.JTextField kotakTransaksiBeli;
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
