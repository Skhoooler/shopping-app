package com.doria.byui.shopface;

import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void searchQueryTest() throws NoSuchFieldException {
        String hi = "hi";
        Search tester = new Search(hi);
        Field query = Search.class.getDeclaredField("query");
        query.setAccessible(true);

        assertNotNull("Query String is null", query);
    }

    @Test
    public void searchStoreSearchTest() throws NoSuchFieldException {
        Field file = Search.class.getDeclaredField("file");
        file.setAccessible(true);
        assertNotNull("File object is null", file);
    }

}
