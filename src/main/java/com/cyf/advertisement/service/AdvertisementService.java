package com.cyf.advertisement.service;

import com.cyf.advertisement.dto.AdvertisementDto;
import com.cyf.advertisement.dto.RequestDto;
import com.cyf.advertisement.entities.Advertisement;
import org.springframework.stereotype.Service;

public interface AdvertisementService {

    AdvertisementDto getList();

    RequestDto save(Advertisement advertisement);

    RequestDto delete(String id);
}
