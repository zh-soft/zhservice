import com.zh.dictionary.mapper.DistrictMapper;
import com.zh.pojo.DistrictInfos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Lait on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springs/spring-mybatis.xml"})
public class DictionaryTest {

    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void getDictInfos(){

        DistrictInfos dictionaryInfos = new DistrictInfos();
        dictionaryInfos.setId(3L);
        List<DistrictInfos> dictionaryInfosList = districtMapper.getDictInfos(dictionaryInfos);
        System.out.println("");
    }


    @Test
    public void selectChildrenById(){

        List<DistrictInfos> dictionaryInfosList = districtMapper.selectChildrenById(13L);
        System.out.println(dictionaryInfosList.size());

    }
}
