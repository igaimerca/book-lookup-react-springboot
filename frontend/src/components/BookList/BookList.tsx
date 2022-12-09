import { useEffect, useState } from "react";

interface BookListType {
  books: Array<any>;
}

const BookList: React.FC<BookListType> = ({ books }) => {
  return (
    <ul className="list-none">
      {books.map((book, index) => (
        <li key={index} className="p-2 border-b border-gray-300">
          <h3>{book.title}</h3>
          <p>By {book.author}</p>
        </li>
      ))}
    </ul>
  );
};

export default BookList;
