package wei.springFramework.bootstrap;

import net.bytebuddy.description.field.FieldDescription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wei.springFramework.models.*;
import wei.springFramework.repositories.CategoryRepository;
import wei.springFramework.repositories.RecipeRepository;
import wei.springFramework.repositories.UnitOfMeasureRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap...");

        Recipe spicyGrilledChickenTacos = new Recipe();
        spicyGrilledChickenTacos.setDescription("Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);
        recipeRepository.save(spicyGrilledChickenTacos);

        Recipe bestGuacamole = new Recipe();
        bestGuacamole.setDescription("Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade");
        bestGuacamole.setDifficulty(Difficulty.EASY);
        recipeRepository.save(bestGuacamole);

        System.out.println("Recipe count: " + recipeRepository.count());

        Category meat = new Category();
        meat.setDescription("meat");
        Set<Recipe> meatRecipes = new HashSet<>();
        meat.setRecipes(meatRecipes);
        meat.getRecipes().add(spicyGrilledChickenTacos);
        categoryRepository.save(meat);

        Category taco = new Category();
        taco.setDescription("taco");
        Set<Recipe> tacoRecipes = new HashSet<>();
        taco.setRecipes(tacoRecipes);
        taco.getRecipes().add(spicyGrilledChickenTacos);
        categoryRepository.save(taco);

        Category vegan = new Category();
        vegan.setDescription("vegan");
        Set<Recipe> veganRecipes = new HashSet<>();
        vegan.setRecipes(veganRecipes);
        vegan.getRecipes().add(bestGuacamole);
        categoryRepository.save(vegan);

        System.out.println("category count: " + categoryRepository.count());

        UnitOfMeasure teaSpoon = new UnitOfMeasure();
        teaSpoon.setUom("teaspoon");
        unitOfMeasureRepository.save(teaSpoon);

        UnitOfMeasure tableSpoon = new UnitOfMeasure();
        tableSpoon.setUom("tablespoon");
        unitOfMeasureRepository.save(tableSpoon);

        UnitOfMeasure noMeasure = new UnitOfMeasure();
        noMeasure.setUom("");
        unitOfMeasureRepository.save(noMeasure);

        UnitOfMeasure cup = new UnitOfMeasure();
        cup.setUom("");
        unitOfMeasureRepository.save(cup);

        UnitOfMeasure pinch = new UnitOfMeasure();
        pinch.setUom("pinch");
        unitOfMeasureRepository.save(pinch);

        System.out.println("UOM count: " + unitOfMeasureRepository.count());

        Ingredient anchoChiliPowder = new Ingredient();
        anchoChiliPowder.setUnitOfMeasure(tableSpoon);
        anchoChiliPowder.setDescription("ancho chili powder");
        anchoChiliPowder.setAmount(BigDecimal.valueOf(2.0));
        anchoChiliPowder.setRecipe(spicyGrilledChickenTacos);
        Set<Ingredient> spicyGrilledChickenTacosIngredents = new HashSet<>();
        spicyGrilledChickenTacos.setIngredients(spicyGrilledChickenTacosIngredents);
        spicyGrilledChickenTacos.getIngredients().add(anchoChiliPowder);

        Ingredient driedOregano = new Ingredient();
        driedOregano.setUnitOfMeasure(teaSpoon);
        driedOregano.setDescription("dried oregano");
        driedOregano.setAmount(BigDecimal.valueOf(1.0));
        driedOregano.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(driedOregano);

        Ingredient driedCumin = new Ingredient();
        driedCumin.setUnitOfMeasure(teaSpoon);
        driedCumin.setDescription("dried cumin");
        driedCumin.setAmount(BigDecimal.valueOf(1.0));
        driedCumin.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(driedCumin);

        Ingredient sugar = new Ingredient();
        sugar.setUnitOfMeasure(teaSpoon);
        sugar.setDescription("sugar");
        sugar.setAmount(BigDecimal.valueOf(1.0));
        sugar.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(sugar);

        Ingredient salt = new Ingredient();
        salt.setUnitOfMeasure(teaSpoon);
        salt.setDescription("salt");
        salt.setAmount(BigDecimal.valueOf(0.5));
        salt.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(salt);

        Ingredient cloveGarlic = new Ingredient();
        cloveGarlic.setUnitOfMeasure(noMeasure);
        cloveGarlic.setDescription("clove garlic");
        cloveGarlic.setAmount(BigDecimal.valueOf(1.0));
        cloveGarlic.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(cloveGarlic);

        Ingredient orangeZest = new Ingredient();
        orangeZest.setUnitOfMeasure(tableSpoon);
        orangeZest.setDescription("finely grated orange zest");
        orangeZest.setAmount(BigDecimal.valueOf(3.0));
        orangeZest.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.getIngredients().add(orangeZest);

        recipeRepository.save(spicyGrilledChickenTacos);

        Ingredient avocado = new Ingredient();
        avocado.setUnitOfMeasure(noMeasure);
        avocado.setDescription("ripe avocado");
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setRecipe(bestGuacamole);
        Set<Ingredient> bestGuacamoleIngredients = new HashSet<>();
        bestGuacamole.setIngredients(bestGuacamoleIngredients);
        bestGuacamole.getIngredients().add(avocado);

        Ingredient lime = new Ingredient();
        lime.setUnitOfMeasure(teaSpoon);
        lime.setDescription("fresh lime");
        lime.setAmount(BigDecimal.valueOf(1));
        lime.setRecipe(bestGuacamole);
        bestGuacamole.getIngredients().add(lime);

        Ingredient redOnion = new Ingredient();
        redOnion.setUnitOfMeasure(noMeasure);
        redOnion.setDescription("red onion");
        redOnion.setAmount(BigDecimal.valueOf(2));
        redOnion.setRecipe(bestGuacamole);
        bestGuacamole.getIngredients().add(redOnion);

        Ingredient cilantro = new Ingredient();
        cilantro.setUnitOfMeasure(noMeasure);
        cilantro.setDescription("cilantro(leaves and tender stems, finely chopped)");
        cilantro.setAmount(BigDecimal.valueOf(2));
        cilantro.setRecipe(bestGuacamole);
        bestGuacamole.getIngredients().add(cilantro);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setUnitOfMeasure(pinch);
        blackPepper.setDescription("ground black pepper");
        blackPepper.setAmount(BigDecimal.valueOf(1));
        blackPepper.setRecipe(bestGuacamole);
        bestGuacamole.getIngredients().add(blackPepper);

        Ingredient tomato = new Ingredient();
        tomato.setUnitOfMeasure(pinch);
        tomato.setDescription("ground black pepper");
        tomato.setAmount(BigDecimal.valueOf(0.5));
        tomato.setRecipe(bestGuacamole);
        bestGuacamole.getIngredients().add(tomato);

        bestGuacamole.getIngredients().add(salt);

        recipeRepository.save(bestGuacamole);

        System.out.println(spicyGrilledChickenTacos.toString());
        System.out.println(bestGuacamole.toString());
    }
}
