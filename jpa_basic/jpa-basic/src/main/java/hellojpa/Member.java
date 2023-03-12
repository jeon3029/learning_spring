package hellojpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
  private String username;

  @Embedded
  private Address homeAddress;

  @ElementCollection
  @CollectionTable(name="FAVORITE_FOOD",joinColumns =
    @JoinColumn(name="MEMBER_ID"))
  @Column(name="FOOD_NAME")
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name="ADDRESS",joinColumns = 
    @JoinColumn(name="MEMBER_ID"))
  private List<Address> addressHistory = new ArrayList<>();
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }

  public Set<String> getFavoriteFoods() {
    return favoriteFoods;
  }

  public void setFavoriteFoods(Set<String> favoriteFoods) {
    this.favoriteFoods = favoriteFoods;
  }

  public List<Address> getAddressHistory() {
    return addressHistory;
  }

  public void setAddressHistory(List<Address> addressHistory) {
    this.addressHistory = addressHistory;
  }

  
}

