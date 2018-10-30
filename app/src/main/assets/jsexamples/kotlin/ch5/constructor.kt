// https://www.tutorialspoint.com/kotlin/kotlin_constructors.htm

fun main(args:Array<String>) {
	val person1 = Person("Simon", 11)
	println("First Name: ${person1.firstName}")
	println("Age: ${person1.age}")
	// First Name: Simon
	// Age: 11

	val HUman = HUman("George", 6)
	println("${HUman.message} ${HUman.firstName} (${HUman.age})")
	// Hey!! George (6)

	val HUman2 = HUman("Shibly", 5, "Hi!!")
	println("${HUman2.message} ${HUman2.firstName} (${HUman2.age})")
	// Hi!!Hey!! Shibly (5)

}

class Person(val firstName:String, var age:Int) {}
class HUman(val firstName:String, var age:Int) {
	val message:String = "Hey!!"
	constructor(name:String, age:Int, message:String):this(name,age) {
		print(message)
	}
}