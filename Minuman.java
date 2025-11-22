/**
 * Subclass Minuman (extends Menu)
 * - Tambahan atribut spesifik minuman
 * - Memenuhi minimal 3 atribut private (superclass + atribut sendiri)
 */
public class Minuman extends Menu {

    // Atribut private khusus minuman
    private boolean dingin;   // apakah disajikan dingin
    private int ukuran;       // ukuran (ml)
    private boolean adaGula;  // apakah ada gula

    /**
     * Constructor berparameter
     */
    public Minuman(int id, String nama, double harga, boolean dingin, int ukuran, boolean adaGula) {
        super(id, nama, harga);
        this.dingin = dingin;
        this.ukuran = ukuran;
        this.adaGula = adaGula;
    }

    // Getter & Setter
    public boolean isDingin() { return dingin; }
    public void setDingin(boolean dingin) { this.dingin = dingin; }

    public int getUkuran() { return ukuran; }
    public void setUkuran(int ukuran) { this.ukuran = ukuran; }

    public boolean isAdaGula() { return adaGula; }
    public void setAdaGula(boolean adaGula) { this.adaGula = adaGula; }

    // ===== Method tambahan 1 =====
    public void infoDingin() {
        System.out.println(getNama() + " - Suhu: " + (dingin ? "Dingin" : "Hangat"));
    }

    // ===== Method tambahan 2 =====
    public void deskripsiMinuman() {
        System.out.println(getInfoSingkat() + " | Ukuran: " + ukuran + "ml | " + (adaGula ? "Ada Gula" : "Tanpa Gula"));
    }
}
