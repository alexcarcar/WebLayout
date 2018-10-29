// https://www.tutorialspoint.com/kotlin/kotlin_basic_types.htm
// 
// kotlinc basicTypes.kt -include-runtime -d basicTypes.jar
// java -jar basicTypes.jar

fun main(args: Array<String>) {

	// Numbers
	val a: Int = 1000
	val d: Double = 100.00
	val f: Float = 100.00f
	val l: Long = 100000004
	val s: Short = 10
	val b: Byte = 1

	println("Your Int Value is "+a)
	println("Your Double Value is "+d)
	println("Your Float Value is "+f)
	println("Your Long Value is "+l)
	println("Your Short Value is "+s)
	println("Your Byte Value is "+b)

	// Your Int Value is 1000
	// Your Double Value is 100.0
	// Your Float Value is 100.0
	// Your Long Value is 100000004
	// Your Short Value is 10
	// Your Byte Value is 1

	// Characters
	val letter: Char 	// defining a variable
	letter = 'A'
	println("$letter")
	// A

	// Boolean
	var boo: Boolean
	boo = true
	println("Your boolean is $boo")
	// Your boolean is true
}