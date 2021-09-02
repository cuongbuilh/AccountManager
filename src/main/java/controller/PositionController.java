package controller;

import dto.PositionDto;
import entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IPositionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/possitions")
@CrossOrigin("*")
public class PositionController {

    @Autowired
    private IPositionService possitionService;

    @GetMapping()
    public ResponseEntity<?> getAllPossitons() {
        List<Position> entities = possitionService.getAllPossition();

        List<PositionDto> dtos = new ArrayList<>();

        for (Position entity : entities) {
            PositionDto dto = new PositionDto(entity.getId(), entity.getName().toString());
            dtos.add(dto);
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
