package pingpong.examen;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import pingpong.examen.Entidades.*;

@ApplicationScoped
public class ServiceOlli {
    
    //caso test 5
    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = Usuaria.find("user_nom", nombre).firstResultOptional();
        return user.isPresent() ? user.get() : new Usuaria("", 0);
    }
}
