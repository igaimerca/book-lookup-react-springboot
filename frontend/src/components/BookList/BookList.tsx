import { useState } from "react";

const BookList: React.FC = () => {
  const [books, setBooks] = useState([
    { title: "The Catcher in the Rye", author: "J.D. Salinger" },
    { title: "The Great Gatsby", author: "F. Scott Fitzgerald" },
    { title: "To Kill a Mockingbird", author: "Harper Lee" },
    { title: "Pride and Prejudice", author: "Jane Austen" },
  ]);

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
