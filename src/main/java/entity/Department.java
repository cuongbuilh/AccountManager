package entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Data
@Entity
@Table(name = "Department", catalog = "TestingSystem")
public class Department implements Serializable {

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @Cascade(value = {CascadeType.REMOVE, CascadeType.SAVE_UPDATE})
    private List<Account> account;

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

}