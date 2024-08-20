import NavBar from "../../components/NavBar";
import AccountProgress from "../../components/AccountProgress";
import ProgressCircle from "../../components/ProgressCircle";
import { useState } from "react";
import { Link } from "react-router-dom";

export default function SavingsPage() {
  const [showModalSavingGoalUpdate, setShowModalSavingGoalUpdate] =
    useState(false);

  const accounts = [
    { name: "LISA", value: 28560, risk: "Safe", description: "house deposit" },
    {
      name: "Crypto Currency",
      value: 22403,
      risk: "Risky",
      description: "Mostly invested in bitcoin with a few Alt-coins",
    },
    {
      name: "Cash",
      value: 4000,
      risk: "Safe",
      description: "Emergency money for Lego",
    },
  ];

  return (
    <>
      <NavBar />
      {showModalSavingGoalUpdate && (
        <div className="fixed inset-0 flex items-center justify-center z-50">
          <div className="modal modal-open">
            <div className="modal-box w-80 p-6">
              {" "}
              <form method="dialog">
                <button
                  className="btn btn-sm btn-circle btn-ghost absolute right-2 top-2"
                  onClick={() =>
                    setShowModalSavingGoalUpdate(!showModalSavingGoalUpdate)
                  }
                >
                  ✕
                </button>
                <h3 className="font-bold text-lg mb-4">Edit Savings Goal</h3>
                <input
                  type="text"
                  placeholder="Current - £70,000"
                  className="input input-bordered w-full mb-4 p-2 hover:border-indigo-500"
                  // value={username}
                  // onChange={(e) => setUsername(e.target.value)}
                />
                <button className="btn bg-indigo-500 w-full text-base p-2">
                  Update
                </button>
              </form>
            </div>
          </div>
        </div>
      )}

      <div className="grid grid-cols-12 gap-4">
        <div className="col-start-2 col-span-10">
          <h2 className="text-2xl mb-4 mt-4">Manage Savings</h2>

          <div className="stats shadow w-full p-4 border border-slate-400 rounded-lg">
            <div className="stat flex justify-between items-center grid grid-cols-8 gap-2">
              {/* Section 1: Total Savings */}
              <div className="flex flex-col justify-center items-center text-center col-start-1 col-end-2">
                <div className="stat-title">Total Savings</div>
                <div className="stat-value">£54,000</div>
                <div className="stat-desc">/£70,000 goal</div>

                <button
                  onClick={() =>
                    setShowModalSavingGoalUpdate(!showModalSavingGoalUpdate)
                  }
                  className="mt-6 btn border-indigo-500 w-40"
                >
                  Update goal
                </button>
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
        </div>
      </div>

      <div className="grid grid-cols-12 mt-10">
        <div className="col-start-2 col-span-10 border border-slate-400 rounded-lg p-4">
          <h2 className="text-2xl mb-4 ">Accounts</h2>
          <table className="table mt-5 border rounded-lg border-slate-400">
            {/* head */}
            <thead>
              <tr>
                <th className="text-lg font-bold">Account</th>
                <th className="text-lg font-bold">Value</th>
                <th className="text-lg font-bold">Risk Category</th>
                <th className="text-lg font-bold">Description</th>
                <th className="text-lg font-bold">Actions</th>
              </tr>
            </thead>
            <tbody>
              {accounts.map((account, index) => (
                <tr key={index}>
                  <td className="text-base">{account.name}</td>
                  <td className="text-base">£{account.value}</td>
                  <td>
                    <div
                      className={`badge badge-${
                        account.risk === "Safe" ? "success" : "warning"
                      } flex items-center justify-center text-base`}
                    >
                      {account.risk}
                    </div>
                  </td>
                  <td className="text-base">{account.description}</td>
                  <td>
                    <Link
                      className="btn btn-warning btn-sm mr-1"
                      to={`/savings/${account.id}/update`}
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
            className="btn btn-success btn-sm w-36 mt-3"
            to={"/savings-add"}
          >
            Add Account
          </Link>
        </div>
      </div>
    </>
  );
}
