import React, { useEffect, useState } from "react";
import SearchBar from "../components/SearchBar/SearchBar";
import BookList from "../components/BookList/BookList";

const Home: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [loading, setLoading] = useState(false);
  const [books, setBooks] = useState<Array<any>>([]);

  useEffect(() => {
    setLoading(true);
    async function fetchData() {
      let url: string = searchTerm
        ? `http://localhost:8080/api/v1/books/search/${searchTerm}`
        : "http://localhost:8080/api/v1/books/";
      const response = await fetch(url);
      const data = await response.json();
      setBooks(data);
      setLoading(false);
    }
    fetchData();
  }, [searchTerm]);

  /* let books = [
    { title: "The Catcher in the Rye", author: "J.D. Salinger" },
    { title: "The Great Gatsby", author: "F. Scott Fitzgerald" },
    { title: "To Kill a Mockingbird", author: "Harper Lee" },
    { title: "Pride and Prejudice", author: "Jane Austen" },
  ]
  */

  return (
    <div className="w-[30vw]">
      <SearchBar
        searchTerm={searchTerm}
        handleSearchTerm={(newSearchTerm: string) =>
          setSearchTerm(newSearchTerm)
        }
      />
      {loading ? <p>Loading...</p> : <BookList books={books} />}
    </div>
  );
};

export default Home;
