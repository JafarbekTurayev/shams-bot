package ai.ecma.apppdpfoodbot.service;

import ai.ecma.apppdpfoodbot.dto.ApiResponse;
import ai.ecma.apppdpfoodbot.dto.BookDTO;
import ai.ecma.apppdpfoodbot.entity.Attachment;
import ai.ecma.apppdpfoodbot.entity.Book;
import ai.ecma.apppdpfoodbot.entity.Category;
import ai.ecma.apppdpfoodbot.repository.AttachmentContentRepository;
import ai.ecma.apppdpfoodbot.repository.AttachmentRepository;
import ai.ecma.apppdpfoodbot.repository.BookRepository;
import ai.ecma.apppdpfoodbot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(BookDTO dto) {

        Book book=new Book();
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(dto.getAttachmentId());
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());

        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        book.setDescription(dto.getDescription());
        book.setAttachment(optionalAttachment.get());
        book.setCategory(optionalCategory.get());
        bookRepository.save(book);
        return new ApiResponse("Saved!",true);
    }
}
