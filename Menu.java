/**
 * Superclass Menu
 * - Mewakili item menu umum (baik makanan maupun minuman)
 * - Memenuhi ketentuan: minimal 3 atribut private, constructor berparameter, getter/setter, 2 method tambahan
 */
public class Menu {
    // Atribut private (minimal 3)
    private int id;          // id unik item menu
    private String nama;     // nama menu
    private double harga;    // harga menu

    /**
     * Constructor berparameter
     * @param id    id menu
     * @param nama  nama menu
     * @param harga harga menu
     */
    public Menu(int id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    // ===== Getter & Setter (encapsulation) =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    // ===== Method tambahan 1 =====
    /**
     * Menampilkan informasi singkat menu ke console.
     * Digunakan untuk menampilkan daftar menu dengan rapi.
     */
    public void tampilkanInfo() {
        System.out.println(id + ". " + nama + " - Rp " + (long)harga);
    }

    // ===== Method tambahan 2 =====
    /**
     * Memeriksa apakah nama menu mengandung kata kunci (untuk pencarian).
     * @param keyword  kata kunci pencarian
     * @return true jika cocok
     */
    public boolean isMatch(String keyword) {
        return nama.toLowerCase().contains(keyword.toLowerCase());
    }

    /**
     * Mengembalikan info singkat sebagai string (bisa untuk laporan atau tampilan).
     * @return info singkat
     */
    public String getInfoSingkat() {
        return id + ". " + nama + " - Rp " + (long)harga;
    }
}
