import NavBar from "../../components/NavBar";
import { useLocation } from "react-router-dom";
import { useState } from "react";

export default function AddOrUpdatePage() {
  const location = useLocation();
  const [name, setName] = useState("");
  const [value, setValue] = useState(0);
  const [category, setCategory] = useState("");
  const [description, setDescription] = useState("");

  const method = location.pathname.includes("add") ? "Add" : "Update";

  return (
    <>
      <NavBar />
      <div className="grid grid-cols-6 gap-4 mt-10">
        <div className="col-start-3 col-span-2 border border-slate-400 rounded-lg">
          <h2 className="text-2xl mb-4 mt-4 text-center">{method} Account</h2>

          <div className="flex flex-col items-center">
            <div className="w-96">
              <h3 className="text-md mb-1">Account Name</h3>
              <input
                type="text"
                placeholder={name}
                onChange={(e) => setName(e.target.value)}
                className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
              />

              <h3 className="text-md mb-1">Value</h3>
              <input
                type="number"
                placeholder={value}
                onChange={(e) => setValue(e.target.value)}
                className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
              />

              <h3 className="text-md mb-1">Risk Category</h3>
              <select className="select select-bordered w-full mb-4 p-2 hover:border-indigo-500">
                <option>Safe</option>
                <option>Risky</option>
              </select>

              <h3 className="text-md mb-1">Description</h3>
              <input
                type="text"
                placeholder={description}
                onChange={(e) => setDescription(e.target.value)}
                className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
              />

              <button className="mt-2 mb-4 btn border-indigo-500 w-full">
                {method}
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
