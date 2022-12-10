package page_object;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPageObject {

public WebDriver driver;	
	
public CommonPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
     
     this.driver = driver;	
}

public void verify_image_link_is_not_broken(List<WebElement> elements, String page) {
		
	   	List<WebElement> images = elements;
	   	for(int i=0; i<images.size();i++) {  		
	   		if(images.size() !=0) {
	   			 try {
	   				CloseableHttpClient client = HttpClientBuilder.create().build();
		   		    HttpGet request = new HttpGet(images.get(i).getAttribute("src"));
		   		    HttpResponse response = client.execute(request);
		   		   if (response.getStatusLine().getStatusCode() == 200)
	               {
		   			     System.out.println("any images are not broken on"+page);
	               } 
		   		   else {
		   			   System.out.println("image is broken on"+page);
		   		   }
	   			 }
	   			 catch(Exception e) {
	   				 e.printStackTrace();
	   			 }
	   		}
	   	}
	}


public void verify_links_on_dashboard_are_not_broken(List<WebElement> li) {
	String url = "";
	HttpURLConnection huc;
	
	List<WebElement> links = li;
	Iterator<WebElement> links_it = links.iterator();
	while(links_it.hasNext()) {
	   url = links_it.next().getAttribute("href");
	   System.out.println(url);
	   if(url == null || url.isEmpty()) {
		   System.out.println("no url is present for link");
		   continue;
	   }
	
	   try {
		   
		   huc = (HttpURLConnection) (new URL(url).openConnection());
		   int responseStatus = huc.getResponseCode();
		   if(responseStatus >= 200 && responseStatus < 400) {
			  System.out.println("links are not broken");
		   }
		   
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	}
}
	
	
}
