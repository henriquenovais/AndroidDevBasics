 fun main(){
    //lamba expression -> a function with no name that can immediately be used as an expression 
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println(triple(5))

    val quadruple: (Int) -> Int = { it * 4 }
    println(quadruple(5))
 }

