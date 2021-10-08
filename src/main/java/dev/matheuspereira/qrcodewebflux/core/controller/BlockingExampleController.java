package dev.matheuspereira.qrcodewebflux.core.controller;

import dev.matheuspereira.qrcodewebflux.core.api.BlockingExampleAPI;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class BlockingExampleController implements BlockingExampleAPI {

  @Override
  public Mono<Integer> generate() throws InterruptedException {
    System.out.println("STARTING PROCESS OF REQUEST");
    Random random = new Random();
    System.out.println("NUMBER GENERATED");
    TimeUnit.SECONDS.sleep(2L);
    System.out.println("FINISHING PROCESS OF REQUEST");
    return Mono.just(random.nextInt());
  }

  @Override
  public Mono<String> requestHttp() throws Exception {
    System.out.println("STARTING PROCESS OF REQUEST");
    Random random = new Random();
    var requestId = random.nextInt();

    for (int i = 1; i <= 100; i++) {
      var time = new Date().getTime();
      getMovies(time, requestId);
    }
    System.out.println("FINISHING PROCESS OF REQUEST");
    return Mono.just("Movies get");
  }

  public static void getMovies(long time, int requestId) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.themoviedb.org/3/movie/550?api_key=673abec37865b2c1c0dd3eb412289b2f"))
        .build();

    HttpResponse<String> response =
        client.send(request, BodyHandlers.ofString());

    System.out.println("REQUEST: " + requestId + " - TIME: " + time + " - " + response.body());
  }
}
