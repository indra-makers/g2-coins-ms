package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
}
