
  package in.main.entities;
  
  import jakarta.persistence.Column; 
  import jakarta.persistence.Entity; 
  import jakarta.persistence.GeneratedValue; 
  import jakarta.persistence.GenerationType; 
  import jakarta.persistence.Id; 
  import jakarta.persistence.JoinColumn; 
  import jakarta.persistence.ManyToOne; 
  import jakarta.persistence.Table;
  
  @Entity
  
  @Table(name = "Products") 
  public class Products {
  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private long id;
	  
	  @Column 
	  private String name;
	  
	  @Column 
	  private double price;
	  
	  @ManyToOne
	  @JoinColumn(name = "catId", nullable = false) 
	  private Categories categories;
	  
	  
	  public long getId() {
		  return id;
	  }
	  
	  public void setId(long id) {
		  this.id = id; 
	  }
	  
	  public String getName() { 
		  return name; 
	  }
	  
	  public void setName(String name) { 
		  this.name = name; 
	  }
	  
	  public double getPrice() { 
		  return price;
	  }
	  
	  public void setPrice(double price) {
		  this.price = price; 
	  }
	  
	  public Categories getCategories() { 
		  return categories;  
	  }
	  
	  public void setCategories(Categories categories) {
		  this.categories = categories; 
	  }
	  
	  
  
  }
 