package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Position;

public interface IPositionRepository extends JpaRepository<Position, Short>{

}
