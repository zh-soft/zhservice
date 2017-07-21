import com.zh.api.Factory;
import com.zh.pojo.ProductInfos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;


/**
 * Created by Lait on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springs/spring-mybatis.xml","classpath:springs/spring-application.xml"})
public class ProductTest {


    @Autowired
    private Factory.ProductService productService ;

    @Test
    public void testCreate() throws Exception {
        ProductInfos productInfos = new ProductInfos();

        productInfos.setCount(100);
        productInfos.setAreaCode("0589");
        productInfos.setPtime(new Date(new java.util.Date().getTime()));
        productInfos.setGtime(new Date(2020, 12, 20));
        productInfos.setBrand("yuetu");
        productInfos.setModel("KFR-35GW/DY");
        productInfos.setBn(1);

        productService.produceProduct(productInfos);

    }








}
