package edu.javavt16.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "brand")
@NamedQuery(name = "CarBrand.findAll", query = "select c from CarBrand c")

public class CarBrand implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idGame;
    @NotEmpty @Column(unique=true, nullable=false)
    private String name;

    @Column private short fond_year;

    @Column private String jenre;

    @Column private String developer;

    @Column private String platforms;

    public CarBrand() {}

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFond_year(short fond_year) {
        this.fond_year = fond_year;
    }

    public void setJenre(String jenre) {
        this.jenre = jenre;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }


    public int getIdGame() {
        return idGame;
    }

    public String getName() {
        return name;
    }

    public short getFond_year() {
        return fond_year;
    }

    public String getJenre() {
        return jenre;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPlatforms() {
        return platforms;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "idGame=" + idGame +
                ", name='" + name + '\'' +
                ", fond_year=" + fond_year +
                ", jenre='" + jenre + '\'' +
                ", developer=" + developer +
                ", platforms='" + platforms + '\'' +
                '}';
    }
}