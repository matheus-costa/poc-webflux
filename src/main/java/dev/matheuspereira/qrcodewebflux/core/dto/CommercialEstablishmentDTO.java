package dev.matheuspereira.qrcodewebflux.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommercialEstablishmentDTO {

  private String merchantName;

  private String merchantCity;

}
