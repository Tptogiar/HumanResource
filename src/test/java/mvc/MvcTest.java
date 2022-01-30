package mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/30 - 14:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
public class MvcTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;


    @Before
    public void initMockMvc(){
        mockMvc= MockMvcBuilders.standaloneSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.
                get("/emps").param("page", "1").param("per_page", "2"))
                .andReturn();

        ModelAndView modelAndView = result.getModelAndView();


        MockHttpServletRequest req = result.getRequest();
        MockHttpServletResponse resp = result.getResponse();
        Object emps = req.getAttribute("emps");
        System.out.println(emps);




    }

}
