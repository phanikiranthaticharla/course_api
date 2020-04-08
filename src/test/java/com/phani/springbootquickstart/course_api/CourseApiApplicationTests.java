package com.phani.springbootquickstart.course_api;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/** 
 * 
 * @author Phani Kiran Thaticharla
 *
 */


@SpringBootTest
class CourseApiApplicationTests {

	// JUnit Test for verifying GET Request
	@Test
	void verifyGETRequest() {
        
		
		try {
			URL url = new URL("http://localhost:9090/topics"); 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();

			int expectedCode = 200; 
			assertEquals(expectedCode, responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println("response "+response.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}
	
}
