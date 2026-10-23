// SUBCLASS dari Orang (INHERITANCE)
class Tamu(nama: String, noHp: String, val noKtp: String) : Orang(nama, noHp) {

    // Secondary constructor
    constructor(nama: String) : this(nama, "-", "-")

    override fun info(): String = super.info() + " | KTP: $noKtp"
}
