package cawang.xyati.tools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomXMLPrototypeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerateRandomXMLCmd() {
		RandomXMLPrototype obj=new RandomXMLPrototype();
		System.out.println(obj.generateRandomXMLCmd());
	}

}
