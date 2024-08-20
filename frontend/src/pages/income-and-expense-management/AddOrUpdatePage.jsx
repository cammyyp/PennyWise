import NavBar from "../../components/NavBar";
import { useLocation } from "react-router-dom";
import { useState } from "react";

export default function AddOrUpdatePage() {
  const location = useLocation();
  const [category, setCategory] = useState("");
  const [amount, setAmount] = useState(0);
  const [date, setDate] = useState(new Date().toISOString());

  const type = location.pathname.includes("income") ? "Income" : "Expense";
  const method = location.pathname.includes("add") ? "Add" : "Update";

  return (
    <>
      <NavBar />
      <div className="grid grid-cols-6 gap-4 mt-10">
        <div className="col-start-3 col-span-2 border border-slate-400 rounded-lg">
          <h2 className="text-2xl mb-4 mt-4 text-center">
            {method} {type}
          </h2>

          <div className="flex flex-col items-center">
            <div className="w-96">
              <h3 className="text-md mb-1">Category</h3>
              <input
                type="text"
                placeholder={category}
                className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
              />

              <h3 className="text-md mb-1">Amount</h3>
              <input
                type="number"
                placeholder={amount}
                className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
              />

              <h3 className="text-md mb-1">Date Due</h3>
              <input
                type="date"
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
