package io.todak.study.laboratory.requsetbodybinding.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TestControllerTest {

    @Autowired
    WebApplicationContext ctx;

    MockMvc mvc;
    ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach() {
        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @DisplayName("기본 생성자가 없어도, 데이터가 잘 바인딩 된다.")
    void test() throws Exception {
        var data = new HashMap<String, String>();
        data.put("id", "1");
        data.put("name", "todak");
        data.put("address", "seoul");

        ResultActions perform = mvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data))
        );
    }

    @Test
    @DisplayName("기본 생성자가 없는 클래스 타입에 역직렬화가 성공한다.")
    void test2() throws Exception {
        // given
        String id = "1";
        String name = "todak";
        String address = "seoul";

        var data = new HashMap<String, String>();
        data.put("id", id);
        data.put("name", name);
        data.put("address", address);

        // when
        String serializedValue = this.objectMapper.writeValueAsString(data);
        TestController.WithCustomConstructor deserializeTarget = this.objectMapper.readValue(serializedValue, TestController.WithCustomConstructor.class);

        // then
        assertNotNull(deserializeTarget.getId());
        assertNotNull(deserializeTarget.getName());
        assertNotNull(deserializeTarget.getAddress());

        assertEquals(Long.valueOf(id), deserializeTarget.getId());
        assertEquals(name, deserializeTarget.getName());
        assertEquals(address, deserializeTarget.getAddress());
    }

}