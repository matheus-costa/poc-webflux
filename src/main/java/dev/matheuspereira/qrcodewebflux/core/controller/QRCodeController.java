package dev.matheuspereira.qrcodewebflux.core.controller;

import dev.matheuspereira.qrcodewebflux.core.api.QRCodeAPI;
import dev.matheuspereira.qrcodewebflux.core.dto.QRCodeRequestDTO;
import dev.matheuspereira.qrcodewebflux.domain.ports.driver.QRCodeGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class QRCodeController implements QRCodeAPI {
  private final QRCodeGeneratorService qrCodeGeneratorService;

  @Override
  public Mono<String> generate(QRCodeRequestDTO qrCodeRequestDTO) throws InterruptedException {
    return qrCodeGeneratorService.generateQrCode(qrCodeRequestDTO);
  }
}
