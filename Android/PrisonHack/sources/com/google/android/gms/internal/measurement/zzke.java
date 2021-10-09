package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzke extends SSLSocket {
    private final SSLSocket zzarv;

    zzke(zzkd zzkd, SSLSocket sSLSocket) {
        this.zzarv = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzarv.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.zzarv.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.zzarv.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.zzarv.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        this.zzarv.connect(socketAddress, i);
    }

    public final boolean equals(Object obj) {
        return this.zzarv.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.zzarv.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.zzarv.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zzarv.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.zzarv.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.zzarv.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.zzarv.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.zzarv.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zzarv.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zzarv.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zzarv.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.zzarv.getNeedClientAuth();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.zzarv.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zzarv.getOutputStream();
    }

    public final int getPort() {
        return this.zzarv.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.zzarv.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zzarv.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.zzarv.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.zzarv.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.zzarv.getSession();
    }

    public final int getSoLinger() throws SocketException {
        return this.zzarv.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.zzarv.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzarv.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.zzarv.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.zzarv.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.zzarv.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.zzarv.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.zzarv.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.zzarv.isBound();
    }

    public final boolean isClosed() {
        return this.zzarv.isClosed();
    }

    public final boolean isConnected() {
        return this.zzarv.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zzarv.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zzarv.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzarv.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i) throws IOException {
        this.zzarv.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.zzarv.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.zzarv.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.zzarv.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zzarv.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.zzarv.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.zzarv.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.zzarv.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.zzarv.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) throws SocketException {
        this.zzarv.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.zzarv.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) throws SocketException {
        this.zzarv.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) throws SocketException {
        this.zzarv.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) throws SocketException {
        this.zzarv.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.zzarv.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) throws SocketException {
        this.zzarv.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean z) {
        this.zzarv.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.zzarv.setWantClientAuth(z);
    }

    public final void shutdownInput() throws IOException {
        this.zzarv.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.zzarv.shutdownOutput();
    }

    public final void startHandshake() throws IOException {
        this.zzarv.startHandshake();
    }

    public final String toString() {
        return this.zzarv.toString();
    }
}
