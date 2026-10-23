// Mengimplementasikan interface Pembayaran + berelasi dengan Tamu dan Kamar
class Reservasi(val tamu: Tamu, val kamar: Kamar, val malam: Int) : Pembayaran {

    // COMPANION OBJECT: milik class (bukan objek), dipakai untuk penomoran ID otomatis
    companion object {
        private var counter = 0
    }

    val id: String = "RSV-" + (++counter).toString().padStart(3, '0')

    // ENCAPSULATION: status hanya bisa diubah lewat fungsi selesai()
    var status: StatusReservasi = StatusReservasi.AKTIF
        private set

    fun selesai() { status = StatusReservasi.SELESAI }

    override fun hitungTotal(): Double = kamar.hargaPerMalam() * malam

    fun ringkasan() {
        println("ID          : $id")
        println("Tamu        : ${tamu.nama}")
        println("Kamar       : ${kamar.nomor} (${kamar.jenis()})")
        println("Lama inap   : $malam malam")
        println("Status      : $status")
    }
}
