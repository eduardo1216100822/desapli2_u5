package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.PacketDAO;
import utng.model.Packet;

@ManagedBean
@SessionScoped
public class PacketBean implements Serializable{
    private List<Packet> packets;
    private Packet packet;
    public PacketBean(){}

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
    
    
    public String list(){
        PacketDAO dao = new PacketDAO();
        try {
            packets=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Packets";
    }
    
    public String delete(){
         PacketDAO dao = new PacketDAO();
        try {
            dao.delete(packet);
            packets=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        packet = new Packet();
        return "Start";
    }
    
    public String save(){
        PacketDAO dao = new PacketDAO();
        try {
            if(packet.getIdPacket()!= 0){
                dao.update(packet);
            }else {
                dao.insert(packet);
            }
            packets=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Packet packet){
        this.packet=packet;
        return "Edit";
    }
    
}
