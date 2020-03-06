/**
 * @Author: ZealYoung
 * @Time: 2020/3/2 5:58 下午
 * @Description:
 */

public class ResponseHeaders extends Headers {

    public static final String DEFAULT_HTTP_VERSION = "HTTP/1.1";

    public static final String SERVER_NAME = "coolblog-xyz-httpd";

    private int code;

    private String phrase;

    private String contentType;

    private int contentLength;

    private String server;

    public ResponseHeaders(int code) {
        this.code = code;
        this.server = SERVER_NAME;
        this.phrase = StatusCode.queryPhrase(code);
        setVersion(DEFAULT_HTTP_VERSION);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d %s\r\n", getVersion(), code, phrase));
        sb.append(String.format("ContentType: %s\r\n", contentType));
        sb.append(String.format("ContentLength: %d\r\n", contentLength));
        sb.append(String.format("Server: %s\r\n", server));
        sb.append("\r\n");
        return sb.toString();
    }
}
