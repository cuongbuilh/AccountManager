package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {
    private short id;

    private String name;


    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
