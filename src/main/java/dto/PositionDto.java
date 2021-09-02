package dto;

public class PositionDto {
    private short id;

    private String name;
    

    public PositionDto(short id, String toString) {
        this.id = id;
        this.name = name;
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
