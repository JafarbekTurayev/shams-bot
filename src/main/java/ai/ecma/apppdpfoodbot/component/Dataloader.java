package ai.ecma.apppdpfoodbot.component;

import ai.ecma.apppdpfoodbot.entity.Book;
import ai.ecma.apppdpfoodbot.entity.Category;
import ai.ecma.apppdpfoodbot.repository.BookRepository;
import ai.ecma.apppdpfoodbot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    private String mode;

    final CategoryRepository categoryRepository;
    final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {
            Category category = categoryRepository.save(new Category(1, "Diniy", true, "yaxshi"));
            Category category1 = categoryRepository.save(new Category(2, "Jahon", true, "Yaxshi"));
            Category category2 = categoryRepository.save(new Category(3, "Badiiy", true, "Yaxshi"));

//            Book book = new Book(category, "yaxshi kitob", 30000);
//            book.setName("Din!");
//            bookRepository.save(book);
        }
    }
}
