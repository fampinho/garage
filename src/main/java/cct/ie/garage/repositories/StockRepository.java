package cct.ie.garage.repositories;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {

}
