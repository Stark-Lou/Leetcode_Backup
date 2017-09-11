package nio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @描述：
 * @创建者： Louzhoucheng
 * @日期： 2017-04-23 15:09
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-23 15:09
 * @版本： v1.0
 */
public class BIO {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(5678));
            while (!Thread.currentThread().isInterrupted()) {
                //主线程死循环等待新连接的到来
                Socket socket = serverSocket.accept();
                executorService.submit(new ConnectionHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ConnectionHandler extends Thread {
        private Socket socket;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
                try {
                    //读取输入内容
                    InputStream is = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String info = null;
                    while ((info = br.readLine()) != null) {
                        System.out.println(info);
                        if (info.equals("end"))
                            break;
                    }
                    //获取输出流，写入输出内容
                    OutputStream os = socket.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);
                    pw.write("输出内容");
                    pw.flush();

                    pw.close();
                    os.close();
                    br.close();
                    isr.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
