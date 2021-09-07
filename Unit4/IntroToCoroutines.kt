import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }

suspend fun getValue(): Double {
    println("entering getValue() at ${time()}")
    delay(3000)
    println("leaving getValue() at ${time()}")
    return Math.random()
}

fun main() {
    // val thread = Thread {
    //     println("${Thread.currentThread()} has run.")
    // }
    // thread.start()

    // val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    // repeat(3) {
    //     Thread {
    //         println("${Thread.currentThread()} has started")
    //         for (i in states) {
    //             println("${Thread.currentThread()} - $i")
    //             Thread.sleep(50)
    //         }
    //     }.start()      
    // }

    //just an example, not applicable in reality since it overloads the main thread and Coroutines library
    //was created in order to not overload the main thread allowing the app to render seamlessly
    // repeat(3) {
    //     GlobalScope.launch {
    //         println("Hi from ${Thread.currentThread()}")
    //     }
    // }

    runBlocking {
        val num1 = getValue()
        val num2 = getValue()
        println("result of num1 + num2 is ${num1 + num2}")
    }

    runBlocking {
        val num1 = async { getValue() }
        val num2 = async { getValue() }
        println("result of num1 + num2 is ${num1.await() + num2.await()}")
    }


}

/**
 * 
 * Threads are not directly 
 * What are Interface classes?
 * Inteface classes are classes that do not implement any methods but have those defined in order
 * to be implemented in other classes.
 * 
 * About Coroutine classes and the hierarchy:
 * - Job interface is a cancellable unit of work which goes inside of a thread.
 * - CoroutineScope interface is used to define a field of interaction for the Job interface. Each CoroutineScope
 * provides a Job context, it is the main interface used in the Kotlin Coroutines library.
 * Dispatcher
 * runBlocking()
 * launch()
 * getValue()
 * delay()
 * Difference between Deferred and Await
 * 'suspend' functions can only be called by 'suspend' functions which are functions that can be paused or cancelled.
 */

