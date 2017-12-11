package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_class")
public class Classm implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_class")
    private Long idClass;
    @Column(name="name_class", length=30)
    private String nameClass;
    @Column(length=40)
    private String type;
     @Column(length=40)
    private String code;
    @ManyToOne()
    @JoinColumn(name="id_packet")
    private Packet packet;

    public Classm() {
        this.idClass=0L;
    }

    public Classm(Long idClass, String nameClass, String type, String code, Packet packet) {
        super();
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.type = type;
        this.code = code;
        this.packet = packet;
    }

    public Long getIdClass() {
        return idClass;
    }

    public void setIdClass(Long idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
    
    

    

    

}
    