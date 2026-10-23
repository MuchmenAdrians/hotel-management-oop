import java.io.Closeable

// Closeable = pengganti "destructor" di Kotlin (close() dipanggil lewat use { })
class Hotel(val nama: String) : Closeable {

    private val daftarKamar = mutableListOf<Kamar>()
    private val daftarStaff = mutableListOf<Staff>()
    private val daftarReservasi = mutableListOf<Reservasi>()

    fun tambahKamar(kamar: Kamar) { daftarKamar.add(kamar) }
    fun tambahStaff(staff: Staff) { daftarStaff.add(staff) }

    // OVERLOADING: nama sama, parameter beda
    fun cariKamar(nomor: Int): Kamar? = daftarKamar.find { it.nomor == nomor }

    fun cariKamar(jenis: String): List<Kamar> =
        daftarKamar.filter { it.jenis() == jenis && it.tersedia }

    // CHECK-IN: membuat reservasi baru
    fun pesanKamar(tamu: Tamu, nomor: Int, malam: Int): Reservasi? {
        if (malam <= 0) {
            println("Lama inap minimal 1 malam!")
            return null
        }
        val kamar = cariKamar(nomor)
        if (kamar == null) {
            println("Kamar $nomor tidak ditemukan!")
            return null
        }
        if (!kamar.tersedia) {
            println("Kamar $nomor tidak tersedia!")
            return null
        }
        kamar.pesan()
        val reservasi = Reservasi(tamu, kamar, malam)
        daftarReservasi.add(reservasi)
        return reservasi
    }

    // CHECK-OUT: menyelesaikan reservasi dan mengosongkan kamar
    fun checkOut(nomor: Int): Reservasi? {
        val reservasi = daftarReservasi.find {
            it.kamar.nomor == nomor && it.status == StatusReservasi.AKTIF
        }
        if (reservasi == null) {
            println("Tidak ada reservasi aktif di kamar $nomor!")
            return null
        }
        reservasi.selesai()
        reservasi.kamar.kosongkan()
        return reservasi
    }

    fun tampilkanKamar() {
        println("\n=== Daftar Kamar $nama ===")
        for (k in daftarKamar) {                      // POLYMORPHISM
            val status = if (k.tersedia) "Kosong" else "Terisi"
            println("Kamar ${k.nomor} | ${k.jenis()} | Rp${k.hargaPerMalam().toLong()} | $status")
        }
    }

    fun tampilkanStaff() {
        println("\n=== Daftar Staff $nama ===")
        for (s in daftarStaff) {                      // POLYMORPHISM
            println("${s.info()} | Tugas: ${s.tugas()}")
        }
    }

    fun tampilkanReservasi() {
        println("\n=== Riwayat Reservasi ===")
        for (r in daftarReservasi) {
            println("${r.id} | ${r.tamu.nama} | Kamar ${r.kamar.nomor} | ${r.malam} malam | ${r.status}")
        }
    }

    override fun close() {
        daftarKamar.clear()
        daftarStaff.clear()
        daftarReservasi.clear()
        println("\n[$nama ditutup, data dibersihkan]")
    }
}
