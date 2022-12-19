package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodid;
    private String orderid;
    private List<String> options;
    private String storeId;

    public OrderAccepted(Foodcook aggregate){
        super(aggregate);
    }
    public OrderAccepted(){
        super();
    }
}
