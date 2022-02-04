fun main() {
    println("----------- NUMBERED LIST -----------")
    //Declaration:
    //val numbers: List<Int> = listOf(1, 2, 3, 4, 5,  6)
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    //Printing the whole list and size:
    println("List: $numbers")
    println("Size: ${numbers.size}")

    //Printing specific elements of the list:
    // println("First element: ${numbers[0]}")
    println("First element: ${numbers.first()}")
    println("Second element: ${numbers[1]}")
    println("Last element: ${numbers.last()}")
    println("Last index: ${numbers.size - 1}")
    println("Last element: ${numbers[numbers.size - 1]}")

    //Check if there is an specific elemnt inside of the list:
    println("Contains 4?  ${numbers.contains(4)}")
    println("Contains 7?  ${numbers.contains(7)}")

    println("------------ STRING LIST -------------")

    val colors : List<String> = listOf("green", "orange", "blue")

    //assign new elements or add new ones:
    colors.add("purple")
    colors[0] = "yellow"
}