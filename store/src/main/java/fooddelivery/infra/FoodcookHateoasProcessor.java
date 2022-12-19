package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class FoodcookHateoasProcessor implements RepresentationModelProcessor<EntityModel<Foodcook>>  {

    @Override
    public EntityModel<Foodcook> process(EntityModel<Foodcook> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/accept").withRel("accept"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/start").withRel("start"));

        
        return model;
    }
    
}
