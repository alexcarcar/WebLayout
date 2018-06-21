enum Tools {
	SCREWDRIVER, WRENCH, HAMMER, PLIERS
}

class ToolsDemo {
	public static void main(String[] args) {
		for (Tools t: Tools.values()) {
			System.out.println(t + " " + t.ordinal());
		}
	}	
}

// SCREWDRIVER 0
// WRENCH 1
// HAMMER 2
// PLIERS 3
