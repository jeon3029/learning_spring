package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "USERNAME")
  private String name;

  private int age;

  // @ManyToOne
  // @JoinColumn(name = "TEAM_ID")
  // private Team team;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // public Team getTeam() {
  //   return team;
  // }

  // public void setTeam(Team team) {
  //   this.team = team;
  // }
  
}

