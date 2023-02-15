CREATE TABLE library.book (
  book_id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
  title TEXT,
  author TEXT,
  pages INT, 

  PRIMARY KEY (book_id)
);
