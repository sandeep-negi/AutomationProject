package qa.custom.api.model.pojo.teacherInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Klasses {
    private String id;
    @JsonProperty("is_enrolled_in_springboard")
    private boolean isEnrolledInSpringboard;
    @JsonProperty("is_eligible_for_springboard")
    private boolean isEligibleForSpringboard;
    @JsonProperty("is_eligible_for_springboard_tab")
    private boolean isEligibleForSpringboardTab;
}
