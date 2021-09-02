package service;

import entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IPositionRepository;

import java.util.List;

@Service
public class PositionService implements IPositionService {

   @Autowired
    private IPositionRepository possitionRepository;

    @Override
    public List<Position> getAllPossition() {
        // TODO Auto-generated method stub
        return possitionRepository.findAll();
    }

}
