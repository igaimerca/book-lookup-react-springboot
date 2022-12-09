import { useState } from "react";

interface SearchBarType {
  searchTerm: string;
  handleSearchTerm: Function;
}

const SearchBar: React.FC<SearchBarType> = ({
  searchTerm,
  handleSearchTerm,
}) => {
  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    handleSearchTerm(event.target.value);
  };

  return (
    <input
      type="text"
      placeholder="What do you want to read 🤔..."
      value={searchTerm}
      onChange={handleChange}
      className="bg-gray-200 rounded-lg p-2 mb-4 w-full outline-none"
    />
  );
};

export default SearchBar;
