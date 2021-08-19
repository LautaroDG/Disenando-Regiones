package test;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert {
	
	public static void iguales(Set<Integer> alcanzables, int[] esperados) {
		
		assertEquals(alcanzables.size(), esperados.length);
		for( int elemento : esperados) {
			assertTrue(alcanzables.contains(elemento));
		}
	}
}
