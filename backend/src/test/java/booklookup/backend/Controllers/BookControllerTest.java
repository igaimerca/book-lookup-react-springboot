package booklookup.backend.Controllers;

import booklookup.backend.Models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import booklookup.backend.Services.BookService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @MockBean
    private BookService bookServiceMock;
    private MockMvc mockMvc;

    @Test
    public void get_all_success() throws Exception {
        List<Book> bookList = Arrays.asList(new Book(1L,33334,"https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg", "Aime Ig.","Learning SpringBoot.", LocalDate.parse("2004-04-05"),"Learning Springboot"));
        when(bookServiceMock.listOfBooks()).thenReturn(bookList);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/books/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "\"id\":1," +
                        "\"ISBN\":\"3334\"," +
                        "\"thumbnailUrl\":\"https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg\", " +
                        "\"author\": \"Aime Ig.\", " +
                        "\"title\": \"Learning SpringBoot\"," +
                        "\"published_date\": \"2004-04-05\"," +
                        "\"shortDescription\": \"Learning SpringBoot\"" +
                        " }]"))
                .andReturn();
    }
}
