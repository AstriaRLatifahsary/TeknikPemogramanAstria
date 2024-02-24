public class Produk {
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(String namaProduk, double harga, int stok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNamaProduk(){
        return namaProduk;
    }

    public double getHarga(){
        return harga;
    }

    public int getStok(){
        return stok;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > stok) {
            System.out.println("Stok tidak mencukupi!");
        } else {
            stok -= jumlah;
        }
    }

    // Validasi input jumlah produk
    public boolean validasiJumlah(int jumlah) {
        return jumlah > 0 && jumlah <= stok;
    }
}

