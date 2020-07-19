package application_covid.entities;

public class SMSOAuthObject {
    private String tokenType;
    private String accessToken;
    private String  expiresIn;

    public SMSOAuthObject(String tokenType,String accessToken,String expiresIn) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public SMSOAuthObject() {

    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }


}
