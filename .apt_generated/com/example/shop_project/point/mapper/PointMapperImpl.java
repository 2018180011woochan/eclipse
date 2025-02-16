package com.example.shop_project.point.mapper;

import com.example.shop_project.order.repository.OrderRepository;
import com.example.shop_project.point.dto.PointDto;
import com.example.shop_project.point.dto.SavedPointRequestDto;
import com.example.shop_project.point.dto.SavedPointResponseDto;
import com.example.shop_project.point.dto.UsedPointRequestDto;
import com.example.shop_project.point.dto.UsedPointResponseDto;
import com.example.shop_project.point.entity.Point;
import com.example.shop_project.point.entity.SavedPoint;
import com.example.shop_project.point.entity.UsedPoint;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-16T19:22:21+0900",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PointMapperImpl implements PointMapper {

    @Override
    public PointDto toDto(Point point) {
        if ( point == null ) {
            return null;
        }

        PointDto.PointDtoBuilder pointDto = PointDto.builder();

        pointDto.balance( point.getBalance() );

        return pointDto.build();
    }

    @Override
    public SavedPoint toEntity(SavedPointRequestDto savedPointRequestDto) {
        if ( savedPointRequestDto == null ) {
            return null;
        }

        SavedPoint.SavedPointBuilder savedPoint = SavedPoint.builder();

        savedPoint.saveReason( savedPointRequestDto.getSaveReason() );
        savedPoint.savedPoint( savedPointRequestDto.getSavedPoint() );

        return savedPoint.build();
    }

    @Override
    public SavedPointResponseDto toResponseDto(SavedPoint savedPoint) {
        if ( savedPoint == null ) {
            return null;
        }

        SavedPointResponseDto.SavedPointResponseDtoBuilder savedPointResponseDto = SavedPointResponseDto.builder();

        savedPointResponseDto.createdDate( savedPoint.getCreatedDate() );
        savedPointResponseDto.saveReason( savedPoint.getSaveReason() );
        savedPointResponseDto.savedPoint( savedPoint.getSavedPoint() );

        return savedPointResponseDto.build();
    }

    @Override
    public UsedPoint toEntity(UsedPointRequestDto usedPointRequestDto, OrderRepository orderRepository) {
        if ( usedPointRequestDto == null ) {
            return null;
        }

        UsedPoint.UsedPointBuilder usedPoint = UsedPoint.builder();

        usedPoint.order( orderMapper( usedPointRequestDto.getOrderNo(), orderRepository ) );
        usedPoint.amount( usedPointRequestDto.getAmount() );

        return usedPoint.build();
    }

    @Override
    public UsedPointResponseDto toResponseDto(UsedPoint usedPoint) {
        if ( usedPoint == null ) {
            return null;
        }

        UsedPointResponseDto.UsedPointResponseDtoBuilder usedPointResponseDto = UsedPointResponseDto.builder();

        usedPointResponseDto.amount( usedPoint.getAmount() );
        usedPointResponseDto.createdDate( usedPoint.getCreatedDate() );

        return usedPointResponseDto.build();
    }
}
