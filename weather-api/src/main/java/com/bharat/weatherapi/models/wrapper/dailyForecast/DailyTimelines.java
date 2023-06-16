package com.bharat.weatherapi.models.wrapper.dailyForecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class DailyTimelines {
    private List<DailyForecast> daily;
}
