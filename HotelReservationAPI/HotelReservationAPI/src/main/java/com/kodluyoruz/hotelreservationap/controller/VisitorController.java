package com.kodluyoruz.hotelreservationap.controller;

import com.kodluyoruz.hotelreservationap.model.dto.VisitorDto;
import com.kodluyoruz.hotelreservationap.model.request.CreateVisitorRequest;
import com.kodluyoruz.hotelreservationap.service.VisitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("visitors")
@RequiredArgsConstructor
@Slf4j
public class VisitorController {
    private final VisitorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitorDto createVisitor(@Valid @RequestBody CreateVisitorRequest request){
        return service.createVisitorDto(request);
    }

    @PutMapping("{id}")
    public VisitorDto updateVisitor(@PathVariable int id,@RequestBody CreateVisitorRequest request){
        return  service.updateVisitor(id,request);
    }

    @GetMapping("{id}")
    public VisitorDto getVisitor(@PathVariable int id){
        return service.getVisitorDto(id);
    }

    @GetMapping
    public List<VisitorDto> getVisitors(){
        return service.getVisitors();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVisitor(@PathVariable int id){
        service.deleteVisitor(id);
    }
}
