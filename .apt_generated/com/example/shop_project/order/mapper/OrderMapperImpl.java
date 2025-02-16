package com.example.shop_project.order.mapper;

import com.example.shop_project.order.dto.OrderDetailDto;
import com.example.shop_project.order.dto.OrderRequestDto;
import com.example.shop_project.order.dto.OrderResponseDto;
import com.example.shop_project.order.dto.PaymentDto;
import com.example.shop_project.order.entity.Order;
import com.example.shop_project.order.entity.OrderDetail;
import com.example.shop_project.order.entity.Payment;
import com.example.shop_project.product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-16T19:22:21+0900",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderRequestDto toRequestDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderRequestDto.OrderRequestDtoBuilder orderRequestDto = OrderRequestDto.builder();

        orderRequestDto.address( order.getAddress() );
        orderRequestDto.addressDetail( order.getAddressDetail() );
        orderRequestDto.addressee( order.getAddressee() );
        orderRequestDto.contact( order.getContact() );
        orderRequestDto.isPaidWithPoint( order.getIsPaidWithPoint() );
        orderRequestDto.member( order.getMember() );
        orderRequestDto.orderStatus( order.getOrderStatus() );
        orderRequestDto.postNo( order.getPostNo() );
        orderRequestDto.requirement( order.getRequirement() );
        orderRequestDto.totalPrice( order.getTotalPrice() );

        return orderRequestDto.build();
    }

    @Override
    public OrderResponseDto toResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDto.OrderResponseDtoBuilder orderResponseDto = OrderResponseDto.builder();

        orderResponseDto.address( order.getAddress() );
        orderResponseDto.addressDetail( order.getAddressDetail() );
        orderResponseDto.addressee( order.getAddressee() );
        orderResponseDto.contact( order.getContact() );
        orderResponseDto.createdDate( order.getCreatedDate() );
        orderResponseDto.isPaidWithPoint( order.getIsPaidWithPoint() );
        orderResponseDto.member( order.getMember() );
        List<OrderDetail> list = order.getOrderDetailList();
        if ( list != null ) {
            orderResponseDto.orderDetailList( new ArrayList<OrderDetail>( list ) );
        }
        orderResponseDto.orderNo( order.getOrderNo() );
        orderResponseDto.orderStatus( order.getOrderStatus() );
        orderResponseDto.postNo( order.getPostNo() );
        orderResponseDto.requirement( order.getRequirement() );
        orderResponseDto.totalPrice( order.getTotalPrice() );

        return orderResponseDto.build();
    }

    @Override
    public Order toEntity(OrderRequestDto orderRequestDto, ProductRepository productRepository) {
        if ( orderRequestDto == null ) {
            return null;
        }

        Order.OrderBuilder<?, ?> order = Order.builder();

        order.orderDetailList( orderDetailMapper( orderRequestDto.getOrderDetailDtoList(), productRepository ) );
        order.address( orderRequestDto.getAddress() );
        order.addressDetail( orderRequestDto.getAddressDetail() );
        order.addressee( orderRequestDto.getAddressee() );
        order.contact( orderRequestDto.getContact() );
        order.isPaidWithPoint( orderRequestDto.getIsPaidWithPoint() );
        order.member( orderRequestDto.getMember() );
        order.orderStatus( orderRequestDto.getOrderStatus() );
        order.postNo( orderRequestDto.getPostNo() );
        order.requirement( orderRequestDto.getRequirement() );
        order.totalPrice( orderRequestDto.getTotalPrice() );

        return order.build();
    }

    @Override
    public List<OrderResponseDto> toResponseDtoList(List<Order> orderList) {
        if ( orderList == null ) {
            return null;
        }

        List<OrderResponseDto> list = new ArrayList<OrderResponseDto>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( toResponseDto( order ) );
        }

        return list;
    }

    @Override
    public OrderDetailDto toDto(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }

        OrderDetailDto.OrderDetailDtoBuilder orderDetailDto = OrderDetailDto.builder();

        orderDetailDto.color( orderDetail.getColor() );
        orderDetailDto.price( orderDetail.getPrice() );
        orderDetailDto.quantity( orderDetail.getQuantity() );
        orderDetailDto.size( orderDetail.getSize() );

        return orderDetailDto.build();
    }

    @Override
    public OrderDetail toEntity(OrderDetailDto orderDetailDto, ProductRepository productRepository) {
        if ( orderDetailDto == null ) {
            return null;
        }

        OrderDetail.OrderDetailBuilder<?, ?> orderDetail = OrderDetail.builder();

        orderDetail.product( detailProductMapper( orderDetailDto.getProductId(), productRepository ) );
        orderDetail.color( orderDetailDto.getColor() );
        orderDetail.price( orderDetailDto.getPrice() );
        orderDetail.quantity( orderDetailDto.getQuantity() );
        orderDetail.size( orderDetailDto.getSize() );

        return orderDetail.build();
    }

    @Override
    public List<OrderDetail> toEntityList(List<OrderDetailDto> orderDetailDtoList) {
        if ( orderDetailDtoList == null ) {
            return null;
        }

        List<OrderDetail> list = new ArrayList<OrderDetail>( orderDetailDtoList.size() );
        for ( OrderDetailDto orderDetailDto : orderDetailDtoList ) {
            list.add( orderDetailDtoToOrderDetail( orderDetailDto ) );
        }

        return list;
    }

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto.PaymentDtoBuilder paymentDto = PaymentDto.builder();

        paymentDto.amount( payment.getAmount() );
        paymentDto.memberName( payment.getMemberName() );
        paymentDto.payMethod( payment.getPayMethod() );
        paymentDto.payStatus( payment.getPayStatus() );

        return paymentDto.build();
    }

    @Override
    public Payment toEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment.PaymentBuilder<?, ?> payment = Payment.builder();

        payment.amount( paymentDto.getAmount() );
        payment.memberName( paymentDto.getMemberName() );
        payment.payMethod( paymentDto.getPayMethod() );
        payment.payStatus( paymentDto.getPayStatus() );

        return payment.build();
    }

    protected OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto orderDetailDto) {
        if ( orderDetailDto == null ) {
            return null;
        }

        OrderDetail.OrderDetailBuilder<?, ?> orderDetail = OrderDetail.builder();

        orderDetail.color( orderDetailDto.getColor() );
        orderDetail.price( orderDetailDto.getPrice() );
        orderDetail.quantity( orderDetailDto.getQuantity() );
        orderDetail.size( orderDetailDto.getSize() );

        return orderDetail.build();
    }
}
