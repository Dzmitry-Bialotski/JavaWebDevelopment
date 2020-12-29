package by.belotskiy.shapes.model.warehouse;

import by.belotskiy.shapes.exception.WarehouseException;
import by.belotskiy.shapes.model.entitiy.EllipseProperty;

import java.util.HashMap;
import java.util.Map;

public class EllipsePropertyWarehouse {

    public final static EllipsePropertyWarehouse WAREHOUSE = new EllipsePropertyWarehouse();
    private Map<Long, EllipseProperty> ellipsePropertyMap;

    public EllipsePropertyWarehouse() {
        ellipsePropertyMap = new HashMap<>();
    }

    public void add(long ellipseId, EllipseProperty property) throws WarehouseException{
        if(!ellipsePropertyMap.containsKey(ellipseId)) {
            ellipsePropertyMap.put(ellipseId, property);
        }else{
            throw new WarehouseException();
        }
    }

    public EllipseProperty get(long ellipseId){
        return  ellipsePropertyMap.get(ellipseId);
    }

    public void update(long ellipseId, EllipseProperty property) throws WarehouseException{
        if(ellipsePropertyMap.containsKey(ellipseId)) {
            ellipsePropertyMap.put(ellipseId, property);
        }else{
            throw new WarehouseException();
        }
    }

    public void remove(long ellipseId) throws WarehouseException {
        if(!ellipsePropertyMap.containsKey(ellipseId)){
            throw new WarehouseException();
        }
        ellipsePropertyMap.remove(ellipseId);
    }
}
