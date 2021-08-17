
package mx.santander.fiduciarioplus.dto.validate_token.res;

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
public class ValidateTokenDataResDto implements Serializable{

	private static final long serialVersionUID = 1L;
	public ValidateTokenDataDto data;

}
