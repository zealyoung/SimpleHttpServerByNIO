import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Author: ZealYoung
 * @Time: 2020/3/2 6:09 下午
 * @Description:
 */

public class JSONParseUtil {
    private static final String JSON_PATH = "static/content-type.json";

    private static JSONObject jsonObject;

    public static JSONObject getJsonObject() {
        return jsonObject;
    }

    static{
        try {
            jsonObject = parseJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject parseJSON() throws IOException {
        RandomAccessFile file = new RandomAccessFile(JSON_PATH, "r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        CharBuffer charBuffer = null;
        try {
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            charBuffer = decoder.decode(byteBuffer);
            byteBuffer.flip();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JSONObject object = (JSONObject) JSONUtil.parse(charBuffer.toString());

        return object;
    }
}
