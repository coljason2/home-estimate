package com.home.estimate.app.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class EstimateModel {


    BigDecimal landPrice;
    BigDecimal volumeRate;
    BigDecimal sellRate;
    BigDecimal constructionCost;
    BigDecimal manageCost;
    BigDecimal profit;

}
