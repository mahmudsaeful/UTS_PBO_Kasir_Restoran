import java.util.ArrayList;

/**
 * Class Pesanan (RELATION: Composition)
 * - Pesanan "memiliki" banyak Menu (ArrayList<Menu>)
 * - Memenuhi ketentuan: minimal 3 atribut private, constructor berparameter, minimal 2 method tambahan
 */
public class Pesanan {

    // Atribut private (minimal 3)
    private ArrayList<Menu> daftarPesanan; // daftar item yang dipesan
    private String namaPembeli;            // nama pembeli / pelanggan (bisa default)
    private boolean statusSelesai;         // status pesanan (selesai / belum)

    /**
     * Constructor berparameter (memenuhi ketentuan)
     * @param namaPembeli nama pelanggan (bisa diisi "Pelanggan" bila tidak ingin input)
     */
    public Pesanan(String namaPembeli) {
        this.daftarPesanan = new ArrayList<>();
        this.namaPembeli = namaPembeli;
        this.statusSelesai = false;
    }

    // Getter & Setter
    public ArrayList<Menu> getDaftarPesanan() { return daftarPesanan; }

    public String getNamaPembeli() { return namaPembeli; }
    public void setNamaPembeli(String namaPembeli) { this.namaPembeli = namaPembeli; }

    public boolean isStatusSelesai() { return statusSelesai; }
    public void setStatusSelesai(boolean statusSelesai) { this.statusSelesai = statusSelesai; }

    // ===== Method tambahan 1 =====
    /**
     * Menambah sebuah Menu ke daftar pesanan.
     * Ini menunjukkan Composition: Pesanan "mengandung" objek Menu.
     * @param menu objek Menu (Makanan/Minuman)
     */
    public void tambahPesanan(Menu menu) {
        daftarPesanan.add(menu);
        System.out.println(menu.getNama() + " berhasil ditambahkan ke pesanan.");
    }

    // ===== Method tambahan 2 =====
    /**
     * Menghapus item pesanan berdasarkan index (0-based).
     * Menampilkan pesan jika index tidak valid.
     */
    public void hapusPesanan(int index) {
        if (index >= 0 && index < daftarPesanan.size()) {
            System.out.println(daftarPesanan.get(index).getNama() + " dihapus dari pesanan.");
            daftarPesanan.remove(index);
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }

    /**
     * Menampilkan seluruh pesanan ke console (beserta indeks 1-based).
     */
    public void tampilkanPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        System.out.println("=== Daftar Pesanan (" + namaPembeli + ") ===");
        double total = 0;
        for (int i = 0; i < daftarPesanan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarPesanan.get(i).tampilkanInfo();
            total += daftarPesanan.get(i).getHarga();
        }
        System.out.println("----------------------------");
        System.out.println("Total Harga: Rp " + (long) total);
    }

    /**
     * Menghitung jumlah item pesanan (untuk cek status).
     * @return jumlah item pesanan
     */
    public int jumlahPesanan() {
        return daftarPesanan.size();
    }

    /**
     * Menghitung total harga pesanan (utility tambahan).
     * @return total harga
     */
    public double totalHarga() {
        double total = 0;
        for (Menu m : daftarPesanan) total += m.getHarga();
        return total;
    }
}
