package dev.matheuspereira.qrcodewebflux.domain.service;

import dev.matheuspereira.qrcodewebflux.core.dto.QRCodeRequestDTO;
import dev.matheuspereira.qrcodewebflux.domain.ports.driver.QRCodeGeneratorService;
import java.time.Duration;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QRCodeGeneratorServiceImpl implements QRCodeGeneratorService {

  @Override
  public Mono<String> generateQrCode(@NonNull QRCodeRequestDTO qrCodeRequestDTO) {
    return Mono.just(String.format(
        "00020101021226580014br.com.padraoq011600100002444700010208202020330304000127580010BR.COM.ELO0104838402150100002444700010308202020330401E52041302530398654%s%s5802BR59%s%s60%s%s62200516ECOECBXmIkHMb2ZV81600014br.com.padraoq01120610211908130204000203020104020105020382560010BR.COM.ELO011010061908130203C0103020104060000010801363044584",
        qrCodeRequestDTO.getAmount().toString().length(),
        qrCodeRequestDTO.getAmount(),
        qrCodeRequestDTO.getMerchantAccountInformation().getMerchantName().length(),
        qrCodeRequestDTO.getMerchantAccountInformation().getMerchantName(),
        qrCodeRequestDTO.getMerchantAccountInformation().getMerchantCity().length(),
        qrCodeRequestDTO.getMerchantAccountInformation().getMerchantCity()
    )).delayElement(Duration.ofSeconds(1));
  }
}
