package dev.matheuspereira.qrcodewebflux.core.controller;

import dev.matheuspereira.qrcodewebflux.core.api.UnblockingExampleAPI;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class UnblockingExampleController implements UnblockingExampleAPI {
  private final String[] playlists = {"Top 50 global", "Rock", "POP", "MPB", "Sertanejo", "Viral 50 Brasil",
      "50 mais tocadas", "This is Codplay", "This is Alok"};

  @Override
  public Mono<Integer> generate() throws InterruptedException {
    log.info("STARTING PROCESS OF REQUEST");
    Random random = new Random();
    log.info("NUMBER GENERATED");
    log.info("FINISHING PROCESS OF REQUEST");
    return Mono.just(random.nextInt()).delayElement(Duration.ofSeconds(1));
  }

  @Override
  public Flux<String> playlists() throws Exception {
    Random random = new Random();
    var requestId = random.nextInt();
    var time = new Date().getTime();

    log.info("{} - STARTING PROCESS OF REQUEST: {}", time, requestId);
    return Flux.fromArray(playlists)
        .delayElements(Duration.ofSeconds(1))
        .log("FINISH PROCESS OF REQUEST: " + requestId);
  }

  @Override
  public Flux<String> playlistsWithException() throws Exception {
    return Flux.fromArray(playlists)
        .flatMap(s -> Flux.just(s.substring(10)))
        .delayElements(Duration.ofSeconds(1));
  }
}
