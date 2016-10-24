package org.acme.micro.streaming.consumer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;

public class SocketConnectionCheck {

	public static void main(String[] args) {

		InetSocketAddress address = new InetSocketAddress("192.168.249.129", 9092);
		try (SocketChannel socketChannel = SocketChannel.open();) {
			socketChannel.configureBlocking(false);
			Socket socket = socketChannel.socket();
			socket.setKeepAlive(true);

			socket.setTcpNoDelay(true);
			boolean connected;
			try {
				connected = socketChannel.connect(address);
			} catch (UnresolvedAddressException e) {
				socketChannel.close();
				throw new IOException("Can't resolve address: " + address, e);
			} catch (IOException e) {
				socketChannel.close();
				throw e;
			}
			System.out.println("connected-------------> " + connected);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
