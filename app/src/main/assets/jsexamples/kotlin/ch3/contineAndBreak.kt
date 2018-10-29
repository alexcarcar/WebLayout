fun main(args: Array<String>) {
	myLabel@ for(x in 1..10) { // applying the custom label
		if (x==5) {
			println("in if with x="+x)
			break@myLabel
		} else {
			println("in else with x="+x)
			continue@myLabel
		}
	}
	// in else with x=1
	// in else with x=2
	// in else with x=3
	// in else with x=4
	// in if with x=5
}