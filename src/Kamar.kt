// ABSTRACT CLASS: tidak bisa dibuat objeknya langsung, hanya jadi induk
abstract class Kamar(val nomor: Int, protected val hargaDasar: Double) {

    // ENCAPSULATION: bisa dibaca dari luar, tapi hanya diubah dari dalam class
    var tersedia: Boolean = true
        private set

    // Initializer block: jalan otomatis saat objek dibuat
    init {
        println("[Kamar $nomor] dibuat")
    }

    abstract fun jenis(): String                      // wajib di-override anak
    open fun hargaPerMalam(): Double = hargaDasar     // boleh di-override anak

    fun pesan() { tersedia = false }
    fun kosongkan() { tersedia = true }
}
