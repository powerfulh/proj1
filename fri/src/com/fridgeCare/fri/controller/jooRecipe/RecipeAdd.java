package com.fridgeCare.fri.controller.jooRecipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;

public class RecipeAdd implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "joo/recipeAdd";
		return view;
	}

}
