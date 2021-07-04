package pingpong.examen;

import java.util.List;
import java.util.ArrayList;
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

    //caso test 9 y 10
    public List<Orden> cargaOrden(String nombre_usuaria){
        Optional<Orden> pedido = Orden.find("ord_user", nombre_usuaria).firstResultOptional();
        List<Orden> pedidos = new ArrayList<Orden>();
        if (pedido.isPresent()){
            pedidos.add(pedido.get());
            return pedidos;
        }
        else{
            return pedidos;
        }
    }
}
