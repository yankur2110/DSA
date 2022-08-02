class Solution {
    HashMap<String, Boolean> map = new HashMap<>(); //map stores if recipe can be made.
    HashMap<String, Integer> recipeIndex = new HashMap<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> resultList = new ArrayList<>();

        //put the supply in map (indirectly these are recipes and can be made).
        for(String supply : supplies){
            map.put(supply, true);
        }

        //put in recipeIndex map so that we can get the index of recipe in constant time. This would help us know better what all ingredients are required for a recipe.
        for(int i=0;i<recipes.length;i++){
            recipeIndex.put(recipes[i], i);
        }

        //check if recipe is possible.
        for(String recipe: recipes){
            checkIfCanBeMade(recipe, ingredients, new HashSet<String>());
            if(map.get(recipe))
                resultList.add(recipe);
        }

        //return the list.
        return resultList;

    }

    public void checkIfCanBeMade(String recipe, List<List<String>> ingredients, HashSet<String> visited){

        //if already computed.
        if(map.containsKey(recipe) && map.get(recipe)){
            return;
        }

        //check case where we have a ingredients which is nor a recipe, neither a supply.
        if(!recipeIndex.containsKey(recipe)){
            map.put(recipe, false);
            return;
        }

        //if infinite loop.
        if(visited.contains(recipe)){
            map.put(recipe, false);
            return;
        }

        List<String> ingredientsRequired = ingredients.get(recipeIndex.get(recipe));

        //check if all ingredients can be made. While checking so, we add each of them in map in process.
        for(String ingredient : ingredientsRequired){
            visited.add(recipe);
            checkIfCanBeMade(ingredient, ingredients, visited);

            if(!map.get(ingredient)){ //if it's not possible to make the ingredient (and it's not a supply either).
                map.put(recipe, false);
                return;
            }

        }

        map.put(recipe,true); //if it's possible to make all ingredients, it is possible to make the recipe as well.


    }
}
