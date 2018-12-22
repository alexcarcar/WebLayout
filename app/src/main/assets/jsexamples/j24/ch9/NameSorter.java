import java.util.*;

class NameSorter {
	public static void main(String[] args) {
		String names[] = {
			"Glimmer", "Marvel", "Rue", "Clove", "Thresh", "Foxfafce",
			"Cato", "Peeta", "Katniss"
		};
		System.out.println("The original order:");
		for (int i=0; i<names.length; i++) {
			System.out.println(i+": "+names[i]);
		}
		System.out.println();
		Arrays.sort(names);
		System.out.println("The new order:");
		for (int i=0; i<names.length; i++) {
			System.out.println(i+": "+names[i]);
		}
		System.out.println();
		// The original order:
		// 0: Glimmer
		// 1: Marvel
		// 2: Rue
		// 3: Clove
		// 4: Thresh
		// 5: Foxfafce
		// 6: Cato
		// 7: Peeta
		// 8: Katniss

		// The new order:
		// 0: Cato
		// 1: Clove
		// 2: Foxfafce
		// 3: Glimmer
		// 4: Katniss
		// 5: Marvel
		// 6: Peeta
		// 7: Rue
		// 8: Thresh
	}
}