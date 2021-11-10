package com.kodluyoruz.hotelreservationap.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "campaign")
@Data
public class CampaignProperties {
    private Integer campaignDay;
}
