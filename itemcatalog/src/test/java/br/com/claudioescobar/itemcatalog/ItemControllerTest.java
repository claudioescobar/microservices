package br.com.claudioescobar.itemcatalog;

import br.com.claudioescobar.itemcatalog.item.ItemCatalogRepository;
import br.com.claudioescobar.itemcatalog.item.ItemController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemCatalogRepository repository;

    @Test
    public void getAll() {
    }

    @Test
    public void save() {
    }
}