fun main() {
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }

    //other syntax for the same thing:
    //for (name in names) println("$name - Number of characters: ${name.length}")
}