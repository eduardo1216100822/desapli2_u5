/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_packet")
public class Packet implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_packet")
    private Long idPacket;
    @Column(length=30)
    private String name;

    public Packet() {
        this.idPacket=0L;
    }

    public Long getIdPacket() {
        return idPacket;
    }

    public void setIdPacket(Long idPacket) {
        this.idPacket = idPacket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}