package wei.springFramework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wei.springFramework.models.Category;
import wei.springFramework.models.UnitOfMeasure;
import wei.springFramework.repositories.CategoryRepository;
import wei.springFramework.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Teaspoon");
//
//        System.out.println("Cat Id is: " + categoryOptional.get().getId());
//        System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
