package cool.datasnok.samples.springjooq.data.repository;

import cool.datasnok.samples.springjooq.contracts.BookProjection;

public interface BookRepository {

  BookProjection findById(Integer id);
  
}
