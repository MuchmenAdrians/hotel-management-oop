class KamarSuite(nomor: Int) : Kamar(nomor, 1_000_000.0) {
    override fun jenis() = "Suite"

    // OVERRIDING: harga premium
    override fun hargaPerMalam() = hargaDasar * 1.5
}
