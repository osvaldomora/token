package mx.santander.fiduciarioplus.service;

import mx.santander.fiduciarioplus.dto.validate_token.req.ValidateTokenDataReqDto;
import mx.santander.fiduciarioplus.dto.validate_token.res.ValidateTokenDataResDto;

public interface ITokenService {

	ValidateTokenDataResDto validateToken (ValidateTokenDataReqDto validateTokenReqDto);
	
}
