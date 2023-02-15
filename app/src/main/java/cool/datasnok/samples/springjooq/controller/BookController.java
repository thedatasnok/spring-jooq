package cool.datasnok.samples.springjooq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cool.datasnok.samples.springjooq.contracts.BookProjection;
import cool.datasnok.samples.springjooq.data.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
  private final BookRepository bookRepository;

  @GetMapping("/{id}")
  public ResponseEntity<BookProjection> getBook(@PathVariable int id) {
    var foundBook = this.bookRepository.findById(id);

    if (foundBook == null) return ResponseEntity.notFound().build();

    return ResponseEntity.ok(foundBook);
  }

}
