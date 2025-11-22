import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class — Menjalankan aplikasi kasir konsol.
 * REVISI TERBARU:
 * 1. Tampilan menu dipisah (Makanan & Minuman).
 * 2. Kata "Data" diganti "Menu".
 * 3. Input jenis makanan menggunakan pilihan (Berat/Penutup).
 */
public class Main {

    // Scanner global
    static Scanner input = new Scanner(System.in);

    // Daftar menu (database sementara)
    static ArrayList<Menu> daftarMenu = new ArrayList<>();

    // Pesanan pelanggan
    static Pesanan pesanan = new Pesanan("Pelanggan");

    public static void main(String[] args) {

        // ===== Inisialisasi data sample =====
        daftarMenu.add(new Makanan(1, "Ayam Geprek", 18000, true, 450, "Makanan Berat"));
        daftarMenu.add(new Makanan(2, "Nasi Goreng", 15000, false, 400, "Makanan Berat"));
        daftarMenu.add(new Makanan(3, "Puding Coklat", 12000, false, 150, "Makanan Penutup"));

        daftarMenu.add(new Minuman(4, "Es Teh", 5000, true, 300, false));
        daftarMenu.add(new Minuman(5, "Kopi Hitam", 8000, false, 200, false));
        daftarMenu.add(new Minuman(6, "Jus Mangga", 10000, true, 350, true));

        // ===== Loop utama =====
        int pilih = 0;
        do {
            try {
                System.out.println("\n===== APLIKASI KASIR RESTORAN =====");
                System.out.println("1. Kelola Menu");
                System.out.println("2. Pesanan Pelanggan");
                System.out.println("3. Keluar");
                System.out.print("Pilih: ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1:
                        kelolaMenu();
                        break;
                    case 2:
                        menuPesanan();
                        break;
                    case 3:
                        System.out.println("Terima kasih. Program selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine(); // clear buffer
                pilih = 0;
            }
        } while (pilih != 3);
    }

    // ===========================
    // ====== KELOLA MENU =======
    // ===========================
    public static void kelolaMenu() {
        int pilih = 0;
        do {
            try {
                // REVISI: Kata "Data" diganti "Menu"
                System.out.println("\n===== KELOLA MENU =====");
                System.out.println("1. Tambah Menu");
                System.out.println("2. Tampilkan Menu");
                System.out.println("3. Cari Menu");
                System.out.println("4. Ubah Menu");
                System.out.println("5. Cek Status Jumlah Menu");
                System.out.println("6. Kembali");
                System.out.print("Pilih: ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1:
                        tambahDataMenu();
                        break;
                    case 2:
                        tampilkanMenu();
                        break;
                    case 3:
                        cariDataMenu();
                        break;
                    case 4:
                        ubahDataMenu();
                        break;
                    case 5:
                        // Cek status data
                        int jumlahMakanan = 0, jumlahMinuman = 0;
                        for (Menu m : daftarMenu) {
                            if (m instanceof Makanan) jumlahMakanan++;
                            else if (m instanceof Minuman) jumlahMinuman++;
                        }
                        System.out.println("Total menu: " + daftarMenu.size() +
                                " (Makanan: " + jumlahMakanan + ", Minuman: " + jumlahMinuman + ")");
                        break;
                    case 6:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine();
                pilih = 0;
            }
        } while (pilih != 6);
    }

    public static void tambahDataMenu() {
        try {
            System.out.println("\n=== Tambah Menu ===");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.print("Pilih kategori: ");
            int jenis = input.nextInt();
            input.nextLine(); // buang newline

            System.out.print("Nama: ");
            String nama = input.nextLine();

            System.out.print("Harga: ");
            double harga = input.nextDouble();
            input.nextLine(); // buang newline setelah double

            // Auto ID
            int nextId = daftarMenu.size() + 1;

            if (jenis == 1) {
                // INPUT DATA MAKANAN
                System.out.print("Pedas? (true/false): ");
                boolean pedas = input.nextBoolean();
                
                System.out.print("Kalori (kkal): ");
                int kalori = input.nextInt();
                
                // REVISI: Pilihan Jenis Makanan (Berat / Penutup)
                System.out.println("Pilih Jenis Makanan:");
                System.out.println(" 1. Makanan Berat");
                System.out.println(" 2. Makanan Penutup");
                System.out.print("Pilih (1/2): ");
                int pilihJenis = input.nextInt();
                input.nextLine(); // buang newline

                String jenisMakanan;
                if (pilihJenis == 1) {
                    jenisMakanan = "Makanan Berat";
                } else {
                    jenisMakanan = "Makanan Penutup";
                }

                daftarMenu.add(new Makanan(nextId, nama, harga, pedas, kalori, jenisMakanan));
            
            } else if (jenis == 2) {
                // INPUT DATA MINUMAN
                System.out.print("Dingin? (true/false): ");
                boolean dingin = input.nextBoolean();
                System.out.print("Ukuran (ml): ");
                int ukuran = input.nextInt();
                System.out.print("Ada gula? (true/false): ");
                boolean adaGula = input.nextBoolean();
                input.nextLine();

                daftarMenu.add(new Minuman(nextId, nama, harga, dingin, ukuran, adaGula));
            } else {
                System.out.println("Kategori salah.");
            }

            System.out.println("Menu berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid (pastikan angka diisi angka, true/false sesuai).");
            input.nextLine();
        }
    }

    /**
     * REVISI: Tampilkan Menu dipisah jadi 2 blok (Makanan & Minuman)
     */
    public static void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("      DAFTAR MENU RESTORAN    ");
        System.out.println("==============================");

        // --- BAGIAN 1: TAMPILKAN KHUSUS MAKANAN ---
        System.out.println("\n--- MENU MAKANAN ---");
        boolean adaMakanan = false;
        for (Menu m : daftarMenu) {
            if (m instanceof Makanan) {
                m.tampilkanInfo();
                adaMakanan = true;
            }
        }
        if (!adaMakanan) System.out.println("(Tidak ada data makanan)");

        // --- BAGIAN 2: TAMPILKAN KHUSUS MINUMAN ---
        System.out.println("\n--- MENU MINUMAN ---");
        boolean adaMinuman = false;
        for (Menu m : daftarMenu) {
            if (m instanceof Minuman) {
                m.tampilkanInfo();
                adaMinuman = true;
            }
        }
        if (!adaMinuman) System.out.println("(Tidak ada data minuman)");
        
        System.out.println("------------------------------");
    }

    public static void cariDataMenu() {
        System.out.print("Masukkan keyword pencarian: ");
        input.nextLine(); // flush buffer
        String keyword = input.nextLine();

        boolean ada = false;
        System.out.println("Hasil pencarian:");
        for (Menu m : daftarMenu) {
            if (m.isMatch(keyword)) {
                m.tampilkanInfo();
                ada = true;
            }
        }
        if (!ada) System.out.println("Menu tidak ditemukan.");
    }

    public static void ubahDataMenu() {
        try {
            tampilkanMenu();
            System.out.print("\nPilih ID menu yang akan diubah: ");
            int id = input.nextInt();
            input.nextLine();

            if (id < 1 || id > daftarMenu.size()) {
                System.out.println("ID tidak valid.");
                return;
            }

            Menu m = daftarMenu.get(id - 1);
            System.out.print("Nama baru: ");
            String baruNama = input.nextLine();
            System.out.print("Harga baru: ");
            double baruHarga = input.nextDouble();
            input.nextLine();

            m.setNama(baruNama);
            m.setHarga(baruHarga);

            System.out.println("Menu berhasil diubah.");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            input.nextLine();
        }
    }

    // ===========================
    // ====== MENU PESANAN =======
    // ===========================
    public static void menuPesanan() {
        int pilih = 0;
        do {
            try {
                System.out.println("\n===== MENU PESANAN PELANGGAN =====");
                System.out.println("1. Pesan Makanan");
                System.out.println("2. Pesan Minuman");
                System.out.println("3. Hapus Pesanan");
                System.out.println("4. Tampilkan Pesanan");
                System.out.println("5. Kembali");
                System.out.print("Pilih: ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1:
                        pesanJenis(Makanan.class);
                        break;
                    case 2:
                        pesanJenis(Minuman.class);
                        break;
                    case 3:
                        hapusPesanan();
                        break;
                    case 4:
                        pesanan.tampilkanPesanan();
                        break;
                    case 5:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine();
                pilih = 0;
            }
        } while (pilih != 5);
    }

    public static void pesanJenis(Class<?> jenis) {
        String namaJenis = (jenis == Makanan.class ? "MAKANAN" : "MINUMAN");
        System.out.println("\n=== DAFTAR MENU (" + namaJenis + ") ===");
        
        boolean adaData = false;
        for (Menu m : daftarMenu) {
            // Tampilkan hanya yang sesuai jenis (Makanan/Minuman)
            if (jenis.isInstance(m)) {
                m.tampilkanInfo();
                adaData = true;
            }
        }

        if (!adaData) {
            System.out.println("Belum ada data " + namaJenis + ".");
            return;
        }

        try {
            System.out.print("Pilih ID menu untuk dipesan: ");
            int id = input.nextInt();
            input.nextLine();

            if (id < 1 || id > daftarMenu.size()) {
                System.out.println("ID tidak ditemukan.");
                return;
            }

            Menu dipilih = daftarMenu.get(id - 1);

            // Validasi Kategori agar tidak salah pesan
            if (jenis.isInstance(dipilih)) {
                pesanan.tambahPesanan(dipilih);
            } else {
                System.out.println("Error: ID yang dipilih bukan termasuk " + namaJenis + "!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid saat memilih menu.");
            input.nextLine();
        }
    }

    public static void hapusPesanan() {
        if (pesanan.jumlahPesanan() == 0) {
            System.out.println("Belum ada pesanan untuk dihapus.");
            return;
        }

        pesanan.tampilkanPesanan();
        try {
            System.out.print("Masukkan nomor pesanan yang ingin dihapus: ");
            int no = input.nextInt();
            input.nextLine();
            pesanan.hapusPesanan(no - 1);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            input.nextLine();
        }
    }
}