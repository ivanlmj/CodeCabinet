import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CustomHttpClient {
	
	public static void main(String[] args) throws Exception  {
		
		httpGet();
	}
	
	public static void httpGet() throws Exception {

		String uri = "http://127.0.0.1:5000/";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity));
			}
		} finally {
			response.close();
		}	
	}

}
