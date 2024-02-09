// Models
package com.boardcamp.api.models;

import com.boardcamp.api.dtos.GameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class GameModel {

  public GameModel(GameDTO gameDTO) {
    this.name = gameDTO.getName();
    this.image = gameDTO.getImage();
    this.stockTotal = gameDTO.getStockTotal();
    this.pricePerDay = gameDTO.getPricePerDay();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  private String image;

  @Column(nullable = false)
  private int stockTotal;

  @Column(nullable = false)
  private int pricePerDay;
}
