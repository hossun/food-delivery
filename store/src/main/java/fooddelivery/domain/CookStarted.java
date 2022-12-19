package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodid;
    private String orderid;
    private List<String> options;
    private String storeId;

    public CookStarted(Foodcook aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
