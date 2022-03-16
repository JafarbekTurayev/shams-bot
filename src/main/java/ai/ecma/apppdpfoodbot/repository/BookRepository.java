package ai.ecma.apppdpfoodbot.repository;

import ai.ecma.apppdpfoodbot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory_Name(String name);

    Optional<Book> findByName(String name);
}