package NIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @描述：
 * @创建者： Louzhoucheng
 * @日期： 2017-04-24 15:22
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-24 15:22
 * @版本： v1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        if(!file.exists())
            file.createNewFile();
        System.out.println(file.getAbsolutePath());
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = "java nio";
        buffer.put(string.getBytes());
        buffer.flip();     //此处必须要调用buffer的flip方法
        channel.write(buffer);
        channel.close();
        outputStream.close();
    }
}