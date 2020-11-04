package MavenLearning;

import java.io.IOException;
import java.util.ArrayList;

public class Test5_mainTestData {

	public static void main(String[] args) throws IOException {
		
		Test5_testDataDrivenFromExcel d=new Test5_testDataDrivenFromExcel();
ArrayList data=d.getData("login id");

System.out.println(data.get(0));
System.out.println(data.get(1));
System.out.println(data.get(2));



	}

}
