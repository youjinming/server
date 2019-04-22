package com.chinasofti.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Control {
	
	private ServerSocket server;
	public static final int PORT = 9999;
	private ExecutorService es;
	private yaHuiBiz yh;
	public Control() {
		try {
			System.out.println("服务器启动中");
			this.server = new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已启动");
			es = Executors.newCachedThreadPool();
			this.yh = new yaHuiBizImpl();

		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}
	
	public void start(){
		while(true){
			try {
				Socket client = this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				ControlThread ct = new ControlThread(client,yh);
				es.submit(ct);
				int num = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前活跃用户为:"+num);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
