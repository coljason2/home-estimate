package com.home.estimate.app.controller;


import com.home.estimate.app.model.EstimateModel;
import com.home.estimate.app.service.EstimateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Slf4j
@Controller
public class AppController {

    @Autowired
    EstimateService estimateService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/estimate")
    public String estimate(@RequestParam(defaultValue ="80000") BigDecimal landPrice,
                           @RequestParam(defaultValue ="3.6") BigDecimal volumeRate,
                           @RequestParam(defaultValue ="1.55") BigDecimal sellRate,
                           @RequestParam(defaultValue ="150000") BigDecimal constructionCost,
                           @RequestParam(defaultValue ="1.15") BigDecimal manageCost,
                           @RequestParam(defaultValue ="1.3") BigDecimal profit,
                           Model model) {

        EstimateModel entity = new EstimateModel();
        entity.setLandPrice(landPrice);
        entity.setManageCost(manageCost);
        entity.setConstructionCost(constructionCost);
        entity.setProfit(profit);
        entity.setVolumeRate(volumeRate);
        entity.setSellRate(sellRate);

        BigDecimal result = estimateService.estimate(entity);

        model.addAttribute("result", result);
        model.addAttribute("entity", entity);

        return "result";
    }
}
