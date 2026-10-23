fun main() {
    // TIPE DATA di Kotlin
    val namaHotel: String = "Hotel Cirebon Indah"
    val jumlahLantai: Int = 5
    val rating: Double = 4.5
    val buka: Boolean = true
    val kodeHotel: Char = 'C'
    val totalTamu: Long = 1_500L
    println("$namaHotel ($kodeHotel) | Lantai: $jumlahLantai | Rating: $rating | Buka: $buka | Tamu: $totalTamu\n")

    // "use" otomatis memanggil close() di akhir (konsep destructor)
    Hotel(namaHotel).use {
        hotel ->

        // Menyiapkan kamar
        hotel.tambahKamar(KamarStandar(101))
        hotel.tambahKamar(KamarDeluxe(201))
        hotel.tambahKamar(KamarSuite(301))

        // Menyiapkan staff (inheritance bertingkat)
        hotel.tambahStaff(Resepsionis("Adrian", "08987654321"))
        hotel.tambahStaff(Housekeeping("Putri", "08111222333"))
        hotel.tampilkanStaff()

        // Membuat objek tamu
        val tamu1 = Tamu("Rasya", "08123456789", "3209010101010001")
        val tamu2 = Tamu("Yusuf")
        println("\n" + tamu1.info())
        println(tamu2.info())

        hotel.tampilkanKamar()

        // CHECK-IN
        println("\n=== Check-in ===")
        hotel.pesanKamar(tamu1, 201, 3)?.ringkasan()
        println()
        hotel.pesanKamar(tamu2, 201, 1)              // kamar sudah terisi
        hotel.pesanKamar(tamu2, 101, 0)              // lama inap tidak valid
        hotel.pesanKamar(tamu2, 999, 1)              // kamar tidak ada
        hotel.pesanKamar(tamu2, 101, 2)?.ringkasan() // berhasil

        hotel.tampilkanKamar()

        // CHECK-OUT
        println("\n=== Check-out ===")
        val selesai = hotel.checkOut(201)
        selesai?.ringkasan()
        selesai?.cetakStruk()                        // fungsi dari interface
        hotel.checkOut(201)                 // sudah check-out sebelumnya

        hotel.tampilkanKamar()
        hotel.tampilkanReservasi()

        // Overloading: cari berdasarkan jenis
        println("\nKamar Suite kosong: ${hotel.cariKamar("Suite").size}")
    }
}
