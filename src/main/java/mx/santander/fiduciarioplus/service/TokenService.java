package mx.santander.fiduciarioplus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.santander.fiduciarioplus.dto.enums.OperationStatus;
import mx.santander.fiduciarioplus.dto.enums.TokenStatus;
import mx.santander.fiduciarioplus.dto.validate_token.req.PermissionDto;
import mx.santander.fiduciarioplus.dto.validate_token.req.ValidateTokenDataReqDto;
import mx.santander.fiduciarioplus.dto.validate_token.res.ValidateTokenDataDto;
import mx.santander.fiduciarioplus.dto.validate_token.res.ValidateTokenDataResDto;
import mx.santander.fiduciarioplus.dto.validate_token.res.ValidateTokenDto;
import mx.santander.fiduciarioplus.exception.catalog.InvalidDataCatalog;
import mx.santander.fiduciarioplus.exception.model.InvalidDataException;

@Service
public class TokenService implements ITokenService{

	@Value("${validate.token.permission.applicationKey}")
	private String APPLICATION_KEY;
	
	@Override
	public ValidateTokenDataResDto validateToken(ValidateTokenDataReqDto validateTokenReqDto) {
		ValidateTokenDataResDto validateTokenDataResDto = null;
		
		//Se agrega aplication_key del aplicativo proporcionado por Token Manager
		validateTokenReqDto.permission = PermissionDto.builder()
											.applicationKey(APPLICATION_KEY)
											.build();
		System.out.println(validateTokenReqDto.toString());
		if(validateTokenReqDto.otp ==null || validateTokenReqDto.buc==null) {
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Se han enviado datos null");
		}
		if(validateTokenReqDto.buc.equals("") || validateTokenReqDto.otp.equals("")) {
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Se han enviado datos vacios");
		}
		
		validateTokenDataResDto = validateTokenDataResDto.builder()
									.data(ValidateTokenDataDto.builder()
											.operationStatus(OperationStatus.VALID.toString())	//Estatus de la operacion
											.attempts(1)	//Intentos de validar token
											.token(ValidateTokenDto.builder()
													.status(TokenStatus.ACTIVE.toString())	//Estatus del token
													.code(9512)	//COdigo verificador token
													.build())
											.build())
									.build();
		
		return validateTokenDataResDto;
	}

}
