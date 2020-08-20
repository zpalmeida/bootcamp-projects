package org.academiadecodigo.bootcamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "entity_class")
public class EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;

    @Version
    private Integer version;

    @CreationTimestamp
    private Date creationTime;

    @UpdateTimestamp
    private Date updateTime;

    private String name;

    public Integer getiD() {
        return iD;
    }

    public Integer getVersion() {
        return version;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getName() {
        return name;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setName(String name) {
        this.name = name;
    }
}
