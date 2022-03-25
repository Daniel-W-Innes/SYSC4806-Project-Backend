package ca.group20.sysc4806project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Sysc4806ProjectApplicationTests {
    @Autowired
    private MockMvc mvc;
    private static final String ACCESS_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEZXNoYSIsInJvbGVzIjpbIlJPTEVfU1VSVkVZT1IiXSwiaXNzIjoiU1lTQzQ4MDZfRzIwIiwiZXhwIjoxNjUzMzYwMTExfQ.D_NQnTNton9zCEKWKZV-RzseA-ZRllAyMBvqvq6P4fk";

    @Test
    void health() throws Exception {
        mvc.perform(get("/").header("Authorization", ACCESS_TOKEN)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }
}
