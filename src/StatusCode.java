public enum StatusCode {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int code;

    private String phrase;

    StatusCode(int code, String phrase) {
        this.code = code;
        this.phrase = phrase;
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

    public static String queryPhrase(int code) {
        for (StatusCode statusCode : StatusCode.values()) {
            if (statusCode.getCode() == code) {
                return statusCode.getPhrase();
            }
        }

        return null;
    }
}
