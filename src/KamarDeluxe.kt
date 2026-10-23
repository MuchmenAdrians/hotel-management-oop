class KamarDeluxe(nomor: Int) : Kamar(nomor, 500_000.0) {
    override fun jenis() = "Deluxe"

    // OVERRIDING: harga ditambah biaya sarapan
    override fun hargaPerMalam() = hargaDasar + 50_000
}
