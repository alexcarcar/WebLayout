// https://www.tutorialspoint.com/kotlin/kotlin_control_flow.htm
// 
// kotlinc controlFlow.kt -include-runtime -d controlFlow.jar
// java -jar controlFlow.jar

fun main(args: Array<String>) {

	// Example 1: If - Else
	val a:Int = 5
	val b:Int = 2
	var max:Int
	if (a>b) {
		max = a
	} else {
		max = b
	}
	println(max) // 5
	// val max = if (a > b) a else b
	// ---------------------------------------------

	// Example 2: Use of When
	val x:Int = 5
	when(x) {
		1,2 -> println("value of x either 1,2")
		else -> { // note the block
			println("x is neither 1 or 2")
		}
	} // x is neither 1 or 2
	// ---------------------------------------------

	// Example 3: For Loop
	val items = listOf(1, 4, 9, 16)
	for (i in items) print("-" + i) // -1-4-9-16
	println()
	for ((i, v) in items.withIndex()) print("-"+i+","+v)
	println() // -0,1-1,4-2,9-3,16
}