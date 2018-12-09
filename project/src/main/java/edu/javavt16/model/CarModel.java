package edu.javavt16.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="model")
@NamedQuery(name="CarModel.findAll", query="select m from CarModel m")

public class CarModel implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idModel;

    @Column(insertable = false, updatable = false)
    private int idGame;

    @ManyToOne
    @JoinColumn(name = "idGame")
    private CarBrand carBrand;

    @NotEmpty @Column
    private String os;
    @Column private String processor;
    @Column private short ram;
    @Column private short hdd;
    @Column private String video_card;

    public CarModel() {}

    public int getIdModel() {
        return idModel;
    }

    public int getIdGame() {
        return idGame;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public String getOs() {
        return os;
    }

    public String getProcessor() {
        return processor;
    }

    public short getRam() {
        return ram;
    }

    public short getHdd() {
        return hdd;
    }

    public String getVideo_card() {
        return video_card;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public void setOs (String os) {
        this.os = os;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(short ram) {
        this.ram = ram;
    }

    public void setHdd(short hdd) {
        this.hdd = hdd;
    }

    public void setVideo_card(String video_card) {
        this.video_card = video_card;
    }


    @Override
    public String toString() {
        return "CarModel{" +
                "idModel=" + idModel +
                ", carBrand=" + carBrand.getName() +
                ", idGame=" + idGame +
                ", os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", video_card=" + video_card +
                '}';
    }
}