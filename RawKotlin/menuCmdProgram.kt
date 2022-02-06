fun main() {
    val noodles = Noodles()
    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables()
    println(noodles)
    println(vegetables)
    println(vegetables2)
}

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
   override fun toString(): String {
       return name
   }
}
/**
Declaration possibilities for the same thing in case of a class that receives multiple inputs of indefinite quantities:
Example: class may receive 5 Ints and then receive 3 Ints or 1Int 

class Vegetables(val toppings : List<String> : Item("Vegetables", 5) {
       override fun toString(): String {
       return name
   }
}
*/
//Option recommended by the tutorial:
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()){
            return "$name Chef's Choice"
        } else {
            return name + " " + toppings.joinToString()
        }
   }
}