package cool.datasnok.samples.springjooq.jooq.repository.impl;

import org.jooq.DSLContext;

import cool.datasnok.samples.springjooq.contracts.BookProjection;
import cool.datasnok.samples.springjooq.data.repository.BookRepository;

import static cool.datasnok.samples.jooq.Tables.BOOK;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
  private final DSLContext create;

  @Override
  public BookProjection findById(Integer id) {
    return create.select(BOOK.TITLE)
      .from(BOOK)
      .where(BOOK.ID.eq(id))
      .fetchOneInto(BookProjection.class);
  }

}
