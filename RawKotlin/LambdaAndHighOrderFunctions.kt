 fun main(){
    //lamba expression -> a function with no name that can immediately be used as an expression 
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println(triple(5))

    val quadruple: (Int) -> Int = { it * 4 }
    println(quadruple(5))

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println("Sorted by name: $peopleNames.sorted()")

    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })

 }

