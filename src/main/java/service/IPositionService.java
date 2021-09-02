package service;

import entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPositionService{
    public List<Position> getAllPossition();
}
