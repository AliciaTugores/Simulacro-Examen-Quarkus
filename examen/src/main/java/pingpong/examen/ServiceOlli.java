package pingpong.examen;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;

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

    //caso test 11, 12, 13 y 14
    @Transactional
    public Orden comanda(String nombre_usuaria, String nombre_item){
        Optional<Usuaria> user = Usuaria.find("user_nom", nombre_usuaria).firstResultOptional();
        Optional<Item> item = Item.find("item_nom", nombre_item).firstResultOptional();

        if (user.isPresent() && item.isPresent() && user.get().getDestreza() >= item.get().getQuality()){
           Orden pedido = new Orden(user.get(), item.get());
           pedido.persist();
           return pedido;
        }
        else{
            return null;
        }
    }

    //caso test 15, 16 y 17
    @Transactional
    public List<Orden> comandaMultiple(String nombre_usuaria, List<String> items){
        List<Orden> pedidos = new ArrayList<Orden>();
        for (String item  : items) {
            Orden pedido = comanda(nombre_usuaria, item);
            if (pedido != null){
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
