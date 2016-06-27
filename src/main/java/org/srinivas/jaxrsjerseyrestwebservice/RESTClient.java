/**
 * 
 */
package org.srinivas.jaxrsjerseyrestwebservice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Srinivas Kummari
 *
 */
public class RESTClient {

	//static final Logger logger=Logger.getLogger(RESTClient.class);
	public static void main(String[] args) throws JSONException {
		String str="";
		try {
			InputStream is=new FileInputStream("content.txt");
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String line="";
			while((line=br.readLine()) !=null){
				str +=line+"\n";
			}
			JSONObject jsonObject=new JSONObject(str);
			System.out.println(jsonObject);
			//logger.info(jsonObject);
			
			try {
				URL url=new URL("http://localhost:8080/JAX-RSWithJerseyRESTWebService/service/postService");
				URLConnection urlConnection=url.openConnection();
				urlConnection.setDoOutput(true);
				urlConnection.setRequestProperty("Content-Type", "application/json");
				urlConnection.setConnectTimeout(5000);
				urlConnection.setReadTimeout(5000);
				OutputStreamWriter out=new OutputStreamWriter(urlConnection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
				BufferedReader br1= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				while(br1.readLine() !=null){
					
				}
				System.out.println("REST service invoked successfully");
				//logger.info("REST service invoked successfully");
				br1.close();
				
			} catch (Exception e) {
				System.out.println("Error while calling rest service");
				//logger.error("Error while calling rest service");
			}
			br.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
