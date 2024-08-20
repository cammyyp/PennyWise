import { Link } from "react-router-dom";
import NavBar from "../../components/NavBar";
import AccountProgress from "../../components/AccountProgress";
import ProgressCircle from "../../components/ProgressCircle";

export default function HomePage() {
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
      <div className="grid grid-cols-12 gap-4">
        <div className="col-start-2 col-span-10">
          <h2 className="text-2xl mb-4 mt-4">Dashboard</h2>

          <div className="stats shadow w-full p-4 border border-slate-400">
            <div className="stat flex justify-between items-center grid grid-cols-8 gap-2">
              {/* Section 1: Total Savings */}
              <div className="flex flex-col justify-center items-center text-center col-start-1 col-end-2">
                <div className="stat-title">Total Savings</div>
                <div className="stat-value">£54,000</div>
                <div className="stat-desc">/£70,000 goal</div>

                <Link
                  to={"/savings"}
                  className="mt-6 btn border-indigo-500 w-40"
                >
                  Manage savings
                </Link>
              </div>

              {/* Section 2: Radial Progress */}
              <div className="flex flex-col justify-center items-center col-start-2 col-end-5">
                <ProgressCircle progress={77} />
              </div>

              {/* Section 3: Saving Accounts */}
              <div className="flex flex-col justify-center items-start w-100 col-start-5 col-end-9">
                <h3 className="text-lg mb-2">Accounts:</h3>
                <AccountProgress
                  accountName="Lisa"
                  amount={28000}
                  className="progress progress-primary w-100 mb-2"
                  value={80}
                />
                <AccountProgress
                  accountName="Crypto Currency"
                  amount={18000}
                  className="progress progress-secondary w-100 mb-2"
                  value={54}
                />
                <AccountProgress
                  accountName="Cash"
                  amount={4000}
                  className="progress progress-accent w-100 mb-2"
                  value={20}
                />
              </div>
            </div>
          </div>

          <div className="stats stats-vertical lg:stats-horizontal grid grid-cols-2 gap-2 border border-slate-400 mt-10">
            <div className="stat col-start-1 col-end-2">
              <div className="stat-title">Total Income</div>
              <div className="stat-value">£4,000</div>
              <div className="stat-title mt-4">Recent transactions</div>
              <table className="table  border rounded-lg border-slate-200">
                {/* head */}
                <thead>
                  <tr>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Due Date</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {incomes.map((income, index) => {
                    return (
                      <tr key={index}>
                        <td>{income.category}</td>
                        <td>£{income.amount}</td>
                        <td>{income.date}</td>
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
                    );
                  })}
                </tbody>
              </table>
              <Link
                to={`/income/add`}
                className="btn btn-success btn-sm w-36 mt-3"
              >
                Add Income
              </Link>
            </div>

            <div className="stat col-start-2 col-end-4">
              <div className="stat-title">Total Expenses</div>
              <div className="stat-value">£1,550</div>
              <div className="stat-title mt-4">Recent transactions</div>
              <table className="table border rounded-lg border-slate-200">
                {/* head */}
                <thead>
                  <tr>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Due Date</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {expenses.map((expense, index) => {
                    return (
                      <tr key={index}>
                        <td>{expense.category}</td>
                        <td>£{expense.amount}</td>
                        <td>{expense.date}</td>
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
                    );
                  })}
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
        </div>
      </div>
    </>
  );
}
