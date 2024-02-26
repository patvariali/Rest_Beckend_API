package patvari.ali.restbackend.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)@Data
public class TokenResponse {
    private String token;

    @JsonProperty("token")
    public String getToken() {
        return token;
    }
}
