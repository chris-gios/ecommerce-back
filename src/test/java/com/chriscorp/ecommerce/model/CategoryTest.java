package com.chriscorp.ecommerce.model;

import com.chriscorp.ecommerce.EcommerceApplication;
import com.chriscorp.ecommerce.controller.CategoryController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EcommerceApplication.class)
@WebMvcTest(CategoryController.class)
public class CategoryTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryController categoryController;

    @Test
    public void testPostCategories() {

        try {
            Category category = new Category();
            category.setName("Tecnologia");
            category.setPhoto("adf44s-sd4f5sd-dsf4");

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson = ow.writeValueAsString(category);

            mvc.perform(post("/api/category")
                    .content(requestJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println("Error test: " + e);
        }
    }

    @Test
    public void testFindAllCategories() {
        try {
            mvc.perform(get("/api/category")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(0)));
        } catch (Exception e) {
            System.out.println("Error test: " + e);
        }
    }

}