package com.planmill.api.datahelper.http;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.*;
import java.security.*;
import java.security.cert.X509Certificate;

/**
 * Could be used as workaround to some servers.
 * Add to test class:
 *
 * @Before
 * public void ignoreSslProblems() {
 *     SSLUtil.turnOffSslChecking();
 * }
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
public final class SSLUtil{

    private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[]{
        new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers(){
                return null;
            }
            public void checkClientTrusted( X509Certificate[] certs, String authType ){}
            public void checkServerTrusted( X509Certificate[] certs, String authType ){}
        }
    };

    public  static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            // Install the all-trusting trust manager
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, UNQUESTIONING_TRUST_MANAGER, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (Exception e) {
            log.error("Failed to ignore SSL problems.", e);
        }
    }

    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
        // Return it to the initial state (discovered by reflection, now hardcoded)
        SSLContext.getInstance("SSL").init( null, null, null );
    }

    private SSLUtil(){
        throw new UnsupportedOperationException( "Do not instantiate libraries.");
    }

}
