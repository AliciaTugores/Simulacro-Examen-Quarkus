package pingpong.examen;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import pingpong.examen.Entidades.*;

@ApplicationScoped
public class ServiceOlli {
    
    //caso test 5 y 6
    public Usuaria cargaUsuaria(String nombre){
        Optional<Usuaria> user = Usuaria.find("user_nom", nombre).firstResultOptional();
        return user.isPresent() ? user.get() : new Usuaria("", 0);
    }

    //caso test 7 y 8
    public Item cargaItem(String nombre){
        Optional<Item> item = Item.find("item_nom", nombre).firstResultOptional();
        return item.isPresent() ? item.get() : new Item("", 0, "");
    }
}
