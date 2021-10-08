package dev.matheuspereira.qrcodewebflux.core.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QRCodeRequestDTO {

  private BigDecimal amount;

  private CommercialEstablishmentDTO merchantAccountInformation;

}
