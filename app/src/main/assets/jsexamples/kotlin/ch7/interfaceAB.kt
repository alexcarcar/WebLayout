interface A {
	fun printMe() {
		println("method of interface A")
	}
}

interface B {
	fun printMeToo() {
		println("method of interface B")
	}
}

class multipleInterfaceExample:A,B

fun main(args:Array<String>) {
	val obj = multipleInterfaceExample()
	obj.printMe()
	obj.printMeToo()
}

// method of interface A
// method of interface B
