package dev.matheuspereira.qrcodewebflux.domain.ports.driver;

import dev.matheuspereira.qrcodewebflux.core.dto.QRCodeRequestDTO;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Validated
public interface QRCodeGeneratorService {
  Mono<String> generateQrCode(@NonNull final QRCodeRequestDTO qrCodeRequestDTO);
}
