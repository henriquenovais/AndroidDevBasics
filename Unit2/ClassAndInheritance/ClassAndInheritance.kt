/**
 * ```
 *           View
 *             \/
 *      TextView
 *      /            \
 * ```
 * EditText Button
 *
 * All kotlin classes have a common parent: kotlin.Any
 */

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    /**
     * An abstract class cannot be instanced. The following code is not possible: val dwelling =
     * Dwelling()
     */
    // val spongeBobSquareCabin = SquareCabin(6)
    // val roundHut = RoundHut(4)
    // val roundTower = RoundTower(5)

    val spongeBobSquareCabin = SquareCabin(6, 50.0) 
    val roundHut = RoundHut(4, 65.0)
    val roundTower = RoundTower(5, 70.0)

    //  println("\n SquareCabin\n==========")
    //  println("Capacity: ${spongeBobSquareCabin.capacity}")
    //  println("Material: ${spongeBobSquareCabin.buildingMaterial}")
    //  println("Has room? ${spongeBobSquareCabin.hasRoom()}")

    // OR

    with(spongeBobSquareCabin) {
        println("\n SquareCabin\n==========")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
    }

    with(roundHut) {
        println("\n RoundHut\n==========")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    with(roundTower) {
        println("\n RoundTower\n==========")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea() : Double

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }

}

// The following syntax is possible in case of needing to declare a constant
// class ClassName : ParentClass(CONSTANT_VALUE) {}

class SquareCabin(residents: Int, val length : Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea() : Double {
        return length.pow(2)
    }
}

open class RoundHut(residents: Int, val radius : Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea() : Double {
        return PI * radius.pow(2)
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(residents: Int, radius : Double, val floors : Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea() : Double {
        return super.floorArea() * floors
    }
}


