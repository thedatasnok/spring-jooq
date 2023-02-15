package cool.datasnok.samples.springjooq.jooq.repository.impl;

import static cool.datasnok.samples.springjooq.jooq.library.Tables.BOOK;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import cool.datasnok.samples.springjooq.contracts.BookProjection;
import cool.datasnok.samples.springjooq.data.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
  private final DSLContext create;

  @Override
  public BookProjection findById(Integer id) {
    return create.select(BOOK.TITLE)
      .from(BOOK)
      .where(BOOK.BOOK_ID.eq(id))
      .fetchOneInto(BookProjection.class);
  }

}
