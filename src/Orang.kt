// SUPERCLASS (induk). "open" = boleh diwariskan (default class Kotlin itu final)
open class Orang(val nama: String, private val noHp: String) {

    // private tidak bisa diakses dari luar, jadi dibuat getter manual
    fun getNoHp(): String = noHp

    open fun info(): String = "Nama: $nama | HP: $noHp"
}
