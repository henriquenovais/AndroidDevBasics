fun main() {
    /** 
    val noodles = Noodles()
    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables()
    println(noodles)
    println(vegetables)
    println(vegetables2)
    */

    val ordersList = mutableListOf<Order>()

    val order1 = Order(1)
    order1.addItem(Noodles())

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)

    ordersList.add(order1)
    ordersList.add(order2)
    ordersList.add(order3)

    for (order in ordersList) {
    order.print()
    println()
    }
    
}

open class Item(val name: String, val price: Int)

open class Noodles : Item("Noodles", 10) {
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
open class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()){
            return "$name Chef's Choice"
        } else {
            return name + " " + toppings.joinToString()
        }
   }
}

class Order(val orderNumber : Int) {
    private val itemList = mutableListOf<Item>()

    fun addItem(newItem: Item) {
        itemList.add(newItem)
   }

   fun addAll(newItems: List<Item>) {
       itemList.addAll(newItems)
   }

   fun print() {
        println("Order #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
   }
}