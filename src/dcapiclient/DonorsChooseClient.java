package dcapiclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationConfig;

public class DonorsChooseClient {

	/*
	 * public ProjectListing[] getProjects(String state, String zipCode, ...) {
	 * }
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		try {

			URL url = new URL("https://api.donorschoose.org/common/json_feed.html?state=NC&community=10007:3&APIKey=DONORSCHOOSE");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			StringBuilder completeJSONResponse = new StringBuilder();
			while ((output = br.readLine()) != null) {
				completeJSONResponse.append(output);
			}
			
			ObjectReader reader = new ObjectMapper().readerFor(ProjectListing.class);
			ProjectListing listing = reader.readValue(completeJSONResponse.toString());

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}
