package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String status;
    private String foodid;
    private String orderid;
    private List<String> options;
    private String storeId;

    public OrderRejected(Foodcook aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}
