package com.example.candidate_position_poc.Service;

import com.example.candidate_position_poc.DTOs.CreatePositionRequest;
import com.example.candidate_position_poc.Entity.Position;
import com.example.candidate_position_poc.Repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position createPosition(CreatePositionRequest request){
        if(positionRepository.existsByPositionName(request.getPositionName())){
            throw  new IllegalArgumentException("Position already exits");
        }

        Position position = new Position();
        position.setPositionName(request.getPositionName());

        return positionRepository.save(position);
    }

    public List<Position>  getAllPosition(){
        return positionRepository.findAll();
    }
}
