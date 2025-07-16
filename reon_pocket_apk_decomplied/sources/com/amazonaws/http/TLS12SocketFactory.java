package com.amazonaws.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class TLS12SocketFactory extends SSLSocketFactory {
    private static final String[] SUPPORTED_PROTOCOLS = {"TLSv1", "TLSv1.1", "TLSv1.2"};
    private static final Object contextLock = new Object();
    private static SSLContext sslContext = null;
    private final SSLSocketFactory delegate;
    private LoggingHandshakeCompletedListener handshakeCompletedListener;

    public static TLS12SocketFactory createTLS12SocketFactory(SSLContext sSLContext) {
        return null;
    }

    public static void fixTLSPre21(HttpsURLConnection httpsURLConnection, TLS12SocketFactory tLS12SocketFactory) {
    }

    public static TLS12SocketFactory createTLS12SocketFactory() {
        return createTLS12SocketFactory((SSLContext) null);
    }

    public static void fixTLSPre21(HttpsURLConnection httpsURLConnection) {
        fixTLSPre21(httpsURLConnection, createTLS12SocketFactory());
    }

    private TLS12SocketFactory(SSLContext sSLContext) throws KeyManagementException, NoSuchAlgorithmException {
        if (sSLContext != null) {
            this.delegate = sSLContext.getSocketFactory();
        } else {
            synchronized (contextLock) {
                if (sslContext == null) {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    sslContext = instance;
                    instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                }
            }
            this.delegate = sslContext.getSocketFactory();
        }
        this.handshakeCompletedListener = new LoggingHandshakeCompletedListener();
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket();
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket(socket, str, i, z);
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket(str, i);
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket(str, i, inetAddress, i2);
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket(inetAddress, i);
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.delegate.createSocket(inetAddress, i, inetAddress2, i2);
        sSLSocket.addHandshakeCompletedListener(this.handshakeCompletedListener);
        return updateTLSProtocols(sSLSocket);
    }

    private Socket updateTLSProtocols(Socket socket) {
        if (socket instanceof SSLSocket) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(SUPPORTED_PROTOCOLS);
            } catch (Exception unused) {
            }
        }
        return socket;
    }
}
