package ai.ecma.apppdpfoodbot.controller;

import ai.ecma.apppdpfoodbot.dto.ApiResponse;
import ai.ecma.apppdpfoodbot.dto.BookDTO;
import ai.ecma.apppdpfoodbot.entity.Attachment;
import ai.ecma.apppdpfoodbot.entity.Book;
import ai.ecma.apppdpfoodbot.entity.Category;
import ai.ecma.apppdpfoodbot.repository.AttachmentContentRepository;
import ai.ecma.apppdpfoodbot.repository.AttachmentRepository;
import ai.ecma.apppdpfoodbot.repository.BookRepository;
import ai.ecma.apppdpfoodbot.repository.CategoryRepository;
import ai.ecma.apppdpfoodbot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping
    public HttpEntity<?> save(@Valid @RequestBody BookDTO dto){

        ApiResponse response = bookService.save(dto);

        return ResponseEntity.status(201).body(response);
    }

}
