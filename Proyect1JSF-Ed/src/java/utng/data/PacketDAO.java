package utng.data;

import org.hibernate.HibernateException;
import utng.data.DAO;
import utng.model.Packet;

public class PacketDAO extends DAO<Packet> {
     public PacketDAO() {
        super(new Packet());
    }

    
    public Packet getOneById(Packet packet) throws HibernateException {
        return super.getOneById(packet.getIdPacket()); //To change body of generated methods, choose Tools | Templates.
    }
}