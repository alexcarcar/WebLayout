// https://www.tutorialspoint.com/kotlin/kotlin_generics.htm

fun example1() {
	// In this example, we have declared one "integer"
	// and assigned it to Number
	val integer:Int = 1
	val number:Number = integer

	// Because Int is a subclass of Number, conversion
	// occurs automatically...
	println(number) // 1
}

// =========================================
fun example2() {
	var o = genericsExample<String>("Java")
	var o2 = genericsExample<Int>(10)
	println(o.toString())
	println(o2.toString())
	// I am get called with the value Java
	// I am get called with the value 10
	// genericsExample@1b6d3586
	// genericsExample@4554617c
}

class genericsExample<T>(input:T) {
	init {
		println("I am get called with the value "+input)
	}
}
// =========================================
// When we want to assign the generic type to any of its super type, then
// we use "out" keyword.  When we want to assign the generic type to any of
// its sub-type, then we need to use "in" keyword.
fun example3() {
	var o1 = gExample<Int>(10)
	var o2 = gExample<Double>(10.00)
	println(o1)
	println(o2)
	// I am getting called with the value 10
	// I am getting called with the value 10.0
	// gExample@677327b6
	// gExample@14ae5a5
}

class gExample<out T>(input:T) {
	init {
		println("I am getting called with the value " + input)
	}
}

// =========================================
fun main(args:Array<String>) {
	example1()
	example2()
	example3()
}
	