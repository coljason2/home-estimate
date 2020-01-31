package com.home.estimate.app.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel("試算MODEL")
@Data
public class EstimateModel {


    @ApiModelProperty("土地成本費用/平方公尺")
    BigDecimal landPrice;
    @ApiModelProperty("容積率")
    BigDecimal volumeRate;
    @ApiModelProperty("售坪比")
    BigDecimal sellRate;
    @ApiModelProperty("建造成本")
    BigDecimal constructionCost;
    @ApiModelProperty("管銷費用")
    BigDecimal manageCost;
    @ApiModelProperty("利潤")
    BigDecimal profit;

}
