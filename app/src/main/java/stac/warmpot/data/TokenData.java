package stac.warmpot.data;

public class TokenData {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public TokenData(String token) {
        this.token = token;
    }
}
