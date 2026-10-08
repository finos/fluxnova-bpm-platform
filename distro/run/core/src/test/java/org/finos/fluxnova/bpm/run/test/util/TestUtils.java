/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.run.test.util;

import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStore;
import java.security.SecureRandom;

import jakarta.annotation.Nonnull;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public final class TestUtils {

  private TestUtils() {
  }

  /**
   * Creates a {@link RestTemplate} with a request factory that trusts the self-signed HTTPS
   * certificate used by the test server.
   *
   * <p>This helper keeps the SSL override scoped to the client instance instead of mutating
   * JVM-wide SSL defaults, which makes the HTTPS test stable even when the Surefire fork is
   * reused across multiple test classes.</p>
   */
  public static RestTemplate createTrustSelfSignedRestTemplate() {
    return new RestTemplate(new TrustSelfSignedClientHttpRequestFactory());
  }

  /**
   * Custom request factory that applies a trust-all SSL socket factory and hostname verifier
   * only for HTTPS connections created by this test client.
   */
  private static class TrustSelfSignedClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

    private final javax.net.ssl.SSLSocketFactory sslSocketFactory;

    private TrustSelfSignedClientHttpRequestFactory() {
      try {
        KeyStore trustStore = KeyStore.getInstance("PKCS12");
        try (InputStream trustStoreStream = getClass().getClassLoader().getResourceAsStream("keystore.p12")) {
          if (trustStoreStream == null) {
            throw new IllegalStateException("Could not load test keystore keystore.p12 from classpath");
          }
          trustStore.load(trustStoreStream, "camunda".toCharArray());
        }

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
        this.sslSocketFactory = sslContext.getSocketFactory();
      } catch (NoSuchAlgorithmException | KeyManagementException e) {
        throw new IllegalStateException("Could not create trust-self-signed SSL context", e);
      } catch (Exception e) {
        throw new IllegalStateException("Could not load test keystore keystore.p12", e);
      }
    }

    @Override
    protected void prepareConnection(@Nonnull HttpURLConnection connection, @Nonnull String httpMethod) throws IOException {
      super.prepareConnection(connection, httpMethod);

      if (connection instanceof HttpsURLConnection httpsConnection) {
        httpsConnection.setSSLSocketFactory(sslSocketFactory);
      }
    }
  }
}
