/*
 * Criação da interface RestauranteRepository, que estende a interface JpaRepository
 * Feita para realizar operações CRUD na entidade Restaurante
 * Métodos: updateRestaurante
 */

package com.meals.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meals.api.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Modifying
    @Query("UPDATE Restaurant r SET r.name = :name, r.address = :address, r.city = :city, r.state = :state, r.zipCode = :zipCode WHERE r.id = :id")
    int updateRestaurant(Long id, String name, String address, String city, String state, String zipCode);

}
