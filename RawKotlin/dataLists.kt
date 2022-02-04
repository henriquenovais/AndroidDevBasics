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
    //could be declared as
    // val colors = listOf("green", "orange", "blue")

    /** 
    Assigning new elements or adding new ones is not possible in a list:
    colors.add("purple") //won't work
    colors[0] = "yellow" //won't work
    */
    //However, there are some commands that can be used in order to change the order of the list creating another list:
    print("List: $colors")
    println("Reversed list: ${colors.reversed()}")
    println("Sorted list: ${colors.sorted()}")
    
    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")

    println("--------------- MUTABLE LISTS ---------------")

    //declaration
    val entrees: MutableList<String> = mutableListOf()
    //could also be declared as:
    //val entrees = mutableListOf<String>()
    
    //Add items into mutable list:
    println("Entrees mutable list: $entrees")
    println("Add noodles: ${entrees.add("noodles")}") 
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    val moreItems: MutableList<String> = mutableListOf("pudim", "feijoada", "lasanha")
    println("Add 'moreItems' mutable list: ${entrees.addAll(moreItems)}")
    println("Entrees mutable list: $entrees")

    //Remove from mutable list:
    println("Remove item that doesn't exist in the mutable list: ${entrees.remove("rice")}}")
    println("Remove item from an index: ${entrees.removeAt(0)}")
    println("Entrees mutable list: $entrees")
    println("Remove all items: ${entrees.clear()}")
    println("Entrees mutable list: $entrees")

    //Check if mutable list is empty:
    println("Is 'entrees' mutable list empty? ${entrees.isEmpty()}")
}