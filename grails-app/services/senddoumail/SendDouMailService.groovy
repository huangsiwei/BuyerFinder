package senddoumail

import org.apache.http.Header
import org.apache.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

class SendDouMailService {

    def testLogin() {
        String loginURL = "http://www.douban.com/accounts/login"
        DefaultHttpClient client = new DefaultHttpClient(new ThreadSafeClientConnManager())
        HttpPost httpPost = new HttpPost(loginURL);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("form_email", "hsw117@sina.com"));
        params.add(new BasicNameValuePair("form_password", "089392"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse response = client.execute(httpPost);
        Header locationHeader = response.getFirstHeader("Location");
        HttpGet httpget = new HttpGet(locationHeader.getValue());
        HttpResponse response2 = client.execute(httpget);
        String entity = EntityUtils.toString(response2.getEntity());
        println("end")
    }
}
