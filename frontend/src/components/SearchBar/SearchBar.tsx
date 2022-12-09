import { useState } from "react";

const SearchBar: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState("");

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(event.target.value);
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
