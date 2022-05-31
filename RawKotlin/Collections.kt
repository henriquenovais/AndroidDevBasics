fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")

    //Set use only unique 
    val setOfNumbers = numbers.toSet()
    println("set: ${setOfNumbers}")

    println("contains 7: ${setOfNumbers.contains(7)}")

    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )

    println("peopleAges mutable map: $peopleAges")
    peopleAges.put("Barbara", 42)
    println("Added one more element into the map: $peopleAges")
    peopleAges["Joe"] = 51 //Other way of adding new elements
    println("Added one more element into the map: $peopleAges")

    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)
}

