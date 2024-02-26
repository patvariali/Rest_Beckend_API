package patvari.ali.restbackend.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;


    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }
}
