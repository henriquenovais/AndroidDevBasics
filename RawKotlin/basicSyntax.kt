class CatholicChurch (var laymen: Int, var clergy: Int, var purgatorySouls: Int) {
    var militantChurch: Int = laymen + clergy
    var sufferingChurch: Int = purgatorySouls
    
    fun spreadTheGospel () : Int {
        Random.nextInt()
    }
}

fun main () {
    println("Hello World!")
}