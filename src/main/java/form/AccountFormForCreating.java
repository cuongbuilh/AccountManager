package form;

import lombok.Data;

@Data
public class AccountFormForCreating {
    private String email;
    private String username;
    private String fullname;
    private short departmentId;
    private short positionId;

}

