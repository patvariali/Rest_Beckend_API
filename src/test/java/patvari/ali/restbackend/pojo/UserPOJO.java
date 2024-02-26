package patvari.ali.restbackend.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserPOJO {
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("firstName")
        private String firstName;


}
