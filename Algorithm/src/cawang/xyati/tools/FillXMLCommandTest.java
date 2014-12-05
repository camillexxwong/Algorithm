package cawang.xyati.tools;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FillXMLCommandTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Object object=Arrays.asList(new String[]{"Revenue","Cost","Profit","Price"});
		System.out.println(object.getClass());
		List<String> allMetrics=(List<String>) object;

		FillXMLCommand obj=new FillXMLCommand();
		
		System.out.println("Command: "+obj.fillXMLCmd());
	}

}
