// INTERFACE: kontrak untuk semua yang "bisa dibayar"
interface Pembayaran {
    fun hitungTotal(): Double

    // Interface boleh punya fungsi dengan isi (default method)
    fun cetakStruk() {
        println("Total bayar : Rp${hitungTotal().toLong()}")
    }
}
