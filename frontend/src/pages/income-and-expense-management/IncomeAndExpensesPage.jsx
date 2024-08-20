import NavBar from "../../components/NavBar";
import { Link } from "react-router-dom";

export default function IncomeAndExpensesPage() {
  const incomes = [
    { category: "Salary", amount: 2450, date: "25-08-24" },
    { category: "Side Hustles", amount: 1200, date: "14-08-24" },
    { category: "Stocks", amount: 580, date: "29-08-24" },
  ];
  const expenses = [
    { category: "Phone", amount: 18, date: "25-08-24" },
    { category: "Car", amount: 30, date: "25-08-24" },
    { category: "Rent", amount: 600, date: "25-08-24" },
  ];

  return (
    <>
      <NavBar />
      <div className="grid grid-cols-12 gap-4 mt-8">
        <div className="col-start-2 col-span-10 border border-slate-400 rounded-lg p-4">
          <h2 className="text-2xl mb-4 mt-4">Incomes</h2>
          <table className="table border rounded-lg border-slate-200">
            {/* head */}
            <thead>
              <tr>
                <th className="text-lg font-bold">Category</th>
                <th className="text-lg font-bold">Amount</th>
                <th className="text-lg font-bold">Due Date</th>
                <th className="text-lg font-bold">Actions</th>
              </tr>
            </thead>
            <tbody>
              {incomes.map((income, index) => (
                <tr key={index}>
                  <td className="text-base">{income.category}</td>
                  <td className="text-base">£{income.amount}</td>
                  <td className="text-base">{income.date}</td>
                  <td>
                    <Link
                      to={`/income/${income.id}/update`}
                      className="btn btn-warning btn-sm mr-1"
                    >
                      Update
                    </Link>
                    <Link className="btn btn-error btn-sm">Delete</Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <Link to={`/income/add`} className="btn btn-success btn-sm w-36 mt-3">
            Add Income
          </Link>
        </div>
      </div>

      <div className="grid grid-cols-12 gap-4 mt-5">
        <div className="col-start-2 col-span-10 border border-slate-400 rounded-lg p-4">
          <h2 className="text-2xl mb-4 mt-4">Expenses</h2>
          <table className="table border rounded-lg border-slate-200">
            {/* head */}
            <thead>
              <tr>
                <th className="text-lg font-bold">Category</th>
                <th className="text-lg font-bold">Amount</th>
                <th className="text-lg font-bold">Due Date</th>
                <th className="text-lg font-bold">Actions</th>
              </tr>
            </thead>
            <tbody>
              {expenses.map((expense, index) => (
                <tr key={index}>
                  <td className="text-base">{expense.category}</td>
                  <td className="text-base">£{expense.amount}</td>
                  <td className="text-base">{expense.date}</td>
                  <td>
                    <Link
                      to={`/expense/${expense.id}/update`}
                      className="btn btn-warning btn-sm mr-1"
                    >
                      Update
                    </Link>
                    <Link className="btn btn-error btn-sm">Delete</Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <Link
            to={`/expense/add`}
            className="btn btn-success btn-sm w-36 mt-3"
          >
            Add expense
          </Link>
        </div>
      </div>
    </>
  );
}
