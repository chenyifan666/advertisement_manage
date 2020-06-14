package com.cyf.advertisement.service.impl;

import com.cyf.advertisement.dto.AdvertisementDto;
import com.cyf.advertisement.dto.RequestDto;
import com.cyf.advertisement.entities.Advertisement;
import com.cyf.advertisement.repositories.AdvertisementRepository;
import com.cyf.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Override
    public AdvertisementDto getList() {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        List<Advertisement> advertisementList = advertisementRepository.findAll();
        advertisementDto.setTotal(advertisementList.size());
        advertisementDto.setRows(advertisementList);
        return advertisementDto;
    }

    @Override
    public RequestDto save(Advertisement advertisement) {
        RequestDto requestDto = new RequestDto();
        if(StringUtils.isEmpty(advertisement.getId())){
            advertisement.setId(UUID.randomUUID().toString());
        }
        try {
            advertisementRepository.save(advertisement);
            requestDto.setSuccess(true);
            requestDto.setMsg("保存成功");
        }catch (Exception e){
            requestDto.setSuccess(false);
            requestDto.setMsg("保存失败");
        }
        return requestDto;
    }

    @Override
    public RequestDto delete(String id) {
        advertisementRepository.deleteById(id);
        RequestDto requestDto = new RequestDto();
        requestDto.setSuccess(true);
        requestDto.setMsg("删除成功");
        return requestDto;
    }
}
