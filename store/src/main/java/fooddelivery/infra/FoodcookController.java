package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/foodcooks")
@Transactional
public class FoodcookController {
    @Autowired
    FoodcookRepository foodcookRepository;



    @RequestMapping(value = "foodcooks/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Foodcook accept(@PathVariable(value = "id") Long id, @RequestBody AcceptCommand acceptCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /foodcook/accept  called #####");
            Optional<Foodcook> optionalFoodcook = foodcookRepository.findById(id);
            
            optionalFoodcook.orElseThrow(()-> new Exception("No Entity Found"));
            Foodcook foodcook = optionalFoodcook.get();
            foodcook.accept(acceptCommand);
            
            foodcookRepository.save(foodcook);
            return foodcook;
            
    }
    



    @RequestMapping(value = "foodcooks/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Foodcook start(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /foodcook/start  called #####");
            Optional<Foodcook> optionalFoodcook = foodcookRepository.findById(id);
            
            optionalFoodcook.orElseThrow(()-> new Exception("No Entity Found"));
            Foodcook foodcook = optionalFoodcook.get();
            foodcook.start();
            
            foodcookRepository.save(foodcook);
            return foodcook;
            
    }
    




}
