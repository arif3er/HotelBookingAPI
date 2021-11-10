package com.kodluyoruz.hotelreservationap.service;

import com.kodluyoruz.hotelreservationap.exception.NotFoundException;
import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.entity.Visitor;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import com.kodluyoruz.hotelreservationap.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.hotelreservationap.model.mapper.VisitorMapper.VISITOR_MAPPER;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository repository;

    public VisitorDto createVisitorDto(CreateVisitorRequest request) {
        Visitor visitor=VISITOR_MAPPER.createVisitor(request);
        return VISITOR_MAPPER.toVisitorDto(repository.save(visitor));

    }

    public VisitorDto getVisitorDto(int id){
        Visitor visitor = getVisitorEntity(id);
        return VISITOR_MAPPER.toVisitorDto(visitor);
    }

    private Visitor getVisitorEntity(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Visitor not found!"));
    }

    public VisitorDto updateVisitor(int id,CreateVisitorRequest request){
        Visitor visitor=getVisitorEntity(id);
        VISITOR_MAPPER.updateVisitor(visitor,request);

        Visitor updatedVisitor=repository.save(visitor);
        return VISITOR_MAPPER.toVisitorDto(updatedVisitor);
    }

    public List<VisitorDto> getVisitors(){
        return VISITOR_MAPPER.toVisitorDtoList(repository.findAll());
    }

    public void deleteVisitor(int id){
        repository.deleteById(id);
    }
}


