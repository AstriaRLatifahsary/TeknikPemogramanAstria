class Penjualan {
    private Produk barang;
    private int quantity;

    public Penjualan(Produk barang, int quantity) {
        this.barang = barang;
        this.quantity = quantity;
    }

    public double hitungTotal(){
        return barang.getHarga() * quantity;
    }

    // public String getNamaProduk() {
    //     return barang.getNamaProduk();
    // }

    public int getQuantity(){
        return quantity;
    }

    public String toString() {
        return barang.getNamaProduk() + "\t" + quantity + "\tRp. " + hitungTotal();
    }
}