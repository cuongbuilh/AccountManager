package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class AccountDto {
    private short id;
    private String email;
    private String username;
    private String fullname;
    private String department;
    private String position;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;
}
