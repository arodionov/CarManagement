/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.model.utils;

import com.epam.model.car.CarColor;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author andrii
 */

@Converter//(autoApply = true)
public class ColorConvertor implements AttributeConverter<CarColor, String>{

    @Override
    public String convertToDatabaseColumn(CarColor attribute) {      
        return attribute == null ? null : attribute.color.name();
    }

    @Override
    public CarColor convertToEntityAttribute(String dbData) {                  
        return dbData == null ? null : new CarColor(CarColor.Colors.valueOf(dbData));
    }
    
}
