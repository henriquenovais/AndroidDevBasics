class CatholicChurch (var laymen: Int, var clergy: Int, var purgatorySouls: Int) {
    var militantChurch: Int = laymen + clergy
    var sufferingChurch: Int = purgatorySouls

    fun spreadTheGospel () : Boolean {
        return true
    }
}

fun main () {
    println("Hello World!")
}