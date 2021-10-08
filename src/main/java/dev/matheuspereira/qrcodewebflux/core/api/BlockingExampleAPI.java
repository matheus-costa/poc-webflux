package dev.matheuspereira.qrcodewebflux.core.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@CrossOrigin
@RequestMapping(value = "${resource.examples.blocking}", produces = "application/json")
public interface BlockingExampleAPI {

  @ApiOperation(value = "Gera um numero aletario de forma bloqueante")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @GetMapping
  public Mono<Integer> generate() throws InterruptedException;

  @ApiOperation(value = "Realiza uma requisicao HTTP de forma bloqueante")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @GetMapping("/http")
  public Mono<String> requestHttp() throws Exception;
}
