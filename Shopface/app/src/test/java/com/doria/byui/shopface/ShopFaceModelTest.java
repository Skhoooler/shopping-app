package com.doria.byui.shopface;

import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopFaceModelTest {

    @Test
    public void dataInMapTest() throws NoSuchFieldException {
        String hi = "hi";
        ShopFaceModel shopFaceModel = new ShopFaceModel(hi);
        Field data = ShopFaceModel.class.getDeclaredField("data");
        data.setAccessible(true);

        assertNotNull("Data map is null",data);
       // assertTrue()
    }

}
