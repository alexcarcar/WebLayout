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
fun main(args:Array<String>) {
	example1()
	example2()
}
	