package com.tls.client.demotlsrestclient.bean;
import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Beans {
    public RestTemplate createRestTemplate() throws Exception {
        // Load the .p12 file into a KeyStore
        String keyStorePath = "path/to/your/keystore.p12";
        String keyStorePassword = "your_keystore_password";

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream keyStoreFile = new FileInputStream(keyStorePath)) {
            keyStore.load(keyStoreFile, keyStorePassword.toCharArray());
        }

        // Create an SSLContext with the KeyStore
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, keyStorePassword.toCharArray())
                .build();

        // Create an HttpClient with the SSLContext
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        // Create a RestTemplate with the HttpClient
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }
}
