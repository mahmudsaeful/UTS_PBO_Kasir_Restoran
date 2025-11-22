/**
 * Subclass Makanan (extends Menu)
 * - Tambahan atribut spesifik makanan
 * - Memenuhi minimal 3 atribut private (menggabungkan atribut superclass + atribut sendiri)
 */
public class Makanan extends Menu {

    // Atribut private khusus makanan (menambah atribut agar total domain >= 3)
    private boolean pedas;      // apakah pedas
    private int kalori;         // estimasi kalori
    private String jenis;       // contoh: "Rumahan", "Cepat Saji", dsb.

    /**
     * Constructor berparameter
     */
    public Makanan(int id, String nama, double harga, boolean pedas, int kalori, String jenis) {
        super(id, nama, harga); // inisialisasi atribut superclass
        this.pedas = pedas;
        this.kalori = kalori;
        this.jenis = jenis;
    }

    // Getter & Setter untuk atribut baru
    public boolean isPedas() { return pedas; }
    public void setPedas(boolean pedas) { this.pedas = pedas; }

    public int getKalori() { return kalori; }
    public void setKalori(int kalori) { this.kalori = kalori; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    // ===== Method tambahan 1 =====
    /**
     * Menampilkan level pedas makanan.
     * Method ini memperlihatkan encapsulation + method tambahan.
     */
    public void infoLevelPedas() {
        System.out.println(getNama() + " - Pedas: " + (pedas ? "Ya" : "Tidak"));
    }

    // ===== Method tambahan 2 =====
    /**
     * Menampilkan deskripsi lebih lengkap khusus makanan (kalori & jenis).
     */
    public void deskripsiMakanan() {
        System.out.println(getInfoSingkat() + " | Kalori: " + kalori + " kkal | Jenis: " + jenis);
    }
}
