package form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat
public class AccountFromForUpdating implements Serializable {
    private String fullname;
    private short departmentId;
    private short positionId;
}
