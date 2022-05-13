package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
}
