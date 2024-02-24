import java.util.ArrayList;
import java.util.Scanner;

public class PemesananMakananMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi menu makanan
        ArrayList<Produk> menu = new ArrayList<>();
        menu.add(new Produk("Seblak", 15000, 10));
        menu.add(new Produk("Basreng", 12000, 5));
        menu.add(new Produk("Cireng", 20000, 3));
        menu.add(new Produk("Cilok", 18000, 8));
        menu.add(new Produk("Telur Gulung", 25000, 2));
        menu.add(new Produk("Nugget", 10000, 6));
        menu.add(new Produk("Sotong", 15000, 4));
        menu.add(new Produk("Tahu Bulat", 17000, 7));
        menu.add(new Produk("Batagor", 20000, 3));
        menu.add(new Produk("Spatula", 18000, 5));

        ArrayList<Penjualan> pesanan = new ArrayList<>();

        boolean lanjutPesan = true;

        while (lanjutPesan) {
            System.out.println("Menu Makanan:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getNamaProduk() + " - Rp " + menu.get(i).getHarga() + " - Stok :" + menu.get(i).getStok());
            }

            System.out.print("Pilih nomor menu yang ingin dipesan: ");
            int pilihanMenu = -1;
            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Masukkan nomor menu yang ingin dipesan: ");
                scanner.next(); // Mengabaikan input yang tidak valid
            }
            pilihanMenu = scanner.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > menu.size()) {
                System.out.println("Nomor menu tidak valid!");
                continue;
            }

            System.out.print("Masukkan jumlah yang ingin dipesan: ");
            int jumlahPesanan = -1;
            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Masukkan jumlah yang ingin dipesan: ");
                scanner.next(); // Mengabaikan input yang tidak valid
            }
            jumlahPesanan = scanner.nextInt();

            Produk produkDipesan = menu.get(pilihanMenu - 1);
            if (!produkDipesan.validasiJumlah(jumlahPesanan)) {
                System.out.println("Jumlah pesanan tidak valid!");
                continue;
            }

            produkDipesan.kurangiStok(jumlahPesanan);
            Penjualan penjualan = new Penjualan(produkDipesan, jumlahPesanan);
            pesanan.add(penjualan);

            System.out.print("Ingin memesan lagi? (ya/tidak): ");
            String lanjut = scanner.next();
            if (!lanjut.equalsIgnoreCase("ya")) {
                lanjutPesan = false;
            }
        }

        System.out.println("\nPesanan Anda:");
        double totalBayarSemua = 0;
        for (Penjualan item : pesanan) {
            double total = item.hitungTotal();
            System.out.println(item.toString() + " - " + item.getQuantity() + " pcs - Rp " + total);
            totalBayarSemua += total;
        }
        System.out.println("Total Bayar: Rp " + totalBayarSemua);

        scanner.close();
    }
}
