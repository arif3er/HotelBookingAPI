package com.kodluyoruz.hotelreservationap.model.mapper;

import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitorMapper {
    VisitorMapper VISITOR_MAPPER = Mappers.getMapper(VisitorMapper.class);

    VisitorDto toVisitorDto(Visitor visitor);

    List<VisitorDto> toVisitorDtoList(List<Visitor> visitors);

    Visitor createVisitor(CreateVisitorRequest request);

    void updateVisitor(@MappingTarget Visitor visitor, CreateVisitorRequest request);
}
