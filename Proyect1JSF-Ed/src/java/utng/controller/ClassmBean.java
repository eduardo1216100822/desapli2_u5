package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.ClassmDAO;
import utng.data.PacketDAO;
import utng.model.Classm;
import utng.model.Packet;

@ManagedBean(name="classmBean") 
@SessionScoped
public class ClassmBean implements Serializable{
    private List<Classm> classms;
    private Classm classm;
    private List<Packet> packets;
    
    public ClassmBean(){
        classm = new Classm();
        classm.setPacket(new Packet());
    }

    public List<Classm> getClassms() {
        return classms;
    }

    public void setClassms(List<Classm> classms) {
        this.classms = classms;
    }

    public Classm getClassm() {
        return classm;
    }

    public void setClassm(Classm classm) {
        this.classm = classm;
    }
    
    public List<Packet> getPackets() {
        return packets;
    }
    public void setPacket(List<Packet> packets) {
        this.packets = packets;
    }
    
    
    public String list(){
       ClassmDAO dao = new ClassmDAO();
        try {
            classms = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Classms";
    }
    
    public String delete(){
         ClassmDAO dao = new ClassmDAO();
        try {
            dao.delete(classm);
            classms = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        classm = new Classm();
        classm.setPacket(new Packet());
        try {
            packets = new PacketDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        ClassmDAO dao = new ClassmDAO();
        try {
            if(classm.getIdClass()!= 0){
                dao.update(classm);
            }else {
                dao.insert(classm);
            }
            classms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Classm classm){
        this.classm = classm;
        try {
            packets = new PacketDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
 
}
