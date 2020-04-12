package com.phani.springbootquickstart.course_api;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
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
	void verifyGetTopics() throws ClientProtocolException, IOException {
		// Given
	    HttpUriRequest request = new HttpGet( "http://localhost:9090/topics");
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getStatusCode(),
	      (HttpStatus.SC_OK));

	}
	
	@Test
	public void testInvalidTopicStatusCode()
	  throws ClientProtocolException, IOException {
	  
	    // Given
	    HttpUriRequest request = new HttpGet( "http://localhost:9090/inValidTopic");
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getStatusCode(),
	      (HttpStatus.SC_NOT_FOUND));

	}
	    
	@Test
	public void
	givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:9090/topics/Hadoop" );
	 
	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	void verifyHadoopTopicJsonPayload() throws ClientProtocolException, IOException, JSONException {
        
		
	
		// Given
		HttpUriRequest request = new HttpGet( "http://localhost:9090/topics");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

		// Then
		assertEquals(
				httpResponse.getStatusLine().getStatusCode(),
				(HttpStatus.SC_OK));
		JSONObject jsonObj = new JSONObject(); 

		jsonObj.put("name", "Hadoop EcoSystem");
		jsonObj.put("description", "Hadoop Description");
		jsonObj.put("id", "Hadoop");

		assertEquals(jsonObj.toString(), httpResponse.toString());
	

		
	}
	
}
