// https://www.tutorialspoint.com/kotlin/kotlin_extension.htm

class Alien {
	var skills:String = "null"
	fun printMySkills() {
		println(skills)
	}
}

fun main(args:Array<String>) {
	var a1 = Alien()
	a1.skills = "JAVA"
	a1.printMySkills() // JAVA

	var a2 = Alien()
	a2.skills = "SQL"
	a2.printMySkills() // SQL

	var a3 = Alien()
	a3.skills = a1.addMySkills(a2)
	a3.printMySkills() // JAVA SQL

	// An example of "companion object"
	// (static method implementation)
	println("Heyy!!! " + A.show())
	// Heyy!!! You are learning Kotlin!
}

// implementing "addMySkills()"
// (using extensions)
fun Alien.addMySkills(a:Alien):String {
	var a4 = Alien()
	a4.skills = this.skills + " " + a.skills
	return a4.skills
}

class A {
	companion object {
		fun show():String {
			return("You are learning Kotlin!")
		}
	}
}