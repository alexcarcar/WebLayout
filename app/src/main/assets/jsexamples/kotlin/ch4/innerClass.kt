fun main(args:Array<String>) {
	val demo = Outer().Nested().foo()
	println(demo)
}
class Outer {
	private val welcomeMsg:String = "Welcome"
	inner class Nested {
		fun foo() = welcomeMsg
	}
}
// Welcome

