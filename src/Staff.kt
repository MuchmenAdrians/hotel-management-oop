// SUBCLASS dari Orang, sekaligus SUPERCLASS untuk Resepsionis & Housekeeping
// (multilevel inheritance: Orang -> Staff -> Resepsionis)
open class Staff(nama: String, noHp: String, val jabatan: String) : Orang(nama, noHp) {

    open fun tugas(): String = "Membantu operasional hotel"

    override fun info(): String = super.info() + " | Jabatan: $jabatan"
}
