// https://www.tutorialspoint.com/kotlin/kotlin_visibility_control.htm

private class privateExample {
	private val i = 1
	private fun doSomething() {
		println("doSomething ${i}")
	}
	fun something() {
		doSomething()
	}
}

// ================================================

open class A() {
	protected val i = 1
}

class B:A() {
	fun getValue():Int {
		return i
	}
}

// ================================================

class internalExample {
	internal val i = 1
	internal fun doSomething() {
		println("internal something ${i}")
	}
}

// ================================================

class publicExample {
	val i = 1
	fun doSomething() {
		println("public something ${i}")
	}
}


fun main(args:Array<String>) {
	val p = privateExample()
	p.something() // doSomething 1

	val b = B()
	println("value of i in B: ${b.getValue()}") // value of i in B: 1

	val i = internalExample()
	i.doSomething() // internal something 1

	val pub = publicExample()
	pub.doSomething() // public something 1
}