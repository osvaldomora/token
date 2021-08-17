package mx.santander.fiduciarioplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.fiduciarioplus.dto.validate_token.req.ValidateTokenDataReqDto;
import mx.santander.fiduciarioplus.dto.validate_token.res.ValidateTokenDataResDto;
import mx.santander.fiduciarioplus.service.ITokenService;

@RestController
@RequestMapping("/api/token/v1")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST}, allowedHeaders = "*")
public class TokenController {
	
	@Autowired
	private ITokenService tokenService;
	
	@PostMapping(value = "/validate_token")
	public ResponseEntity<?> validaToken(@RequestBody ValidateTokenDataReqDto validateTokenDataReqDto){
		ValidateTokenDataResDto validateTokenDataResDto = tokenService.validateToken(validateTokenDataReqDto);
		return ResponseEntity.status(HttpStatus.OK).body(validateTokenDataResDto);
	}

}
