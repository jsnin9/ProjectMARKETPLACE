package pakaTest;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		
		ArrayList<Integer> tab = new ArrayList<>();
		
		tab.add(8);
		tab.add(85);
		tab.set(0, 785);
		System.out.println(tab.toString());
	}

}
