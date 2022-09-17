package com.xjy.practice.common.enums;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@AllArgsConstructor
@ToString

public enum RiskCallbackEntryStatusMappingEnum {

  bo(RiskCallBackStatusEnum.PASS, EntryStatusEnum.PASS);


  private RiskCallBackStatusEnum riskCallBackStatusEnum;
  private EntryStatusEnum entryStatusEnum;

  public static RiskCallbackEntryStatusMappingEnum getMappingEnumByRiskCallBackStatus(
      String riskCallBackStatus) throws Exception {
    if (StringUtils.isEmpty(riskCallBackStatus)) {
      throw new Exception("");
    }

    Optional<RiskCallbackEntryStatusMappingEnum> mappingEnumOptional = Arrays.stream(
            RiskCallbackEntryStatusMappingEnum.values())
        .filter(mappingEnum -> riskCallBackStatus.equals(
            mappingEnum.getRiskCallBackStatusEnum().getCode()))
        .findAny();
    if (!mappingEnumOptional.isPresent()) {
      throw new Exception("");
    }
    return mappingEnumOptional.get();

  }

  public static RiskCallbackEntryStatusMappingEnum getMappingEnumByEntryStatus(String entryStatus)
      throws Exception {
    if (StringUtils.isEmpty(entryStatus)) {
      throw new Exception("");
    }

    Optional<RiskCallbackEntryStatusMappingEnum> mappingEnumOptional = Arrays.stream(
            RiskCallbackEntryStatusMappingEnum.values())
        .filter(mappingEnum -> entryStatus.equals(mappingEnum.getEntryStatusEnum().getCode()))
        .findAny();
    if (!mappingEnumOptional.isPresent()) {
      throw new Exception("");
    }
    return mappingEnumOptional.get();

  }

  public static EntryStatusEnum getEntryStatusByRiskCallBackStatus(String riskCallBackStatus)
      throws Exception {
    if (StringUtils.isEmpty(riskCallBackStatus)) {
      throw new Exception("");
    }

    Optional<RiskCallbackEntryStatusMappingEnum> mappingEnumOptional = Arrays.stream(
            RiskCallbackEntryStatusMappingEnum.values())
        .filter(mappingEnum -> riskCallBackStatus.equals(
            mappingEnum.getRiskCallBackStatusEnum().getCode()))
        .findAny();
    if (!mappingEnumOptional.isPresent()) {
      throw new Exception("");
    }
    return mappingEnumOptional.get().getEntryStatusEnum();

  }

  public static RiskCallBackStatusEnum getRiskCallBackStatusByEntryStatus(String entryStatus)
      throws Exception {
    if (StringUtils.isEmpty(entryStatus)) {
      throw new Exception("");
    }

    Optional<RiskCallbackEntryStatusMappingEnum> mappingEnumOptional = Arrays.stream(
            RiskCallbackEntryStatusMappingEnum.values())
        .filter(mappingEnum -> entryStatus.equals(mappingEnum.getEntryStatusEnum().getCode()))
        .findAny();
    if (!mappingEnumOptional.isPresent()) {
      throw new Exception("");
    }
    return mappingEnumOptional.get().getRiskCallBackStatusEnum();

  }

  public static void main(String[] args) throws Exception {
    String riskResult = "A7";
    String entryStatus = "A10";
    RiskCallbackEntryStatusMappingEnum e1 = RiskCallbackEntryStatusMappingEnum.getMappingEnumByEntryStatus(
        entryStatus);
    RiskCallbackEntryStatusMappingEnum e2 = RiskCallbackEntryStatusMappingEnum.getMappingEnumByRiskCallBackStatus(
        riskResult);

    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e1.equals(e2));
    EntryStatusEnum e3 = RiskCallbackEntryStatusMappingEnum.getEntryStatusByRiskCallBackStatus(
        riskResult);
    RiskCallBackStatusEnum e4 = RiskCallbackEntryStatusMappingEnum.getRiskCallBackStatusByEntryStatus(
        entryStatus);

    System.out.println(e3);
    System.out.println(e4);
  }

}
