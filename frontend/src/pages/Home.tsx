import React from "react";
import SearchBar from "../components/SearchBar/SearchBar";
import BookList from "../components/BookList/BookList";

const Home: React.FC = () => {
  return (
    <div className="w-24">
      <SearchBar />
      <BookList />
    </div>
  );
};

export default Home;
