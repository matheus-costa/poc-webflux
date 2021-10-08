package dev.matheuspereira.qrcodewebflux.core.api;

import dev.matheuspereira.qrcodewebflux.core.dto.QRCodeRequestDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@CrossOrigin
@RequestMapping("${resource.qrcode.path}")
public interface QRCodeAPI {

  @ApiOperation(value = "Gera um QRCode de forma assíncrona")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 403, message = "Unauthorized"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @PostMapping(produces="application/json")
  public Mono<String> generate(@RequestBody QRCodeRequestDTO qrCodeRequestDTO) throws InterruptedException;
}