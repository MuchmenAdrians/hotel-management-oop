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
        hotel.tambahStaff(Resepsionis("Adrian", "08123001"))
        hotel.tambahStaff(Housekeeping("Putri", "08112233"))
        hotel.tampilkanStaff()

        // Membuat objek tamu
        println("\n=== Daftar Tamu " + namaHotel + "===")
        val tamu1 = Tamu("Rasya", "081234567", "3209010101010001")
        val tamu2 = Tamu("Yusuf", "089910233", "3209010101010005")
        println(tamu1.info())
        println(tamu2.info())

        hotel.tampilkanKamar()

        // CHECK-IN
        println("\n=== Check-in Tamu 1 ===")
        hotel.pesanKamar(tamu1, 201, 3)?.ringkasan()
        println()
        hotel.pesanKamar(tamu2, 201, 1)              // kamar sudah terisi
        hotel.pesanKamar(tamu2, 101, 0)              // lama inap tidak valid
        hotel.pesanKamar(tamu2, 999, 1)
        println("\n=== Check-in Tamu 2 ===")
        hotel.pesanKamar(tamu2, 101, 2)?.ringkasan() // berhasil

        hotel.tampilkanKamar()

        // CHECK-OUT
        println("\n=== Check-out ===")
        val selesai = hotel.checkOut(201)
        selesai?.ringkasan()
        selesai?.cetakStruk()  // fungsi dari interface
    }
}
