package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private String name;
    private String shortName;
    private Map<String, String> leader;  // { "id": "2-1" }
    private Integer startingNumber;
    private Boolean createContent;
}
