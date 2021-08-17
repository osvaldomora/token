package mx.santander.fiduciarioplus.dto.validate_token.req;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateTokenDataReqDto implements Serializable{


	public String buc;
    public String otp;
    public PermissionDto permission;
    
	private static final long serialVersionUID = 1L;

}
