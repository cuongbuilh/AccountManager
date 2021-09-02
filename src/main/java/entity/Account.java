package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "`Account`", catalog = "TestingSystem")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FullName", length = 50, nullable = false)
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    @Cascade(value = {CascadeType.REMOVE, CascadeType.SAVE_UPDATE})
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    private Position position;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Override
    public String toString() {
        return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullname=" + fullname
                + ", department=" + department + ", createDate=" + createDate + "]";
    }

}