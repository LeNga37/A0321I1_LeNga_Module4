package codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    private String name;

    public Province() {
    }

    @OneToMany(mappedBy = "province")
    private List<Customer> customerList;

    public Province(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

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

}
