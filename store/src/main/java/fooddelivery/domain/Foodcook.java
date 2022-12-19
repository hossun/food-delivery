package fooddelivery.domain;

import fooddelivery.domain.OrderAccepted;
import fooddelivery.domain.OrderRejected;
import fooddelivery.domain.CookStarted;
import fooddelivery.domain.CookFinished;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Foodcook_table")
@Data

public class Foodcook  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodid;
    
    
    
    
    
    private String orderid;
    
    
    
    @ElementCollection
    
    private List<String> options;
    
    
    
    
    
    private String storeId;

    @PostPersist
    public void onPostPersist(){


        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();



        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static FoodcookRepository repository(){
        FoodcookRepository foodcookRepository = StoreApplication.applicationContext.getBean(FoodcookRepository.class);
        return foodcookRepository;
    }



    public void accept(AcceptCommand acceptCommand){
    }
    public void start(){
    }

    public static void 주문정보복제(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Foodcook foodcook = new Foodcook();
        repository().save(foodcook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(foodcook->{
            
            foodcook // do something
            repository().save(foodcook);


         });
        */

        
    }


}
