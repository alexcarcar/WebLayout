// https://www.tutorialspoint.com/kotlin/kotlin_sealed_class.htm

// MyExample class can be of two types only
sealed class MyExample {
	class OP1: MyExample()
	class OP2: MyExample()
}

fun main(args:Array<String>) {
	val obj:MyExample = MyExample.OP2()

	// define the object of the class depending on the inputs
	val output = when(obj) {
		is MyExample.OP1 -> "Option 1 has been chosen"
		is MyExample.OP2 -> "Option 2 has been chosen"
	}

	println(output) // Option 2 has been chosen
}