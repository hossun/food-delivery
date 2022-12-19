package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrceCanceled extends AbstractEvent {

    private Long id;

    public OrceCanceled(Order aggregate){
        super(aggregate);
    }
    public OrceCanceled(){
        super();
    }
}
