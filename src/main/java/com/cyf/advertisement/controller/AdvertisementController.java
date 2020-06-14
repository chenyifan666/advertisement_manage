package com.cyf.advertisement.controller;

import com.cyf.advertisement.dto.AdvertisementDto;
import com.cyf.advertisement.dto.RequestDto;
import com.cyf.advertisement.entities.Advertisement;
import com.cyf.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adv")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/list")
    public AdvertisementDto getList(){
        return advertisementService.getList();
    }

    @PostMapping("/save")
    public RequestDto save(Advertisement advertisement){
        return advertisementService.save(advertisement);
    }

    @GetMapping("/delete/{id}")
    public RequestDto delete(@PathVariable("id") String id){
        RequestDto requestDto = advertisementService.delete(id);
        return requestDto;
    }
}
