package com.home.estimate.app.service;


import com.home.estimate.app.model.EstimateModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EstimateService {

    public BigDecimal estimate(EstimateModel model) {
        /**
         *公式： [土地成本 / (容積率*建坪比) + 建築成本] * 管銷費 * 利潤
         **/
        return model.getLandPrice()
                .divide(model.getVolumeRate().multiply(model.getSellRate()))
                .add(model.getConstructionCost())
                .multiply(model.getManageCost())
                .multiply(model.getProfit());
    }
}
