package dev.matheuspereira.qrcodewebflux.core.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RequestMapping(value = "${resource.examples.unblocking}", produces = "application/json")
public interface UnblockingExampleAPI {

  @ApiOperation(value = "Retorna de forma não bloqueante uma sequência de playlists")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> playlists() throws Exception;

  @ApiOperation(value = "Retorna de forma não bloqueante uma sequência de playlists")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @GetMapping("/exception")
  public Flux<String> playlistsWithException() throws Exception;

  @ApiOperation(value = "Gera um numero aletario de forma nao bloqueante")
  @ApiResponses(value = {
      @ApiResponse(code = 202, message = "Request accepted"),
      @ApiResponse(code = 500, message = "Internal server error"),
  })
  @GetMapping(value = "generate")
  public Mono<Integer> generate() throws InterruptedException;

}
