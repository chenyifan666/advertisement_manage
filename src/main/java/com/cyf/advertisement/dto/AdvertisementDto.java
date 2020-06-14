package com.cyf.advertisement.dto;

import com.cyf.advertisement.entities.Advertisement;
import lombok.Data;

import java.util.List;

@Data
public class AdvertisementDto {
    private int total;

    private List<Advertisement> rows;
}
