package com.projectphase.zero.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Civilization {

 @Id
  private int id;

  private String name;
  private String expansion;
  private String army_type;
  private String[] unique_unit;
//  private String[] unique_tech;
 // private String team_bonus;
  //private String[] civilization_bonus;

  public Civilization(int id, String name, String expansion, String army_type,
      String[] unique_unit) {
    this.id = id;
    this.name = name;
    this.expansion = expansion;
    this.army_type = army_type;
    this.unique_unit = unique_unit;
  }
  public Civilization(){}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExpansion() {
    return expansion;
  }

  public void setExpansion(String expansion) {
    this.expansion = expansion;
  }

  public String getArmy_type() {
    return army_type;
  }

  public void setArmy_type(String army_type) {
    this.army_type = army_type;
  }

  public String[] getUnique_unit() {
    return unique_unit;
  }

  public void setUnique_unit(String[] unique_unit) {
    this.unique_unit = unique_unit;
  }

}
